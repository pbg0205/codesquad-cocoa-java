import java.util.LinkedList;
import java.util.Queue;

class Board {
    private static final int RANGE_MAX = 4;

    private Number[][] numberArray;

    public Board() {
        initNumberArray();
    }

    private void initNumberArray() {
        this.numberArray = new Number[RANGE_MAX][RANGE_MAX];

        for (int row = 0; row < RANGE_MAX; row++) {
            initColumn(row);
        }

        generateNumber(2);
        generateNumber(4);
    }

    private void initColumn(int row) {
        for (int col = 0; col < RANGE_MAX; col++) {
            this.numberArray[row][col] = Number.zero();
        }
    }

    public void generateNumber(int number) {
        boolean initNumber = false;
        int row;
        int col;

        while (!initNumber) {
            row = RandomCreator.create();
            col = RandomCreator.create();

            if (this.numberArray[row][col].equals(Number.zero())) {
                this.numberArray[row][col] = new Number(number);
                initNumber = true;
            }
        }
    }

    /*
     * 위로 이동
     */
    public void moveToUp() {
        for (int col = 0; col < RANGE_MAX; col++) {
            checkUpwardMovement(col);
        }
    }

    private void checkUpwardMovement(int col) {
        Queue<Number> queue = new LinkedList<>();

        for (int row = 0; row < RANGE_MAX; row++) {
            Number thisNumber = this.numberArray[row][col];

            if (thisNumber.equals(Number.zero())) {
                continue;
            }
            queue.add(thisNumber);
        }

        queue = checkMultiply(queue);
        moveElementsToUp(queue, col);
    }

    private void moveElementsToUp(Queue<Number> queue, int col) {
        int row = 0;

        while (row < RANGE_MAX) {
            if (!queue.isEmpty()) {
                Number number = queue.poll();
                this.numberArray[row++][col] = number;
                continue;
            }

            this.numberArray[row++][col] = Number.zero();
        }
    }

    /*
     * 아래로 이동
     */
    public void moveToUnder() {
        for (int col = 0; col < RANGE_MAX; col++) {
            checkDownwardMovement(col);
        }
    }

    private void checkDownwardMovement(int col) {
        Queue<Number> queue = new LinkedList<>();

        for (int row = RANGE_MAX - 1; row >= 0; row--) {
            Number thisNumber = this.numberArray[row][col];

            if (thisNumber.equals(Number.zero())) {
                continue;
            }

            queue.add(thisNumber);
        }
        queue = checkMultiply(queue);
        moveElementsToDown(queue, col);
    }

    private void moveElementsToDown(Queue<Number> queue, int col) {
        int row = RANGE_MAX - 1;

        while (row >= 0) {
            if (!queue.isEmpty()) {
                Number number = queue.poll();
                this.numberArray[row--][col] = number;
                continue;
            }

            this.numberArray[row--][col] = Number.zero();
        }
    }

    /*
     * 왼쪽 이동
     */
    public void moveToLeft() {
        for (int row = 0; row < RANGE_MAX; row++) {
            checkLeftMovement(row);
        }
    }

    private void checkLeftMovement(int row) {
        Queue<Number> queue = new LinkedList<>();

        for (int col = 0; col < RANGE_MAX; col++) {
            Number thisNumber = this.numberArray[row][col];

            if (thisNumber.equals(Number.zero())) {
                continue;
            }

            queue.add(thisNumber);
        }
        queue = checkMultiply(queue);
        moveElementsToLeft(queue, row);
    }

    private void moveElementsToLeft(Queue<Number> queue, int row) {
        int col = 0;

        while (col < RANGE_MAX) {
            if (!queue.isEmpty()) {
                Number number = queue.poll();
                this.numberArray[row][col++] = number;
                continue;
            }

            this.numberArray[row][col++] = Number.zero();
        }
    }

    public void moveToRight() {
        for (int row = RANGE_MAX - 1; row >= 0; row--) {
            checkRightMovement(row);
        }
    }

    private void checkRightMovement(int row) {
        Queue<Number> queue = new LinkedList<>();

        for (int col = RANGE_MAX - 1; col >= 0; col--) {
            Number thisNumber = this.numberArray[row][col];

            if (thisNumber.equals(Number.zero())) {
                continue;
            }

            queue.add(thisNumber);
        }
        queue = checkMultiply(queue);
        moveElementsToRight(queue, row);
    }

    private void moveElementsToRight(Queue<Number> queue, int row) {
        int col = RANGE_MAX - 1;

        while (col >= 0) {
            if (!queue.isEmpty()) {
                Number number = queue.poll();
                this.numberArray[row][col--] = number;
                continue;
            }

            this.numberArray[row][col--] = Number.zero();
        }
    }

    /*
     * 두 수가 같을 경우, 두 수를 합산.
     */
    private boolean areSameNumbers(Number thisNumber, Number otherNumber) {
        return thisNumber.equals(otherNumber);
    }

    private Queue<Number> checkMultiply(Queue<Number> queue) {
        Queue<Number> queue_temp = new LinkedList<>();
        Number firstNumber;
        Number secondNumber;

        if (queue.size() == 1) {
            firstNumber = queue.poll();
            queue_temp.add(firstNumber);
            return queue_temp;
        }

        firstNumber = queue.poll();

        while (!queue.isEmpty()) {
            secondNumber = queue.peek();

            if (areSameNumbers(firstNumber, secondNumber)) {
                firstNumber.multiply();
            } else {
                queue_temp.add(firstNumber);
                firstNumber = secondNumber;
            }
            queue.poll();

            if (queue.isEmpty()) {
                queue_temp.add(firstNumber);
            }
        }

        return queue_temp;
    }

    /*
     * 승리 조건 탐색
     */
    public boolean checkHaving2048() {
        boolean has2048 = false;
        for (int row = 0; row < RANGE_MAX; row++) {
            has2048 = iterateColumn(row);
        }

        return has2048;
    }

    private boolean iterateColumn(int row) {
        boolean has2048 = false;

        for (int col = 0; col < RANGE_MAX; col++) {
            has2048 = check2048(row, col);
        }

        return has2048;
    }

    private boolean check2048(int row, int col) {
        return this.numberArray[row][col].is2048();
    }

    public boolean isFinish() {
        Queue<Number> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        final int DIRECTION_MAX = 4;

        queue.add(this.numberArray[0][0]);

        while (!queue.isEmpty()) {
            Number thisNumber = queue.poll();

            for (int index = 0; index < DIRECTION_MAX; index++) {
                int nx = thisNumber.getNumber() + dx[index];
                int ny = thisNumber.getNumber() + dy[index];

                if (isZero(nx, ny)) {
                    return false;
                }

                if (isBoundary(nx, ny)) {
                    queue.add(this.numberArray[nx][ny]);
                }
            }
        }
        return true;
    }

    private boolean isBoundary(int x, int y) {
        return ((0 <= x) && (x < RANGE_MAX)) && ((0 <= y) && (y < RANGE_MAX));
    }

    private boolean isZero(int row, int col) {
        return this.numberArray[row][col].equals(Number.zero());
    }

    private boolean checkZero(int row, int col) {
        return this.numberArray[row][col].equals(Number.zero());
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
        System.out.printf("%5s", numberArray[row][col]);
    }
}