package rpg.domain;

public class GameMap {
    private static final int MAP_RANGE_MAX = 11;
    private static final int MAP_RANGE_MIN =  0;

    private String[][] map;

    public GameMap(PlayerPoint playerPoint, Point monster, Point landMine) {
        this.map = initMap(playerPoint, monster, landMine);
    }

    private String[][] initMap(PlayerPoint playerPoint, Point monster, Point landMine){
        this.map = new String[MAP_RANGE_MAX][MAP_RANGE_MAX];

        for (int row = 0; row < MAP_RANGE_MAX; row++) {
            for (int col = 0; col < MAP_RANGE_MAX; col++) {
                this.map[row][col] = "\uD83D\uDD33";
            }
        }

        initPlayerLocation(playerPoint);
        initMonsterLocation(monster);
        initLandMineLocation(landMine);

        return map;
    }

    private void initPlayerLocation(PlayerPoint player) {
        int x = player.getX();
        int y = player.getY();
        this.map[x][y] = "\uD83D\uDE01";
    }

    private void initMonsterLocation(Point monster){
        int x = monster.getX();
        int y = monster.getY();

        this.map[x][y] = "\uD83D\uDE08";//TODO monster 위치 인덱스 변경하기
    }

    private void initLandMineLocation(Point landMine){
        int x = landMine.getX();
        int y = landMine.getY();

        this.map[x][y] = "\uD83D\uDCA3";//TODO LandMine 위치 인덱스 변경하기
    }

    public void movePlayerUpper(PlayerPoint player){
        int x = player.getX();
        int y = player.getY();

        if(!isBoundary(x,y)){
            return ;
        }

        swapUpper(x,y);
    }

    private void swapUpper(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x-1][y];
        this.map[x-1][y] = tmp;
    }

    public void movePlayerDown(PlayerPoint player){
        int x = player.getX();
        int y = player.getY();

        if(!isBoundary(x, y)){
            return;
        }

        swapDown(x,y);
    }

    private void swapDown(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x+1][y];
        this.map[x+1][y] = tmp;
    }

    public void movePlayerLeft(PlayerPoint player){
        int x = player.getX();
        int y = player.getY();

        if(!isBoundary(x, y)){
            return ;
        }

        swapLeft(x,y);
    }

    private void swapLeft(int x, int y) {
        String tmp = this.map[x][y];
        this.map[x][y] = this.map[x][y-1];
        this.map[x][y-1] = tmp;
    }

    public void movePlayerRight(PlayerPoint player){
        int x = player.getX();
        int y = player.getY();

        if(!isBoundary(x, y)){
            return ;
        }

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

    public boolean isBoundary(int x, int y){
        return (MAP_RANGE_MIN <= x && x <MAP_RANGE_MAX) && (MAP_RANGE_MIN <= y && y <MAP_RANGE_MAX);
    }
}
