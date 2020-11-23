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

        board.printMapStatus();
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
