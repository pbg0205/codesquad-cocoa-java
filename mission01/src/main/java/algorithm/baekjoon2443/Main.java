package algorithm.baekjoon2443;

import java.util.Scanner;

/*
 * @Problem     별 찍기 - 6(2443)
 * @author      cooper
 * @created by  11.02.20
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int widthSize = size * 2 - 1;

        for (int row = 1; row < widthSize; row++) {
            for (int col = 1; col < row; col++) {
                System.out.print(" ");
            }

            int starSize = widthSize - (row-1) * 2 + 1;

            for (int col = 1; col < starSize; col++) {
                System.out.print("*");
            }
            System.out.println();
        }



        scanner.close();
    }
}
