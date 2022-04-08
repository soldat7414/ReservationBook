package controllers;

import views.MainView;

import java.util.Scanner;

public class MainController {

    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        MainView.mainView(scanner);
        scanner.close();
    }
}
