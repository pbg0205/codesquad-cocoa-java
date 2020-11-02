package algorithm.baekjoon14681;
/*
 * @Problem     사분면 고르기(14681)
 * @author      cooper
 * @created by  11.02.20
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());

        int quarant = new Point(X, Y).getQuarant();

        System.out.println(quarant);

        scanner.close();
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getQuarant() {
        int quarant = 0;

        if (this.x > 0 && this.y > 0) {
            quarant = 1;
        }

        if (this.x < 0 && this.y > 0) {
            quarant = 2;
        }

        if (this.x < 0 && this.y < 0) {
            quarant = 3;
        }

        if (this.x > 0 && this.y < 0) {
            quarant = 4;
        }

        return quarant;
    }
}
