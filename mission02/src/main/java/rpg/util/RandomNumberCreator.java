package rpg.util;

import java.util.Random;

public class RandomNumberCreator {
    private static int MAP_SIZE = 11;

    private static final Random random = new Random();

    public static int create(){
        return random.nextInt(MAP_SIZE);
    }
}
