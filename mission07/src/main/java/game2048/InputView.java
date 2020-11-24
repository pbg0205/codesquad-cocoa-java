package game2048;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCommand() {
        return scanner.nextLine();
    }
}
