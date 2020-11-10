package algorithm.baekjoon2748;
/*
 * @problem     피보나치 수 2(2748)
 * @url         https://www.acmicpc.net/problem/2748
 * @author      pbg0205
 * @created by  11.10.20
 */

import java.util.Scanner;

class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        long[] piboArr = new long[91];

        long result = pibonacchi(n, piboArr);

        System.out.println(result);
    }

    public static long pibonacchi(int n, long[] arr) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            arr[1] = 1;
            arr[2] = 1;
            return 1;
        }

        if (arr[n - 1] != 0 && arr[n - 2] != 0) {
            arr[n] = arr[n - 1] + arr[n - 2];
            return arr[n];
        }

        return pibonacchi(n - 1, arr) + pibonacchi(n - 2, arr);
    }
}
