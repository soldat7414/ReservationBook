package views;

import controllers.InitController;
import controllers.ReservationController;
import services.InputService;

import java.util.Scanner;

public class MainView {
    public static void mainView(Scanner scanner){
        String message;
        message = "Вас приветствует программа КНИГА РЕЗЕРВИРОВАНИЯ!";
        System.out.println(message);
        if(InitController.isThereSaved()){
            message = "Книга резервирования уже была создана.\n" +
                    "Если хотите ее открыть введите 'o', Если хотите создать новую книгу введите 'n': ";
//            System.out.print(message);
            int mark = -1;
            do {
                String answer = InputService.txt(scanner, message);
                if (answer.equals("o")) {
                    InitController.restore();
                    mark = 1;
                } else if (answer.equals("n")) {
                    InitController.deleteSaves();
                    InitController.init(scanner);
                    mark = 1;
                } else {
                    message = "Введите 'о', чтоб открыть книгу или 'n', чтоб создать новую!";
                }
            }while (mark<0);
        }
        int answerInt;
        do{
            message = "В настоящий момент доступны следующие действия с книгой: \n" +
                    "1. Зарезервировать номер в отеле;\n" +
                    "2. Удалить резервацию;\n" +
                    "3. Просмотреть данные о комнате;\n" +
                    "4. Сохранить и закрыть\n" +
                    "Сделайте пожалуйста свой выбор: ";

        //System.out.print(message);
        answerInt = InputService.inputIntInRange(scanner, message, 4);
        switch (answerInt) {
            case 1: {
                ReservationController.addReservation(scanner);
                break;
            }
            case 2: {
                ReservationController.deleteReservation(scanner);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                InitController.save();

            }
        }
        }while (answerInt != 4);

    }
}
