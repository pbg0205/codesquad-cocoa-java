package algorithm.baekjoon2438;

import java.util.Scanner;

/*
 * @Problem     별 찍기 - 1(2438)
 * @author      cooper
 * @created by  11.02.20
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= row; col++){
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
