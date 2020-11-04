package rpg.view;

import rpg.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private static InputValidator inputValidator = new InputValidator();

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCommand(){
        String command = "";
        boolean result;

        do {
            System.out.println("나아갈 방향을 선택해주세요");
            System.out.println("위(W), 아래(S), 왼쪽(A), 오른쪽(D)");
            command = scanner.nextLine();
            result = inputValidator.AllValidation(command);
        }while(result);

        return command;
    }
}
