package algorithm.baekjoon1330;
/*
 * @Problem     두 수 비교하기(1330)
 * @author      cooper
 * @created by  11.02.20
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        if(firstNumber > secondNumber){
            System.out.println(">");
        }

        if(firstNumber == secondNumber){
            System.out.println("==");
        }

        if(firstNumber < secondNumber){
            System.out.println("<");
        }

        scanner.close();
    }
}
