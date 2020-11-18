package calendar;

import java.util.Calendar;

public class SquadCalendar {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private static final int ROW_RANGE = 6;
    private static final int COL_RANGE = 7;

    private int[][] monthCalender;
    private Calendar nowCalendar;

    public SquadCalendar() {
        this.monthCalender = new int[ROW_RANGE][COL_RANGE];
        makeCalendar();
    }

    private void makeCalendar() {
        this.nowCalendar = Calendar.getInstance();

        int year = nowCalendar.get(Calendar.YEAR);
        int startColumn = nowCalendar.get(Calendar.DAY_OF_WEEK);
        int month = nowCalendar.get(Calendar.MONTH) + 1;
        int lastDay = nowCalendar.getActualMaximum(Calendar.DATE) + 1;

        insertDate(startColumn, lastDay);
    }

    private void insertDate(int startColumn, int lastDay) {
        int date = 1;
        int row = 0;
        int col = startColumn >= 7 ? 0 : startColumn;

        while (row < ROW_RANGE && date < lastDay) {
            if (col >= COL_RANGE) {
                col = 0;
                row++;
                continue;
            }
            this.monthCalender[row][col] = date++;
            col++;
        }

    }

    public void printCalendar() {
        printIndex();
        printRow();
    }

    private void printIndex() {
        int year = nowCalendar.get(Calendar.YEAR);
        int month = nowCalendar.get(Calendar.MONTH) + 1;
        System.out.println("===========================");
        System.out.printf("      %4d년    %2d월         \n", year, month);
        System.out.println("===========================");
        System.out.printf("%3s %3s %3s %3s %3s %3s %3s\n",
                "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT");
    }

    private void printRow() {
        for (int row = 0; row < ROW_RANGE; row++) {
            printColumn(row);
        }
    }

    private void printColumn(int row) {
        for (int col = 0; col < COL_RANGE; col++) {
            printDate(row, col);
        }
        System.out.println();
    }

    private void printDate(int row, int col) {
        if (this.monthCalender[row][col] == 0) {
            System.out.printf("%3s ", " ");
        } else {
            checkNowDay(row, col);
        }
    }

    private void checkNowDay(int row, int col) {
        int nowDate = nowCalendar.get(Calendar.DAY_OF_MONTH);
        if (this.monthCalender[row][col] == nowDate) {
            System.out.printf("%s%3s%s ", ANSI_RED, this.monthCalender[row][col], ANSI_RESET);
            return;
        }
        System.out.printf("%3s ", this.monthCalender[row][col]);

    }
}
