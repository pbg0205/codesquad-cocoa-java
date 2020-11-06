package algorithm.baekjoon2475;
/*
 * @problem     검증수(2475)
 * @url         https://www.acmicpc.net/2475
 * @author      pbg0205
 * @created by  11.06.20
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.calculation(Input.makeIntArr(5));

        System.out.println(result);
    }
}

class Solution{

    public int calculation(int[] numbers){
        int sumOfnumbers;
        int remainder;

        sumOfnumbers = addElement(numbers);

        remainder = mod(sumOfnumbers);

        return remainder;
    }

    private int addElement(int[] numbers) {
        int sumOfnumbers = 0;

        for (int number : numbers) {
            sumOfnumbers += (int)Math.pow(number, 2);
        }

        return sumOfnumbers;
    }

    private int mod(int sumOfnumbers) {
        return sumOfnumbers % 10;
    }
}

class Input{
    private static Scanner scanner = new Scanner(System.in);

    private static int inputIntData(){
        return scanner.nextInt();
    }

    public static int[] makeIntArr(int size){
        int[] intArr = new int[size];

        for (int index = 0; index < size; index++) {
            intArr[index] = inputIntData();
        }

        return intArr;
    }
}