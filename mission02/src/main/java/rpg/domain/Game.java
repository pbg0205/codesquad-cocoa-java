package rpg.domain;

import rpg.util.RandomNumberCreator;
import rpg.view.InputView;
import rpg.view.OutputView;

public class Game {
    private Player player;
    private GameMap gameMap;
    private Point landMine;
    private Point monster;

    public Game(){
        this.player = new Player();
        this.monster = new Point(RandomNumberCreator.create(), RandomNumberCreator.create());
        this.landMine = new Point(RandomNumberCreator.create(), RandomNumberCreator.create());
        this.gameMap = new GameMap(player, monster, landMine);
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
            gameMap.movePlayerUpper(player);
            player.moveUp();
        }
        if(command.equalsIgnoreCase("S")){
            gameMap.movePlayerDown(player);
            player.moveDown();
        }
        if(command.equalsIgnoreCase("A")){
            gameMap.movePlayerLeft(player);
            player.moveLeft();
        }
        if(command.equalsIgnoreCase("D")){
            gameMap.movePlayerRight(player);
            player.moveRight();
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
        return (player.getX() == monster.getX()) && (player.getY() == monster.getY());
    }
    //TODO : 동치 조건 인스턴스로 변환하는 방법 찾아보기
    private boolean sameWithLandMine() {
        return (player.getX() == landMine.getX()) && (player.getY() == landMine.getY());
    }


}
