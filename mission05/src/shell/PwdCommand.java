package shell;

import java.nio.file.Path;

class PwdCommand {
    public void printWorkingDirectory(Path path) {
        String pathAsString = path.toString();
        System.out.println(pathAsString);
    }
    //TODO : directory type일 때 접속할 수 있도록 구현하기
}
