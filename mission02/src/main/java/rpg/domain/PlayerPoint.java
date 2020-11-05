package rpg.domain;

public class PlayerPoint extends Point{
    private static final int INIT_LOCATION = 5;

    public PlayerPoint() {
        super(INIT_LOCATION, INIT_LOCATION);
    }

    public void moveUp(){
        super.setX(super.getX() - 1);
    }

    public void moveDown(){
        super.setX(super.getX() + 1);
    }

    public void moveLeft(){
        super.setY(super.getY() - 1);
    }

    public void moveRight(){
        super.setY(super.getY() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PlayerPoint))
            return false;

        return super.equals(o);
    }
}
