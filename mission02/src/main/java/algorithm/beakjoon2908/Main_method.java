package algorithm.beakjoon2908;
/*
 * @problem     상수(2908)
 * @url         https://www.acmicpc.net/2908
 * @author      pbg0205
 * @created by  11.06.20
 */

import java.util.Scanner;

class Main_method {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumberStr = scanner.next();
        String secondNumberStr = scanner.next();

        int firstNumber = swapNumberBySansu(firstNumberStr);
        int seondNumber = swapNumberBySansu(secondNumberStr);

        int maxValue = getMax(firstNumber, seondNumber);

        System.out.println(maxValue);

        scanner.close();
    }

    private static int getMax(int firstNumber, int seondNumber) {
        if(firstNumber >= seondNumber){
            return firstNumber;
        }

        return seondNumber;
    }

    private static int swapNumberBySansu(String numberStr) {
        int numberLen = numberStr.length();
        char[] numberCharArr = numberStr.toCharArray();

        for (int left = 0; left < numberLen / 2; left++) {
            int right = numberLen - (left + 1);

            swap(numberCharArr, left, right);
        }

        numberStr = String.valueOf(numberCharArr);

        return toInt(numberStr);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static void swap(char[] numberCharArr, int left, int right) {
        char tmp = numberCharArr[left];
        numberCharArr[left] = numberCharArr[right];
        numberCharArr[right] = tmp;
    }
}
