package account_book;

import java.util.List;

class App {
    private MemberDao memberDao;
    private Member loginMember;
    private boolean isLogin;

    public App() {
        this.memberDao = new MemberDao();
    }

    public void start() {
        while (true) {
            mainPage();
            recordPage();
        }
    }

    private void mainCommand(int appCommand) {
        if (appCommand == 1) {
            if (isMember()) {
                isLogin = true;
                String loginId = loginMember.getId();
                OutputView.successLoginMessage(loginId);

                return;
            }
            OutputView.failLoginMessage();
        }
        //TODO : 회원가입 실패 원인을 바깥으로 빼는 것 고려하기
        if (appCommand == 2) {
            if (registerMember()) {
                OutputView.successRegisterMessage();
            }
            OutputView.failRegisterMessage();
        }

        if (appCommand == 0) {
            quitProgram();
        }
    }

    private void mainPage() {
        int appCommand;

        do {
            OutputView.MainViewMessage();
            appCommand = InputView.inputIntValue();
            mainCommand(appCommand);
        } while (!isLogin);
    }

    private boolean isMember() {
        OutputView.loginMessage();
        Member member = new Member(inputId(), inputPw());

        if (memberDao.hasMember(member)) {
            loginMember = memberDao.getMemberData(member);
            return true;
        }

        return false;
    }

    private boolean registerMember() {
        OutputView.IdAndPwInputMessage();
        OutputView.PasswordWaringMessage();

        Member member = new Member(inputId(), inputPw(),inputBalance());

        if(memberDao.hasMember(member)){
            return false;
        }

        if (!member.AllValidation()) {
            return false;
        }

        memberDao.addMember(member);
        return true;
    }

    private void recordPage() {
        int appCommand;

        do {
            OutputView.recordMessage();
            appCommand = InputView.inputIntValue();
            recordCommand(appCommand);
        } while (isLogin);
    }

    private void recordCommand(int appCommand) {
        Record record;
        //1.조회
        if (appCommand == 1) {
            loginMember.printRecords();
        }
        //2.추가
        if (appCommand == 2) {
            record = inputRecord();
            loginMember.insertRecord(record);
        }
        //3.수정
        if (appCommand == 3) {
            OutputView.IndexMessage("수정");

            int index = InputView.inputIntValue();
            record = inputRecord();

            loginMember.modifyRecord(index, record);
        }
        //4.삭제
        if (appCommand == 4) {
            OutputView.IndexMessage("삭제");
            int index = InputView.inputIntValue();
            loginMember.deleteRecord(index);
        }
        //5.로그아웃
        if (appCommand == 5) {
            StringBuilder sb = loginMember.getCsvRecords();
            new RecordDao(loginMember.getId()).saveRecords(loginMember);
            isLogin = false;
        }
        //6. 검색
        if (appCommand == 6) {
            OutputView.searchMainMessage();
            appCommand = InputView.inputIntValue();
            searchByCategory(appCommand);
        }
        //0. 프로그램 종료
        if (appCommand == 0) {
            OutputView.quitMessage();
            System.exit(0);
        }
    }

    private void searchByCategory(int appCommand) {
        List<Integer> searchList = null;

        OutputView.searchMessage();

        if (appCommand == 1) {
            UseDate useDate = new UseDate(InputView.inputStringValue());
            searchList = loginMember.searchBy(useDate);
        }

        if (appCommand == 2) {
            String detail = InputView.inputStringValue();
            searchList = loginMember.searchBy(detail, appCommand);
        }

        if (appCommand == 3) {
            int money = InputView.inputIntValue();
            searchList = loginMember.searchBy(money);
        }

        if (appCommand == 4) {
            String payType = InputView.inputStringValue();
            searchList = loginMember.searchBy(payType, appCommand);
        }

        if (hasNoResult(searchList)) {
            OutputView.noCommandMessage();
            return;
        }

        matchByIndex(searchList);
    }

    private boolean hasNoResult(List<Integer> searchList) {
        return searchList == null || searchList.size() == 0;
    }

    private void matchByIndex(List<Integer> searchList) {
        loginMember.printRecordsByIndex(searchList);
    }

    private Record inputRecord() {
        String dateStr;
        String detail;
        int money;
        String payType;

        OutputView.dateMessage();
        dateStr = InputView.inputStringValue();

        OutputView.detailMessage();
        detail = InputView.inputStringValue();

        OutputView.moneyMessage();
        money = InputView.inputIntValue();

        OutputView.payTypeMessage();
        payType = InputView.inputStringValue();

        return new Record(dateStr, detail, money, payType);
    }

    private String inputId() {
        OutputView.idInputMessage();
        return InputView.inputStringValue();
    }

    private String inputPw() {
        OutputView.passwordInputMessage();
        return InputView.inputStringValue();
    }

    private int inputBalance(){
        OutputView.balanceInputMessage();
        return InputView.inputIntValue();
    }

    private void quitProgram() {
        OutputView.quitMessage();
        System.exit(0);
    }
}
