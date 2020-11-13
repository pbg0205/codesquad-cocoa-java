package algorithm.programmers.sum_of_divisor;
/*
 * @problem     약수의 합(프로그래머스)
 * @url         https://programmers.co.kr/learn/courses/30/lessons/12928
 * @author      cooper
 * @created by  11.13.20
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        int range = n / 2;

        if(n == 1){
            return 1;
        }

        for (int number = 1; number < range; number++) {
            if(n % number == 0){
                answer += number;
            }
        }

        answer += n;

        return answer;
    }
}
