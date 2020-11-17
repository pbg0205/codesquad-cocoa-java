package shell;

import java.nio.file.Path;

class pwdCommand {
    public void printWorkingDirectory(Path path) {
        String pathAsString = path. toString();
        System.out.println(pathAsString);
    }
}
