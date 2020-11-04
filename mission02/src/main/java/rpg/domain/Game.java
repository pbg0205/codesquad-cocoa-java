package rpg.domain;

import rpg.view.InputView;

public class Game {
    private Player player;
    private GameMap gameMap;

    public Game(){
        this.gameMap = new GameMap();
        this.player = new Player();
    }

    public void start() {
        boolean isFinished = false; //TODO 재설정하기
        String command;

        do {
            command = InputView.inputCommand();
            moveMapByCommand(command);
            gameMap.print();
            isFinished = true; //TODO 변경하기
        }while(!isFinished);

        
    }

    public void moveMapByCommand(String command){

        if(command.equalsIgnoreCase("W")){
            gameMap.movePlayerUpper(player);
            player.moveUp();
            gameMap.print();
        }
        if(command.equalsIgnoreCase("S")){
            gameMap.movePlayerDown(player);
            player.moveDown();
            gameMap.print();
        }
        if(command.equalsIgnoreCase("A")){
            gameMap.movePlayerLeft(player);
            player.moveLeft();
            gameMap.print();
        }
        if(command.equalsIgnoreCase("D")){
            gameMap.movePlayerRight(player);
            player.moveRight();
            gameMap.print();
        }
    }

}
