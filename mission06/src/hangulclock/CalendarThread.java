package hangulclock;

import squadcalendar.SquadCalendar;

public class CalendarThread extends Thread{
    private SquadCalendar squadCalendar;

    public CalendarThread() {
        this.squadCalendar = new SquadCalendar();
    }

    @Override
    public void run() {
        while(true) {
            squadCalendar.printCalendar();
        }
    }
}
