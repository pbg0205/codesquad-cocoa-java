package algorithm.baekjoon9488;
/*
 * @Problem     시험 성적(9498)
 * @author      cooper
 * @created by  11.02.20
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = scanner.nextInt();

        if (90 <= score && score <= 100) {
            System.out.println("A");
        }

        if (80 <= score && score < 90) {
            System.out.println("B");
        }

        if (70 <= score && score < 80) {
            System.out.println("C");
        }

        if (60 <= score && score < 70) {
            System.out.println("D");
        }

        if (score < 60) {
            System.out.println("F");
        }


        scanner.close();
    }
}
