package shell;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class ListComand {
    private Set<String> option;
    private String subPathName;

    public ListComand(String commandLine) {
        getCommand(commandLine);
    }

    private void getCommand(String commandLine) {
        String[] commands = sepearteCommand(commandLine);
        compareLineExceptCommand(commands);
    }

    private void compareLineExceptCommand(String[] commands) {
        this.option = insertOption(commands);
    }

    private Set<String> insertOption(String[] commands) {
        Set<String> set = new HashSet<>();
        int commandLen = commands.length;

        for (int index = 1; index < commandLen; index++) {
            String value = commands[index];

            if (isOption(value)) {
                set.add(value);
                continue;
            }
            addSubPathName(value);
        }
        return set;
    }

    private void addSubPathName(String value) {
        if (hasSubPath()) {
            return;
        }
        this.subPathName = value;
    }

    private boolean hasSubPath() {
        return subPathName != null;
    }

    private boolean isSubPathName(Path path) {
        File[] files = new File(path.toString()).listFiles();

        for (File file : files) {
            String fileName = file.getName();
            return (this.subPathName.equals(fileName) && (file.isDirectory()));
        }
        return false;
    }

    private String makeSubPath(Path path) {
        return path.toString() + "\\" + this.subPathName;
    }

    private boolean isOption(String value) {
        return value.startsWith("-");
    }

    private String[] sepearteCommand(String commandLine) {
        return commandLine.split(" ");
    }

    public void executeList(Path path) {
        String subPath;

        if (hasOption()) {
            listWithOption(path);
            return;
        }

        if (hasSubPath() && isSubPathName(path)) {
            subPath = makeSubPath(path);
            list(subPath);
            return;
        }

        list(path.toString());
    }

    private boolean hasOption() {
        return (this.option.size() > 0);
    }

    private void listWithOption(Path path) {
        String pathAsString = path.toString();
        boolean lOption = this.option.contains("-l");
        boolean hOption = this.option.contains("-h");

        if (hasAlOption()) {
            lOption = true;
        }

        if (hasSubPath()) {
            String subPath = makeSubPath(path);
            iterateFilesWithOption(subPath, lOption, hOption);
            return;
        }
        iterateFilesWithOption(pathAsString, lOption, hOption);
    }

    private void iterateFilesWithOption(String pathAsString,
                                        boolean lOption,
                                        boolean hOption) {
        File[] files = new File(pathAsString).listFiles();

        for (File file : files) {
            if (hOption && lOption) {
                printHandLOption(file);
                continue;
            }
            if (lOption) {
                printWithLOption(file);
            }
        }
    }

    private String getPermissionType(File file) {
        boolean isExecutable = file.canExecute();
        boolean isReadable = file.canRead();
        boolean isWritable = file.canWrite();

        return getPermissionAsString(isReadable, isExecutable, isWritable);
    }

    private String getPermissionAsString(boolean isReadable,
                                         boolean isExecutable,
                                         boolean isWritable) {
        String permission = "";

        permission = check(permission, isReadable, "r");
        permission = check(permission, isWritable, "w");
        permission = check(permission, isExecutable, "x");

        return permission;
    }

    private String check(String permission, boolean isContain, String mark) {
        if(isContain){
            permission += mark;
        }else {
            permission += "-";
        }
        return permission;
    }

    private void printWithLOption(File file) {
        String fileName = file.getName();
        String modifiedDate = convertToString(file.lastModified());
        String fileSize = String.valueOf(file.length());
        String permission = getPermissionType(file);

        printFormat(permission, fileSize, modifiedDate, fileName);
    }

    private void printFormat(String permission, String length,
                             String modifiedDate, String fileName) {
        System.out.printf("%15s %15s %15s %20s\n",
                permission, length, modifiedDate, fileName);
    }

    private void printHandLOption(File file) {
        String fileName = file.getName();
        String modifiedDate = convertToString(file.lastModified());
        String permission = getPermissionType(file);

        printFormat(permission, convertUnit(file), modifiedDate, fileName);
    }

    private String convertToString(long lastModified) {
        Date modifiedDate = convertToDate(lastModified);
        Calendar cal = convertToCalendar(modifiedDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(cal.getTime());
    }

    private Calendar convertToCalendar(Date modifiedDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(modifiedDate);
        return cal;
    }

    private Date convertToDate(long fileDate) {
        return new Date(fileDate);
    }

    private String convertUnit(File file) {
        long fileSize = file.length();
        int cnt = 0;

        while (fileSize > 1000) {
            fileSize = fileSize / 1024;
            cnt++;
        }
        return convertStorageUnit(fileSize, cnt);
    }

    private String convertStorageUnit(long fileSize, int cnt) {
        if (cnt == 0) {
            return fileSize + "B";
        }
        if (cnt == 1) {
            return fileSize + "K";
        }
        if (cnt == 2) {
            return fileSize + "M";
        }
        if (cnt == 3) {
            return fileSize + "G";
        }

        return fileSize + "T";
    }

    private boolean hasAlOption() {
        return this.option.contains("-al");
    }

    private void list(String path) {
        File[] files = new File(path).listFiles();
        int count = 0;

        for (File file : files) {
            System.out.printf("%s \t", file.getName());

            if (count++ == 10) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
