package algorithm.programmers.divide_arr;

import java.util.*;

/*
 * @problem     나누어 떨어지는 배열(프로그래머스)
 * @url         https://programmers.co.kr/learn/courses/30/lessons/12910
 * @author      cooper
 * @created by  11.13.20
 */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {5,9, 7, 10};
        int divisor = 5;

        int[] result = solution.solution(arr, divisor);
        System.out.println(result);
    }

    public int[] solution(int[] arr, int divisor) {
        int[] answer;

        List<Integer> answerList = new ArrayList<>();

        for (int number : arr) {
            if(number % divisor == 0){
                answerList.add(number);
            }
        }

        int listSize = answerList.size();

        //size == 0, 예외 처리
        if(listSize == 0){
            return new int[]{-1};
        }

        Collections.sort(answerList);
        answer = new int[listSize];

        for (int index = 0; index < listSize; index++) {
            answer[index] = answerList.get(index);
        }

        return answer;
    }
}
