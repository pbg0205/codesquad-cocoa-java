package shell;

import java.nio.file.Path;
import java.nio.file.Paths;

class Application extends Thread {
    private Path path;
    private HistoryCommand history;
    public Application() {
        this.path = Paths.get(System.getProperty("user.dir"));
        this.history = new HistoryCommand();
    }

    @Override
    public void run() {
        while (true) {
            printPath();
            String line = InputView.inputAsString();
            Command(line);
        }
    }

    private void Command(String commandLine) {
        String[] commands = commandLine.split(" ");
        String command = commands[0];

        history.pushHistory(commandLine);

        if (command.startsWith("pwd")) {
            new PwdCommand().printWorkingDirectory(this.path);
        }

        if (command.startsWith("cd")) {
            this.path = new CdCommand(this.path).changeDirectory(commands);
        }

        if (command.startsWith("ls")) {
            new ListComand(commandLine).executeList(this.path);
        }

        if (command.startsWith("mkdir")) {
            new MkdirCommand().makeDirectory(commands, path);
        }

        if(command.startsWith("history")) {
            history.excuteCommand(commandLine);
        }

        if(command.startsWith("cat")) {
            new CatCommand(commandLine, this.path).execute();
        }

        if (command.startsWith("exit")) {
            System.exit(0);
        }

    }

    private void printPath() {
        String pathAsString = path.toString();
        System.out.print(pathAsString + "> ");
    }
}
