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
        String path_tmp = path.toString() + "\\" + command;
        insertPath(path_tmp);
    }

    private void insertPath(String pathAsString) {
        if (this.pathPrevAsString == null) {
            this.pathPrevAsString = pathAsString;
            return;
        }

        if (this.pathNextAsString == null) {
            this.pathNextAsString = pathAsString;
        }
    }

    private void pathValidationMessage() {
        System.out.println("Invalid Path");
    }

    private void checkOption(String command) {
        if (command.equals(CAT_OPTION)) {
            this.option = command;
        }
    }

    private void initFileReader(String pathAsString) throws FileNotFoundException {
        try {
            this.fileReader = new FileReader(pathAsString);
        }catch (FileNotFoundException fe) {
            throw fe;
        }
    }

    private void initBufferedReader() throws NullPointerException {
        try {
            this.bufferedReader = new BufferedReader(this.fileReader);
        } catch (NullPointerException ne) {
            throw ne;
        }
    }

    private void connectionFile(String pathAsString) throws FileNotFoundException, NullPointerException {
        initFileReader(pathAsString);
        initBufferedReader();
    }

    public void execute() {
        if (!(hasPath(this.pathPrevAsString) ||
                hasPath(this.pathNextAsString))) {
            return;
        }

        if (hasOption()) {
            concatenateWithOption();
            return;
        }

        try {
            concatenate(this.pathPrevAsString);
            concatenate(this.pathNextAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void concatenateWithOption() {
        try {
            concatenateWithNoption(this.pathPrevAsString);
            concatenateWithNoption(this.pathNextAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean hasPath(String pathAsString) {
        if (pathAsString == null) {
            return false;
        }
        return !(pathAsString.equals(""));
    }

    private boolean checkDirectory(String path) {
        File file = new File(path);

        if (isDirectory(file)) {
            printDirectoryMessage(file);
            return true;
        }
        return false;
    }

    private boolean isDirectory(File file) {
        return file.isDirectory();
    }

    private void printDirectoryMessage(File file) {
        String directoryName = file.getName();
        System.out.printf("%s is Directory\n", directoryName);
    }

    private void concatenateWithNoption(String pathAsString) throws IOException {
        if (!hasPath(pathAsString)) {
            return;
        }

        if (checkDirectory(pathAsString)) {
            return;
        }

        try {
            connectionFile(pathAsString);
            printLineWithRowNum();
        } catch (NullPointerException | FileNotFoundException e) {
            pathValidationMessage();
        }
    }

    private void printLineWithRowNum() throws IOException {
        String line;
        int rowCount = 0;

        while ((line = this.bufferedReader.readLine()) != null) {
            System.out.printf("%d %s\n", ++rowCount, line);
        }
    }

    private void concatenate(String pathAsString) throws IOException {
        if (!hasPath(pathAsString)) {
            return;
        }

        if (checkDirectory(pathAsString)) {
            return;
        }

        try {
            connectionFile(pathAsString);
            printAllLine();
        } catch (FileNotFoundException | NullPointerException e) {
            pathValidationMessage();
        }
    }

    private void printAllLine() throws IOException {
        String line;

        while ((line = this.bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private boolean hasOption() {
        if (!containOption()) {
            return false;
        }
        return (this.option.equals(CAT_OPTION));
    }

    private boolean containOption() {
        return (this.option != null);
    }
}