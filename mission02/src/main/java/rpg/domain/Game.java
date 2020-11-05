package rpg.domain;

import rpg.util.RandomNumberCreator;
import rpg.view.InputView;
import rpg.view.OutputView;

public class Game {
    private PlayerPoint playerPoint;
    private GameMap gameMap;
    private Point landMine;
    private Point monster;

    public Game(){
        this.playerPoint = new PlayerPoint();
        this.monster = new Point(RandomNumberCreator.create(), RandomNumberCreator.create());
        this.landMine = new Point(RandomNumberCreator.create(), RandomNumberCreator.create());
        this.gameMap = new GameMap(playerPoint, monster, landMine);
    }

    public void start() {
        boolean isFinished;
        String command;

        do {
            gameMap.print();
            command = InputView.inputCommand();
            moveMapByCommand(command);
            isFinished = checkLocation();
        }while(!isFinished);

        checkWinner();
    }

    public void moveMapByCommand(String command){
        if(command.equalsIgnoreCase("W")){
            gameMap.movePlayerUpper(playerPoint);
            playerPoint.moveUp();
        }
        if(command.equalsIgnoreCase("S")){
            gameMap.movePlayerDown(playerPoint);
            playerPoint.moveDown();
        }
        if(command.equalsIgnoreCase("A")){
            gameMap.movePlayerLeft(playerPoint);
            playerPoint.moveLeft();
        }
        if(command.equalsIgnoreCase("D")){
            gameMap.movePlayerRight(playerPoint);
            playerPoint.moveRight();
        }
    }

    public boolean checkLocation(){
        if(sameWithMonster()){
            return true;
        }

        if(sameWithLandMine()){
            return true;
        }

        return false;
    }

    public void checkWinner(){
        if(sameWithMonster()){
            OutputView.printWinningMessage();
        }
        if(sameWithLandMine()){
            OutputView.printLosingMessage();
        }
    }

    //TODO : 동치 조건 인스턴스로 변환하는 방법 찾아보기
    private boolean sameWithMonster() {
        if(monster.equals(playerPoint)){
            return true;
        }

        return false;
    }
    //TODO : 동치 조건 인스턴스로 변환하는 방법 찾아보기
    private boolean sameWithLandMine() {
        if(landMine.equals(playerPoint)){
            return true;
        }

        return false;
    }


}
