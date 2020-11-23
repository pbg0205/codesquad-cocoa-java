class Board {
    private static final int RANGE_MAX = 4;
    private boolean[][] hasNumber;
    private Number[][] numberArray;

    public Board() {
        this.hasNumber = new boolean[RANGE_MAX][RANGE_MAX];
        this.numberArray = new Number[RANGE_MAX][RANGE_MAX];

        makeNumber(RandomCreator.create(), RandomCreator.create(), 2);
        makeNumber(RandomCreator.create(), RandomCreator.create(), 4);
    }

    private void makeNumber(int row, int col, int number) {
        if (!hasNumber[row][col]) {
            numberArray[row][col] = new Number(number);
            hasNumber[row][col] = true;
        } else {
            makeNumber(row, col, number);
        }
    }

    /*
     * 위로 이동
     */
    public void moveUp() {
        for (int col = 0; col < RANGE_MAX; col++) {
            checkUpwardMovement(col);
        }
    }

    private void checkUpwardMovement(int col) {
        for (int row = RANGE_MAX - 2; row >= 0; row--) {
            Number thisNumber = numberArray[row][col];
            Number otherNumber = numberArray[row + 1][col];

            if (isNull(thisNumber) && isNull(otherNumber)) {
                continue;
            }

            checkMovingUpperRow(thisNumber, otherNumber, row, col);
            checkUpperMultiply(thisNumber, otherNumber, row, col);
        }
    }

    private void checkMovingUpperRow(Number thisNumber, Number otherNumber, int row, int col) {
        if (isNull(thisNumber) && !isNull(otherNumber)) {
            numberArray[row][col] = numberArray[row + 1][col];
            numberArray[row + 1][col] = null;
        }
    }

    private void checkUpperMultiply(Number thisNumber, Number otherNumber, int row, int col) {
        if (isNull(thisNumber) || isNull(otherNumber)) {
            return;
        }

        if (!isSameNumber(thisNumber, otherNumber)) {
            return;
        }

        numberArray[row][col].multiply();
        numberArray[row + 1][col] = null;
    }

    public boolean isSameNumber(Number thisNumber, Number otherNumber) {
        return thisNumber.equals(otherNumber);
    }

    private boolean isNull(Number thisNumber) {
        return thisNumber == null;
    }

    /*
     * 범위 확인
     */
    private boolean isBoundary(int x, int y) {
        return ((0 <= x) && (x < RANGE_MAX)) && ((0 <= y) && (y < RANGE_MAX));
    }

    /*
     * 맵 상황 출력
     */
    public void printMapStatus() {
        for (int row = 0; row < RANGE_MAX; row++) {
            printEachColumn(row);
        }
    }

    private void printEachColumn(int row) {
        for (int col = 0; col < RANGE_MAX; col++) {
            printStatus(row, col);
        }
        System.out.println();
    }

    private void printStatus(int row, int col) {
        if (numberArray[row][col] == null) {
            System.out.printf("0");
        } else {
            System.out.printf("%s", numberArray[row][col]);
        }
    }
}
