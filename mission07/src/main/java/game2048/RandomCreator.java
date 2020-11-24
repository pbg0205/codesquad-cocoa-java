package game2048;

import java.util.Random;

public class RandomCreator {
    private static final int RAGNE_MAX = 4;
    private static final Random random = new Random();

    public static int create() {
        return random.nextInt(RAGNE_MAX);
    }
}
