package account_book;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputStringValue(){
        return scanner.nextLine();
    }

    public static int inputIntValue(){
        return toInt(scanner.nextLine());
    }

    public static int toInt(String value){
        return Integer.parseInt(value);
    }
}
