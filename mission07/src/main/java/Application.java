class Application extends Thread {
    private Board board;
    private Command command;

    public Application() {
        this.board = new Board();
    }

    @Override
    public void run() {
        board.printMapStatus();

        while (true) {
            actionCommand();
        }
    }

    public void actionCommand() {
        setCommand(InputView.inputCommand());

        if (command == Command.UP) {
            board.moveToUp();
        }

        if (command == Command.DOWN) {
            board.moveToUnder();
        }

        if (command == Command.LEFT) {
            board.moveToLeft();
        }

        if (command == Command.RIGHT) {
            board.moveToRight();
        }

        checkWinner();
        checkFinish();
    }

    private void checkWinner() {
        if (board.checkHaving2048()) {
            System.out.println("승리하셨습니다!");
            exitMessage();
        }
    }

    private void checkFinish() {
        if (board.isFinish()) {
            System.out.println("자리가 존재하지 않습니다.");
            exitMessage();
        }
        board.generateNumber(2);
        board.printMapStatus();
    }

    private void exitMessage() {
        System.out.println("게임을 종료합니다.");
        System.exit(0);
    }

    private void setCommand(String command_str) {
        if (command_str.equalsIgnoreCase("w")) {
            command = Command.UP;
        }
        if (command_str.equalsIgnoreCase("s")) {
            command = Command.DOWN;
        }
        if (command_str.equalsIgnoreCase("a")) {
            command = Command.LEFT;
        }
        if (command_str.equalsIgnoreCase("d")) {
            command = Command.RIGHT;
        }
    }
}
