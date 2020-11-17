package shell;

import java.io.File;
import java.nio.file.Path;

class MkdirCommand {
    public void makeDirectory(String[] commands, Path path) {
        if(commands.length == 1){
            return;
        }

        String directory = commands[1];
        String pathAsString = path.toString();
        String directoryPath = getDirectoryPath(directory, pathAsString);

        initCreateNewFile(directoryPath);
    }

    private void initCreateNewFile(String path){
        File file = new File(path);
        file.mkdir();
    }

    private String getDirectoryPath(String directory, String path) {
        return path + "\\" + directory;
    }
}
