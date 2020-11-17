package shell;

import java.nio.file.Path;
import java.nio.file.Paths;

class Application extends Thread {
    private Path path;

    public Application() {
        this.path = Paths.get(System.getProperty("user.dir"));
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

        if (command.startsWith("pwd")) {
            new pwdCommand().printWorkingDirectory(this.path);
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

        if (command.startsWith("exit")) {
            System.exit(0);
        }
    }

    private void printPath() {
        String pathAsString = path.toString();
        System.out.print(pathAsString + "> ");
    }
}
