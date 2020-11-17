package shell;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class CdCommand {
    private Path path;

    public CdCommand(Path path){
        this.path = path;
    }

    public Path changeDirectory(String[] commands) {
        String optionalCommand = commands[1];

        if (optionalCommand.equals("..")) {
            return changeParentDirectory();
        }
        return changeInnerDirectory(optionalCommand);
    }

    private Path changeInnerDirectory(String directoryPath) {
        File[] files = new File(path.toString()).listFiles();

        for (File file : files) {
            iterateInnerDirectory(file, directoryPath);
        }

        return this.path;
    }

    private void iterateInnerDirectory(File file, String directoryPath) {
        String fileName = file.getName();
        String subPath;

        if(hasDirectory(fileName, directoryPath)){
            subPath = path.toString()+ "\\" + file.getName();
            this.path = Paths.get(subPath);
        }
    }

    private Path changeParentDirectory() {
        if(this.path.getParent() == null){
            return this.path;
        }
        return this.path.getParent();
    }

    private boolean hasDirectory(String fileName, String directory) {
        return fileName.equals(directory);
    }
}
