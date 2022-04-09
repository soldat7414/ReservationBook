package views;

import controllers.InitController;
import controllers.ReservationController;
import services.InputService;

import java.util.Scanner;

public class MainView {
    public static void mainView(Scanner scanner){
        String message;
        message = "Вас приветствует программа КНИГА РЕЗЕРВИРОВАНИЯ!\n" +
                "------------------------------------------------";
        System.out.println(message);
        if(InitController.isThereSaved()){
            message = "Книга резервирования уже была создана.\n" +
                    "Если хотите ее открыть введите 'o', Если хотите создать новую книгу введите 'new': ";
//            System.out.print(message);
            int mark = -1;
            do {
                String answer = InputService.txt(scanner, message);
                if (answer.equals("o")) {
                    InitController.restore();
                    mark = 1;
                } else if (answer.equals("new")) {
                    InitController.deleteSaves();
                    InitController.init(scanner);
                    InitController.save();
                    mark = 1;
                } else {
                    message = "Введите 'о', чтоб открыть книгу или 'new', чтоб создать новую!";
                }
            }while (mark<0);
        } else {
            InitController.init(scanner);
            InitController.save();
        }
        int answerInt;
        do{
            message = "В настоящий момент доступны следующие действия с книгой: \n" +
                    "1. Зарезервировать номер в отеле;\n" +
                    "2. Удалить резервацию;\n" +
                    "3. Информация об отеле;\n" +
                    "4. Сохранить и закрыть;\n" +
                    "5. Удалить отель;\n" +
                    "Сделайте пожалуйста свой выбор: ";

        //System.out.print(message);
        answerInt = InputService.inputIntInRange(scanner, message, 5);
        switch (answerInt) {
            case 1: {
                ReservationController.addReservation(scanner);
                InitController.save();
                break;
            }
            case 2: {
                ReservationController.deleteReservation(scanner);
                InitController.save();
                break;
            }
            case 3: {
                ReservationController.getInfo();
                break;
            }
            case 4: {
                InitController.save();
                break;
            }
            case 5: {
                InitController.deleteSaves();
                InitController.init(scanner);
                InitController.save();
                break;
            }
        }
        }while (answerInt != 4);

    }
}
