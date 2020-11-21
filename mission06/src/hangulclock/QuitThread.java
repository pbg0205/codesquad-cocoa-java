package hangulclock;

import java.util.Scanner;

public class QuitThread extends Thread{
    private Scanner scanner;

    public QuitThread () {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(){
        quick();
    }

    public void quick(){
        int quickNumber;

        while(true) {
            quickNumber = Integer.parseInt(scanner.nextLine());

            if(quickNumber == 0) {
                System.exit(0);
            }
        }
    }
}
