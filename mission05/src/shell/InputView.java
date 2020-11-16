package shell;

import java.util.Scanner;

class InputView {
    private static Scanner scanner = new Scanner(System.in);

    static String inputAsString(){
        return scanner.nextLine();
    }

    private static int toInt(String value){
        return Integer.parseInt(value);
    }
}
