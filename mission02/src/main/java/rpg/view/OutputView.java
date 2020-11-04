package rpg.view;

public class OutputView {

    public static void printWinningMessage(){
        System.out.println("축하합니다. 몬스터 사냥에 성공하셨습니다.");
        System.out.println("승리 \uD83C\uDFC1");
    }
    public static void printLosingMessage(){
        System.out.println("아쉽습니다. 지뢰를 밟았어요.");
        System.out.println("패배\uD83D\uDCA3");
    }

}
