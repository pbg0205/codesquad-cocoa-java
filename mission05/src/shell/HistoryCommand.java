package shell;

import java.util.Stack;

public class HistoryCommand {
    private Stack<String> historyStack;
    private String option;

    public HistoryCommand() {
        this.historyStack = new Stack<>();
    }

    private void checkOption(String commandLine) {
        String[] commands = commandLine.split(" ");
        String option_tmp;

        if (commands.length == 1) {
            this.option = "";
            return;
        }

        option_tmp = commands[1];

        if(option_tmp.startsWith("-c")) {
            option = option_tmp;
        }else {
            this.option = "";
        }
    }

    public void pushHistory(String command) {
        if(command.equals("history -c")){
            command = "history";
        }

        historyStack.push(command);
    }

    public void excuteCommand(String commandLine) {
        Stack stack_tmp = this.historyStack;
        int index = 1;

        checkOption(commandLine);

        if(this.option.equals("-c")) {
            removeAllhistory();
        }

        while(!stack_tmp.isEmpty()) {
            System.out.printf("%d %s\n", index++, stack_tmp.pop());
        }
    }

    private void removeAllhistory() {
        historyStack = new Stack<>();
    }
}
