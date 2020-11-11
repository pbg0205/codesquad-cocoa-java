package account_book;

public class OutputView {

    public static void MainViewMessage() {
        titleMessage();
        printMainPage();
    }

    private static void printMainPage() {
        loginCommandMessage();
        signUpMessage();
        exitMessage();
        commandSelectionMessage();
    }

    public static void loginMessage(){
        System.out.println("==========로그인 페이지==========");
        IdAndPwInputMessage();
    }

    public static void IdAndPwInputMessage() {
        System.out.println("아이디와 비밀번호를 입력해주세요.");
    }

    public static  void idInputMessage(){
        System.out.print("ID : ");
    }

    public static void passwordInputMessage(){
        System.out.print("PW : ");
    }

    public static void successRegisterMessage(){
        System.out.println("회원가입에 성공하셨습니다.");
    }

    public static void failRegisterMessage(){
        System.out.println("회원가입에 실패했습니다");
    }

    public static void successLoginMessage(String id){
        System.out.println(id+"님 환영합니다");
    }

    public static void failLoginMessage(){
        System.out.println("로그인에 실패하셨습니다.");
    }

    public static void quitMessage(){
        System.out.println("프로그램이 종료됩니다.");
    }

    public static void recordMessage() {
        commandSelectionMessage();
        createCommandMessage();
        readCommandMessage();
        updateCommandMessage();
        deleteCommandMessage();
        logOutCommandMessage();
        searchCommandMessage();
        exitMessage();
    }

    public static void PasswordWaringMessage() {
        System.out.println("(※비밀번호는 반드시 특수문자가 하나 이상 포함 되야 합니다.)");
    }

    public static void dateMessage(){
        System.out.println("날짜를 입력해주세요");
        System.out.println("(※구분자는 .,- 중에 하나를 입력해주세요.)");
    }

    public static void detailMessage(){
        System.out.println("내역을 입력해주세요.");
    }

    public static void moneyMessage() {
        System.out.println("금액을 입력해주세요.");
        System.out.println("(지출은 마이너스(-)로 입력해주세요.");
    }

    public static void payTypeMessage() {
        System.out.println("소비 유형을 입력해주세요.(현금 or 카드)");
    }

    public static void IndexMessage(String commandName) {
        System.out.println(commandName+"할 인덱스를 입력해주세요.");
    }

    public static void recordListMessage(){
        System.out.println("======== 목록 ========");
        System.out.printf("%5s %20s %20s %20s %20s\n", "인덱스","날짜", "적요", "금액", "현금/카드");
    }

    private static void commandSelectionMessage() {
        System.out.println("실행할 명령어를 선택해주세요.");
    }

    private static void titleMessage() {
        System.out.println("========== 소중한 내 돈 관리 가계부 ========");
    }

    private static void loginCommandMessage() {
        System.out.println("1. 로그인");
    }

    private static void signUpMessage() {
        System.out.println("2. 회원가입");
    }

    private static void exitMessage() {
        System.out.println("0. 종료");
    }

    private static void createCommandMessage(){
        System.out.println("1. 조회");
    }

    private static void readCommandMessage(){
        System.out.println("2. 추가");
    }

    private static void updateCommandMessage(){
        System.out.println("3. 수정");
    }

    private static void deleteCommandMessage(){
        System.out.println("4. 삭제");
    }

    private static void logOutCommandMessage(){
        System.out.println("5.로그아웃");
    }

    private static void searchCommandMessage() {
        System.out.println("6.검색");
    }

    public static void noRecordMessage() {
        System.out.println("조회할 목록이 존재하지 않습니다.");
    }

    public static void searchMainMessage() {
        System.out.println("검색할 키워드를 선정해주세요.");
        System.out.println("1. 날짜");
        System.out.println("2. 적요");
        System.out.println("3. 금액");
        System.out.println("4. 소비 유형");
    }

    public static void searchMessage() {
        System.out.println("검색할 내용을 입력해주세요.");
        System.out.println("-날짜의 경우 형식을 지켜주세요.(ex.1990-01-01)");
    }

    public static void noCommandMessage() {
        System.out.println("입력하신 명령어가 존재하지 않습니다.");
    }
}
