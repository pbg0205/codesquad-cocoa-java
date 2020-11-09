package account_book;

class App {
    private MemberList memberList;
    private Member loginMember;
    private boolean isLogin;

    public App() {
        memberList = new MemberList();
    }

    public void start() {
        while (true) {
            mainPage();
            isLogin = true;
            recordPage();
        }
    }

    private void recordPage() {
        int appCommand;

        if (!isLogin) {
            return;
        }

        do {
            OutputView.recordMessage();
            appCommand = InputView.inputIntValue();
            record(appCommand);

            if (!isLogin) {
                return;
            }

        } while (true);
    }

    private void record(int appCommand) {
        Record record;

        if (appCommand == 1) {
            memberList.getMember(loginMember).printRecords();
        }

        if (appCommand == 2) {
            OutputView.dateMessage();
            String dateStr = InputView.inputStringValue();

            OutputView.detailMessage();
            String detail = InputView.inputStringValue();

            OutputView.moneyMessage();
            int money = InputView.inputIntValue();

            record = new Record(dateStr, detail, money);
            memberList.getMember(loginMember).insertRecord(record);
        }

        if (appCommand == 3) {
            OutputView.IndexMessage("수정");
            int index = InputView.inputIntValue();

            OutputView.dateMessage();
            String dateStr = InputView.inputStringValue();

            OutputView.detailMessage();
            String detail = InputView.inputStringValue();

            OutputView.moneyMessage();
            int money = InputView.inputIntValue();

            record = new Record(dateStr, detail, money);

            memberList.getMember(loginMember).modifyRecord(index, record);
        }

        if (appCommand == 4) {
            OutputView.IndexMessage("삭제");
            int index = InputView.inputIntValue();
            memberList.getMember(loginMember).deleteRecord(index);
        }
        if (appCommand == 5) {
            isLogin = false;
        }
        if (appCommand == 0) {
            OutputView.quitMessage();
            System.exit(0);
        }
    }

    //mainPage
    private void mainPage() {
        int appCommand;

        do {
            OutputView.MainViewMessage();
            appCommand = InputView.inputIntValue();
        } while (mainCommand(appCommand));
    }

    public boolean mainCommand(int appCommand) {
        if (appCommand == 1) {
            if (isMember()) {
                String loginId = loginMember.getId();
                OutputView.successLoginMessage(loginId);
                return false;
            }
            OutputView.failLoginMessage();
            return true;
        }

        if (appCommand == 2) {
            if (registerMember()) {
                OutputView.successRegisterMessage();
                return true;
            }
            OutputView.failRegisterMessage();
            return true;
        }

        if (appCommand == 0) {
            quitProgram();
        }

        return false;
    }

    private boolean isMember() {
        OutputView.loginMessage();
        Member member = new Member(inputId(), inputPw());

        if (memberList.checkMemberList(member)) {
            loginMember = member;
            return true;
        }

        return false;
    }

    //회원가입
    private boolean registerMember() {
        OutputView.IdAndPwInputMessage();
        OutputView.PasswordWaringMessage();

        Member member = new Member(inputId(), inputPw());

        if (member.AllValidation()) {
            memberList.addMember(member);
            return true;
        }
        return false;
    }

    private String inputId() {
        OutputView.idInputMessage();
        return InputView.inputStringValue();
    }

    private String inputPw() {
        OutputView.passwordInputMessage();
        return InputView.inputStringValue();
    }

    private void quitProgram() {
        OutputView.quitMessage();
        System.exit(0);
    }
}
