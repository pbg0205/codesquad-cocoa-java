package rpg.domain;

import java.util.Objects;

public class Player {
    private static final int INIT_LOCATION = 5;

    private int x;
    private int y;

    public Player() {
        this.x = INIT_LOCATION;
        this.y = INIT_LOCATION;
    }

    public void moveUp(){
        this.x -= 1;
    }

    public void moveDown(){
        this.x += 1;
    }

    public void moveLeft(){
        this.y -= 1;
    }

    public void moveRight(){
        this.y += 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return x == player.x &&
                y == player.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
