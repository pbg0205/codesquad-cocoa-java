package gugudan;

import gugudan.domain.Gugudan;
import gugudan.domain.Manual;
import gugudan.validator.Validator;

import java.util.*;

class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String value;
        Validator validator;
        List<Gugudan> gugudanList;
        Manual manual = new Manual();

        manual.printManual();

        do {
            manual.printInputMessage();
            value = scanner.nextLine();
            validator = new Validator(value);
        } while (!validator.AllValidation());

        gugudanList = makeGugudanList(value);

        printGugudans(gugudanList);

        manual.printFinishMessage();
    }

    public static List<Gugudan> makeGugudanList(String value) {
        String[] values = value.split(" ");
        int startNumber = Integer.parseInt(values[0]);
        int endNumber = Integer.parseInt(values[1]);

        List<Gugudan> gugudanList = new ArrayList<>();

        for (int dan = startNumber; dan <= endNumber; dan++) {
            gugudanList.add(new Gugudan(dan));
        }

        return gugudanList;
    }

    public static void printGugudans(List<Gugudan> gugudanList) {
        for (Gugudan gugudan : gugudanList) {
            gugudan.print();
        }
    }
}
