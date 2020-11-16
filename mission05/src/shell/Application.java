package shell;

import java.io.File;
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
            printWorkingDirectory();
        }

        if (command.startsWith("cd")) {
            changeDirectory(commands);
        }

        if (command.startsWith("ls")) {
            list();
        }

        if (command.startsWith("mkdir")) {
            makeDirectory(commands);
        }

        if (command.startsWith("exit")) {
            System.exit(0);
        }
    }

    private String getDirectoryPath(String directory, String path) {
        return path + "\\" + directory;
    }

    private void makeDirectory(String[] commands) {
        if(commands.length == 1){
            return;
        }

        String directory = commands[1];
        String path = this.path.toString();
        String directoryPath = getDirectoryPath(directory, path);

        initCreateNewFile(directoryPath);
    }

    private void initCreateNewFile(String path){
        File file = new File(path);
        file.mkdir();
    }

    private void list() {
        File[] files = new File(this.path.toString()).listFiles();

        for (File file : files) {
            String fileName = file.getName();
            long totalSpace = file.getTotalSpace();//TODO 저장 용량 내용 찾아보기

            String fileInfoAsString = String.format("%20s%20d", fileName, totalSpace);
            System.out.println(fileInfoAsString);
        }
    }

    private void changeDirectory(String[] commands) {
        String optionalCommand = commands[1];

        if (optionalCommand.equals("..")) {
            changeParentDirectory();
            return;
        }

        changeInnerDirectory(commands[1]);
    }

    private void changeParentDirectory() {
        if(path.getParent() == null){
            return ;
        }

        this.path = path.getParent();
        return;
    }

    private void changeInnerDirectory(String dirPath) {
        File[] files = new File(this.path.toString()).listFiles();
        String childPath;

        for (File file : files) {
            if(hasDirectory(file, dirPath)){
                childPath = this.path.toString()+ "\\" + file.getName();
                this.path = Paths.get(childPath);
            }
        }
    }

    private boolean hasDirectory(File file, String directory) {
        return (file.getName().equals(directory));
    }

    private void printPath() {
        String pathAsString = path.toString();
        System.out.print(pathAsString + "> ");
    }

    private void printWorkingDirectory() {
        String pathAsString = path.toString();
        System.out.println(pathAsString);
    }
}
