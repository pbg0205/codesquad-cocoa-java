package hangul;

import java.util.Calendar;

public class Time {
    private static final String AM = "AM";
    private static final  String PM = "PM";

    private int hour;
    private int minute;
    private int second;
    private String period;

    public Time() {
        initTime();
    }


    private void initTime() {
        Calendar cal = Calendar.getInstance();

        this.hour = cal.get(Calendar.HOUR);
        this.minute = cal.get(Calendar.MINUTE);
        this.second = cal.get(Calendar.SECOND);
        this.period = getMidDayOrNight(cal.get(Calendar.AM_PM));
    }

    private String getMidDayOrNight(int am_pm_index) {
        return am_pm_index == 0 ? AM : PM;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getPeriod() {
        return period;
    }
}