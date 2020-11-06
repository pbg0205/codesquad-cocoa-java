package algorithm.beakjoon2908;

import java.util.Scanner;

/*
 * @problem     상수(2908)
 * @url         https://www.acmicpc.net/2908
 * @author      pbg0205
 * @created by  11.06.20
 */
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }
}

class Solution{
    private Sangsu sangsu;

    public Solution(){
        this.sangsu = new Sangsu();
    }

    public void start(){
        int firstNumber = sangsu.makeSansuNumber(Input.inputNumberStr());
        int secondNumber = sangsu.makeSansuNumber(Input.inputNumberStr());
        int MaxOfSansu = sangsu.getMaxOfSansuNumber(firstNumber, secondNumber);

        System.out.println(MaxOfSansu);
    }
}

class Input{
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNumberStr(){
        return scanner.next();
    }
}

class Sangsu{
    public int makeSansuNumber(String numberStr){
        return swapNumbers(numberStr);//TODO return 값 표시
    }

    private int swapNumbers(String numberStr) {
        char[] numberCharArr = numberStr.toCharArray();
        int numberLen = numberCharArr.length;

        for (int left = 0; left < numberLen / 2; left++) {
            int right = numberLen - (left + 1); /*양 끝의 인덱스를 순차적으로 swap*/

            swap(numberCharArr, left, right);
        }
        numberStr = String.valueOf(numberCharArr);

        return toInt(numberStr);
    }

    private void swap(char[] numberCharArr, int left, int right) {
        char tmp = numberCharArr[left];
        numberCharArr[left] = numberCharArr[right];
        numberCharArr[right] = tmp;
    }

    private int toInt(String value){
        return Integer.parseInt(value);
    }

    public int getMaxOfSansuNumber(int firstNumber, int secondNumber){
        if(firstNumber >= secondNumber){
            return firstNumber;
        }

        return secondNumber;
    }
}
