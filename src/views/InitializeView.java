package views;

import data.Hotel;
import services.InputService;

import java.util.Scanner;

public class InitializeView {

    private static String message;
    private static int numberOfRooms;
    private static double price;

    public static void initHotel(Scanner scanner){
        message = "Введите название отеля: ";
        Hotel.setTitle(InputService.txt(scanner, message));

        message = "Введите количество комнат: ";
        numberOfRooms = InputService.inputInt(scanner, message);

        message = "Введите цену аренды за сутки: ";
        price = InputService.inputDouble(scanner, message);
    }

    public static int getNumberOfRooms() {
        return numberOfRooms;
    }

    public static double getPrice() {
        return price;
    }
}
