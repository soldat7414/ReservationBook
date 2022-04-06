package services;

import exceptions.EmptyInputException;
import exceptions.NegativeValueException;
import exceptions.NotNumberException;

import java.util.Scanner;

public class Inputs {

    //input validation
    private static Scanner isEmpty (Scanner scanner) throws EmptyInputException {
        if(!scanner.hasNext()) throw new EmptyInputException("Вы не ввели значение!");
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





    //input data
    public static String txt (Scanner scanner, String message){
        String txt = null;
        do{
            System.out.print(message);
            try{
                txt = isEmpty(scanner).nextLine();
            } catch (EmptyInputException ex){
                System.out.println(ex.getMessage());
            }
        } while (txt==null);
        return txt;
    }

    public static int inputInt (Scanner scanner, String message){
        int input = -1;

        do{
            System.out.print(message);
            try{
                input = isPositive(isInt(isEmpty(scanner)));
            } catch (EmptyInputException emptyInputException){
                System.out.println(emptyInputException.getMessage());
            } catch (NotNumberException notNumberException){
                System.out.println(notNumberException.getInput() + notNumberException.getMessage());
            } catch (NegativeValueException negativeValueException){
                System.out.println(negativeValueException.getValue() + negativeValueException.getMessage());
            }
        }while (input<0);
        return input;
    }

    public static double inputDouble (Scanner scanner, String message){
        double input = -1;
        do{
            System.out.print(message);
            try{
                input = isPositive(isDouble(isEmpty(scanner)));
            } catch (EmptyInputException emptyInputException){
                System.out.println(emptyInputException.getMessage());
            } catch (NotNumberException notNumberException){
                System.out.println(notNumberException.getInput() + notNumberException.getMessage());
            } catch (NegativeValueException negativeValueException){
                System.out.println(negativeValueException.getValue() + negativeValueException.getMessage());
            }
        }while (input<0);
        return input;
    }


}
