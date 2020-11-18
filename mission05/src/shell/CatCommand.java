package shell;

import java.io.*;
import java.nio.file.Path;

public class CatCommand {
    private static final String CAT_OPTION = "-n";

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String option;

    private String pathPrevAsString;
    private String pathNextAsString;

    public CatCommand(String commandLine, Path path) {
        seperateCommands(commandLine, path);
    }

    private void seperateCommands(String commandLine, Path path) {
        String[] commands = commandLine.split(" ");
        int commandLen = commands.length;

        if (commandLen == 1) {
            return;
        }

        for (int index = 1; index < commandLen; index++) {
            String command = commands[index];
            checkOption(command);
            initPath(path, command);
        }
    }

    private void initPath(Path path, String command) {
        String path_tmp;
        if (pathPrevAsString == null) {
            path_tmp = path.toString() + "\\" + command;
            pathPrevAsString = path_tmp;
            return ;
        }

        if (pathNextAsString == null) {
            path_tmp = path.toString() + "\\" + command;
            pathNextAsString = path_tmp;
        }
    }

    private void checkOption(String command) {
        if (command.equals(CAT_OPTION)) {
            this.option = command;
        }
    }

    private void initFileReader(String pathAsString) {
        try {
            this.fileReader = new FileReader(pathAsString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initBufferedReader() {
        this.bufferedReader = new BufferedReader(this.fileReader);
    }

    private void connectionFile(String pathAsString) {
        initFileReader(pathAsString);
        initBufferedReader();
    }

    public void execute() {
        checkDirectory(pathPrevAsString);
        checkDirectory(pathNextAsString);

        if (hasOption()) {
            executeWithOption();
            return;
        }

        try {
            printLine(this.pathPrevAsString);
            printLine(this.pathNextAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //명령어 설정하기
    }

    private void printDirectoryMessage(File file) {
        String directoryName = file.getName();
        System.out.printf("%s is Directory\n", directoryName);
    }

    private void checkDirectory(String path) {
        File file = new File(path);

        if (!(isDirectory(file))) {
            printDirectoryMessage(file);
            return;
        }
    }

    private boolean isDirectory(File file) {
        return file.isDirectory();
    }

    private void executeWithOption() {
        try {
            printLineWithRowNum(this.pathPrevAsString);
            printLineWithRowNum(this.pathNextAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLineWithRowNum(String pathAsString) throws IOException {
        String line;
        int rowCount = 0;

        connectionFile(pathAsString);

        while ((line = this.bufferedReader.readLine()) != null) {
            System.out.printf("%d %s\n", ++rowCount, line);
        }
    }

    private void printLine(String pathAsString) throws IOException {
        String line;

        connectionFile(pathAsString);

        while ((line = this.bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private boolean hasOption() {
        if(!containValue()) {
            return false;
        }
        return (this.option.equals(CAT_OPTION));
    }

    private boolean containValue() {
        return (this.option != null);
    }
}