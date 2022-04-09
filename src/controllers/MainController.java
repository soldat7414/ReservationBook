package controllers;

import views.MainView;

import java.util.Scanner;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class MainController {

    public static void runApp(){
        Scanner scanner = new Scanner(System.in);

        MainView.mainView(scanner);

        scanner.close();

    }
}
