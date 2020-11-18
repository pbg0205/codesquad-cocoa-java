package hangulclock;

public class Main {
    public static void main(String[] args) {
        Time time = new Time();
        Checker checker = new Checker();
        HangulClock hangulClock = new HangulClock();

        checker.checkTime(time);
        hangulClock.printHangulClock(checker);

        SquadCalendar squadCalendar = new SquadCalendar();
        squadCalendar.printCalendar();
    }
}
