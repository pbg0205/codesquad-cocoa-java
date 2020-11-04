package rpg.domain;

public class GameMap {
    private static final int MAP_RANGE_MAX = 11;
    private static final int PLAYER_INIT_LOCATION = 5;
    private static final int MAP_RANGE_MIN =  0;

    private String[][] map;

    public GameMap() {
        this.map = initMap();
    }

    private String[][] initMap(){
        this.map = new String[MAP_RANGE_MAX][MAP_RANGE_MAX];

        for (int row = 0; row < MAP_RANGE_MAX; row++) {
            for (int col = 0; col < MAP_RANGE_MAX; col++) {
                this.map[row][col] = "□";
            }
        }

        initPlayerLocation();
        initMonsterLocation();
        initLandMineLocation();

        return map;
    }

    private void initPlayerLocation() {
        this.map[PLAYER_INIT_LOCATION][PLAYER_INIT_LOCATION] = "\uD83D\uDE01";
    }

    private void initMonsterLocation(){
        this.map[3][4] = "M";//TODO monster 위치 인덱스 변경하기
    }

    private void initLandMineLocation(){
        this.map[7][9] = "\uD83D\uDCA3";//TODO LandMine 위치 인덱스 변경하기
    }

    public void movePlayerUpper(Player player){
        int x = player.getX();
        int y = player.getY();

        swapUpper(x,y);
    }

    private void swapUpper(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x-1][y];
        this.map[x-1][y] = tmp;
    }

    public void movePlayerDown(Player player){
        int x = player.getX();
        int y = player.getY();

        swapDown(x,y);
    }

    private void swapDown(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x+1][y];
        this.map[x+1][y] = tmp;
    }

    public void movePlayerLeft(Player player){
        int x = player.getX();
        int y = player.getY();

        swapLeft(x,y);
    }

    private void swapLeft(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x][y-1];
        this.map[x][y-1] = tmp;
    }

    public void movePlayerRight(Player player){
        int x = player.getX();
        int y = player.getY();

        swapRight(x,y);
    }

    private void swapRight(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x][y+1];
        this.map[x][y+1] = tmp;
    }

    public void print(){
        for (int row = 0; row < MAP_RANGE_MAX; row++) {
            for (int col = 0; col < MAP_RANGE_MAX; col++) {
                System.out.printf("%4s", this.map[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
