package algorithm.baekjoon11720;

import java.util.Scanner;

/*
 * @Problem     숫자의 합(11720)
 * @author      cooper
 * @created by  11.02.20
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int numberSize = Integer.parseInt(scanner.nextLine());
        char[] numbers = scanner.nextLine().toCharArray();

        for(char number : numbers){
            sum += number - '0';
        }

        System.out.println(sum);

        scanner.close();
    }
}
