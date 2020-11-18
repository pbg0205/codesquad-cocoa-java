package hangul;

public class HangulClock {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private final int MAX_RANGE = 6;
    private String[][] hangulClock;

    public HangulClock() {
        this.hangulClock = initHanguleClock();
    }

    private String[][] initHanguleClock() {
        String[][] hangulClock = {{"한", "두", "세", "네", "다", "섯"},
                {"여", "섯", "일", "곱", "여", "덟"},
                {"아", "홉", "열", "한", "두", "시"},
                {"자", "이", "삼", "사", "오", "십"},
                {"정", "일", "이", "삼", "사", "육"},
                {"오", "오", "칠", "팔", "구", "분"}};

        return hangulClock;
    }

    public void printHangulClock(Checker checker) {
        for (int row = 0; row < MAX_RANGE; row++) {
            printColumn(row, checker);
        }
    }

    private void printColumn(int row, Checker checker) {
        boolean[][] checkerArr = checker.getChecker();

        for (int col = 0; col < MAX_RANGE; col++) {
            if (checkerArr[row][col]) {
                printRed(row, col);
                continue;
            }
            printNormal(row, col);
        }
        System.out.println();
    }

    private void printNormal(int row, int col) {
        System.out.print(this.hangulClock[row][col] + " ");
    }

    private void printRed(int row, int col) {
        System.out.print(ANSI_RED + this.hangulClock[row][col] + " " + ANSI_RESET);
    }
}