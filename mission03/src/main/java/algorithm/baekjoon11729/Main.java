package algorithm.baekjoon11729;
/*
 * @problem     하노이 탑 이동 순서(11729)
 * @url         https://www.acmicpc.net/problem/11729
 * @author      pbg0205
 * @created by  11.10.20
 */

import java.util.Scanner;

class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        recur(n, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);

        scanner.close();
    }

    public static void recur(int n, int from, int by, int to) {
        cnt++;
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        recur(n - 1, from, to, by);
        sb.append(from + " " + to + "\n");
        recur(n - 1, by, from, to);

    }
}
