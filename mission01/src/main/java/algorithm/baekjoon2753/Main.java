package algorithm.baekjoon2753;
/*
 * @Problem     윤년(2753)
 * @author      cooper
 * @created by  11.02.20
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();

        if ((!divideFour(year) || divideOneHundred(year)) && !divideFourHundred(year)) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }

        scanner.close();
    }

    private static boolean divideFourHundred(int year) {
        return year % 400 == 0;
    }

    private static boolean divideOneHundred(int year) {
        return year % 100 == 0;
    }

    private static boolean divideFour(int year) {
        return year % 4 == 0;
    }
}
