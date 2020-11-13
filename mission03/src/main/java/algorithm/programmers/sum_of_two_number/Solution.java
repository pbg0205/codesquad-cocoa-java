package algorithm.programmers.sum_of_two_number;

/*
 * @problem     두 개 뽑아서 더하기(프로그래머스)
 * @url         https://programmers.co.kr/learn/courses/30/lessons/68644
 * @author      cooper
 * @created by  11.13.20
 */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int[] solution(int[] numbers) {
        int[] answer;

        Set<Integer> set = new HashSet<>();
        int numberLen = numbers.length;

        Arrays.sort(numbers);

        for (int left = 0; left < numberLen - 1; left++) {
            for (int right = left + 1; right < numberLen; right++) {
                int sum = numbers[left] + numbers[right];

                if(!set.contains(sum)){
                    set.add(sum);
                }
            }
        }

        answer = set.stream().mapToInt(number -> number).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
