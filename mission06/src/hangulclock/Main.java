package hangulclock;

public class Main {
    public static void main(String[] args) {
        HangulClockThread hangulClockThread = new HangulClockThread();
        QuitThread quitThread = new QuitThread();

        hangulClockThread.start();
        quitThread.start();
    }
}
