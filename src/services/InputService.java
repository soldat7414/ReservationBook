package services;

import data.Hotel;
import exceptions.*;
import models.FromTo;
import models.Reservation;
import tools.Format;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class InputService {
    private static List<FromTo> reserved;

    //input validation
    private static Scanner isEmpty (Scanner scanner) throws EmptyInputException {
        if(!scanner.hasNextLine()) throw new EmptyInputException("Вы не ввели значение!");
        return scanner;
    }

    private static int isInt (Scanner scanner) throws NotNumberException {
        if(!scanner.hasNextInt()) throw new NotNumberException("- не является целым числом!", scanner.nextLine().trim());
        return scanner.nextInt();
    }

    private static double isDouble (Scanner scanner) throws NotNumberException {
        if(!scanner.hasNextDouble()) throw new NotNumberException("- не является числом!", scanner.nextLine().trim());
        return scanner.nextDouble();
    }

    private static int isPositive (int value) throws NegativeValueException {
        if(value<=0) throw new NegativeValueException("Вы ввели негативное значение. Значение должно быть больше ноля!", value);
        return value;
    }

    private static double isPositive (double value) throws NegativeValueException {
        if(value<=0) throw new NegativeValueException("Вы ввели негативное значение. Значение должно быть больше ноля!", value);
        return value;
    }

    private static int inRangeOfRooms (int value) throws OutOfQuantityRoomException {
        if (value > Hotel.getHotel().size()) throw new OutOfQuantityRoomException("Такого номера у нас нет!");
        return value;
    }

    private static FromTo fromInAvailablePeriod (Date date, List<Reservation> reserved) throws ReservedPeriodException, PastDataException {
        long d = date.getTime();
        if(d < new Date().getTime()) throw new PastDataException("Мы не можем забронировать номер задним числом!");
        for (Reservation ft : reserved){
            if(ft.getFrom().getTime() <= d && ft.getTo().getTime() >= d) throw new ReservedPeriodException(
                    "Дата попадает в зарезервированный период: ", new FromTo(ft.getFrom(), ft.getTo()));
        }

        for (int i = 0; i < reserved.size(); i++){
            if(d < reserved.get(i).getFrom().getTime()) return new FromTo(date, reserved.get(i).getFrom());
        }
        return new FromTo(date, Format.parseDate("31-12-2022"));
    }

    private static FromTo fromToAvailable (FromTo ft, Date range) throws ReservedPeriodException, PastDataException {
       if(ft.getFrom().getTime() > ft.getTo().getTime()) throw new PastDataException("Дата выезда должна быть позже даты въезда!");
       if(range.getTime() < ft.getTo().getTime()) throw new ReservedPeriodException("Дата выезда должна быть до ", new FromTo(ft.getFrom(),range));
       return ft;
    }





    //input data
    public static String txt (Scanner scanner, String message) {
        String txt = null;
        do{
            System.out.print(message);
            try{
                if(scanner.hasNextLine()){
                txt = scanner.nextLine();
                if(txt.length()==0) txt = null;}
            } catch (NoSuchElementException ex){
                System.out.println("txt" + ex.getMessage());
            }
        } while (txt==null);
        return txt;
    }

    public static int inputInt (Scanner scanner, String message) {
        int input = -1;

        do{
            System.out.print(message);
            try{
                input = isPositive(isInt(isEmpty(scanner)));
            } catch (EmptyInputException emptyInputException){
                System.out.println("int"+emptyInputException.getMessage());
            } catch (NotNumberException notNumberException){
                System.out.println(notNumberException.getInput() + notNumberException.getMessage());
            } catch (NegativeValueException negativeValueException){
                System.out.println(negativeValueException.getValue() + negativeValueException.getMessage());
            }
        }while (input<0);
        return input;
    }

    public static int inputIntInRange (Scanner scanner, String message, int range) {
        int input = -1;

        do{
            System.out.print(message);
            try{
                input = isPositive(isInt(isEmpty(scanner)));
                if(input > range){
                    input = -1;
                    throw new OutOfQuantityRoomException("Записи с таким номером нет!");
                }
            } catch (EmptyInputException emptyInputException){
                System.out.println("ii" + emptyInputException.getMessage());
            } catch (NotNumberException notNumberException){
                System.out.println(notNumberException.getInput() + notNumberException.getMessage());
            } catch (NegativeValueException negativeValueException){
                System.out.println(negativeValueException.getValue() + negativeValueException.getMessage());
            } catch ( OutOfQuantityRoomException oo){
                System.out.println(oo.getMessage());
            }
        }while (input<0);
        return input;
    }

    public static double inputDouble (Scanner scanner, String message) {
        double input = -1;
        do{
            System.out.print(message);
            try{
                input = isPositive(isDouble(isEmpty(scanner)));
            } catch (EmptyInputException emptyInputException){
                System.out.println("do"+emptyInputException.getMessage());
            } catch (NotNumberException notNumberException){
                System.out.println(notNumberException.getInput() + notNumberException.getMessage());
            } catch (NegativeValueException negativeValueException){
                System.out.println(negativeValueException.getValue() + negativeValueException.getMessage());
            }
        }while (input<0);
        return input;
    }

    public static int getNumberOfRoom (Scanner scanner, String message) {
        int value = -1;
        do {
            System.out.println(message);
            try{
                value = inRangeOfRooms(inputInt(scanner, ""));
            } catch (OutOfQuantityRoomException ex){
                System.out.println(ex.getMessage());
            }
        }while (value<0);
        return value;
    }

    public static FromTo getArriveDate (Scanner scanner, String message, List<Reservation> reserved) {
        //ft.from - arrive date
        //ft.to - available period
        FromTo ft = null;
        System.out.println(message);
        do{
            try{
                    Date from = Format.format(txt(scanner, ""));
                    ft = fromInAvailablePeriod(from, reserved);
            } catch (ParseException pe) {
                System.out.println("Не верный формат даты! Необходимый формат: дд-мм-гггг");
            } catch (PastDataException pde){
                System.out.println(pde.getMessage());
            } catch (ReservedPeriodException rpe){
                System.out.println(rpe.getMessage() + rpe.getReservedPeriod().toString());
            }
        } while (ft == null);
        return ft;
    }

    public static FromTo getOutDate (Scanner scanner, String message, FromTo fromRange){
        //ft.from - arrive date
        //ft.to - out date
        FromTo ft = null;
        do{
            System.out.println(message);
            try{
                ft = fromToAvailable(new FromTo(fromRange.getFrom(),Format.format(scanner.nextLine())),fromRange.getTo());
            } catch (ParseException pe) {
                System.out.println("Не верный формат даты! Необходимый формат: дд-мм-ггг");
            } catch (PastDataException pde){
                System.out.println(pde.getMessage());
            } catch (ReservedPeriodException rpe) {
                System.out.println(rpe.getMessage());
            }
        } while (ft == null);
        return ft;
    }





}
