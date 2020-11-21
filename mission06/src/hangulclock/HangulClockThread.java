package hangulclock;

public class HangulClockThread extends Thread {
    private Time time;
    private Checker checker;
    private HangulClock hangulClock;

    public HangulClockThread(){
        this.checker = new Checker();
        this.hangulClock = new HangulClock();
    }

    @Override
    public void run() {
        int oneMinute = 1000 * 60;

        while(true) {
            time = new Time();
            checker.checkTime(time);
            hangulClock.printHangulClock(checker);

            try {
                System.out.println("종료 번호 : 0");
                Thread.sleep(oneMinute);
            }catch(InterruptedException e) {
            }
        }
    }
}
