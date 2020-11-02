package gugudan.domain;

public class Manual {

    public Manual() {
    }

    public void printManual() {
        gugudanTitle();
        printRullManual();
    }

    public void printInputMessage() {
        divider();
        System.out.println("원하는 두 숫자를 입력해주세요.");
        divider();
    }

    public void printFinishMessage() {
        divider();
        System.out.println("출력이 완료되었습니다!");
        System.out.println("프로그램을 종료합니다.");
        divider();
    }

    private void printRullManual() {
        divider();
        System.out.println("                      <<규칙>>                      ");
        System.out.println("1. 두 숫자는 띄어쓰기 기준으로 입력합니다.(ex. 3 7 -> O)");
        System.out.println("2. 두 숫자는 2이상 9이하의 숫자를 입력합니다.(ex. 13 16 -> X)");
        System.out.println("3. 첫번 째수가 두 번째 수보다 작게 입력합니다.(ex. 7 3 -> X)");
        divider();
    }

    private void gugudanTitle() {
        System.out.println("                    구구단 만들기                    ");
    }

    private void divider() {
        System.out.println("=====================================================");
    }

}
