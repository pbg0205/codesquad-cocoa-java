package hangulclock;

public class Checker {
    private final int MAX_RANGE = 6;
    private boolean[][] checker;

    public Checker() {
        this.checker = new boolean[MAX_RANGE][MAX_RANGE];
    }

    public boolean[][] getChecker() {
        return checker;
    }

    public void checkTime(Time time) {
        checkHour(time);
        checkMinute(time);
        checkAM_PM(time);
    }

    private void checkAM_PM(Time time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour == 0 && minute == 0) {
            checkAM(time);
            checkPM(time);
            checker[3][0] = true;
            checker[4][0] = true;
        }
    }

    private void checkPM(Time time) {
        String period = time.getPeriod();
        if (period.equals("AM")) {
            checker[3][0] = true;
            checker[4][0] = true;
        }
    }

    private void checkAM(Time time) {
        String period = time.getPeriod();
        if (period.equals("PM")) {
            checker[4][0] = true;
            checker[5][0] = true;
        }
    }

    private void checkHour(Time time) {
        checker[2][5] = true;
        int hour = time.getHour();

        switch (hour) {
            case 1:
                checker[0][0] = true;
                break;
            case 2:
                checker[0][1] = true;
                break;
            case 3:
                checker[0][2] = true;
                break;
            case 4:
                checker[0][3] = true;
                break;
            case 5:
                checker[0][4] = true;
                break;
            case 6:
                checker[1][0] = true;
                checker[1][1] = true;
                break;
            case 7:
                checker[1][2] = true;
                checker[1][3] = true;
                break;
            case 8:
                checker[1][4] = true;
                checker[1][5] = true;
                break;
            case 9:
                checker[2][0] = true;
                checker[2][1] = true;
                break;
            case 10:
                checker[2][2] = true;
                break;
            case 11:
                checker[2][2] = true;
                checker[2][3] = true;
                break;
            case 12:
                checker[2][2] = true;
                checker[2][4] = true;
                break;
        }
    }

    private void checkMinute(Time time) {
        checker[5][5] = true;
        int minute = time.getMinute();
        int tens = minute / 10;
        int units = minute % 10;

        checkTens(tens);
        checkUnits(units);
    }

    private void checkTens(int tens) {
        checker[3][5] = tens > 0 ? true : false;
        switch (tens) {
            case 2:
                checker[3][1] = true;
                break;
            case 3:
                checker[3][2] = true;
                break;
            case 4:
                checker[3][3] = true;
                break;
            case 5:
                checker[3][4] = true;
                break;
        }
    }

    private void checkUnits(int units) {
        checker[5][5] = true;

        switch (units) {
            case 1:
                checker[4][1] = true;
                break;
            case 2:
                checker[4][2] = true;
                break;
            case 3:
                checker[4][3] = true;
                break;
            case 4:
                checker[4][4] = true;
                break;
            case 5:
                checker[5][1] = true;
                break;
            case 6:
                checker[4][5] = true;
                break;
            case 7:
                checker[5][2] = true;
                break;
            case 8:
                checker[5][3] = true;
                break;
            case 9:
                checker[5][4] = true;
                break;
        }
    }
}
