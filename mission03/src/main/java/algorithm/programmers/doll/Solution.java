package algorithm.programmers.doll;

import java.util.*;
//TODO testcase1, 2 실패
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board =   {{0,0,0,0,0},
                            {0,0,1,0,3},
                            {0,2,5,0,1},
                            {4,2,4,4,2},
                            {3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};

        int[][] board2 =  {{0, 0, 1, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 2, 1, 0, 0},
                            {0, 2, 1, 0, 0},
                            {0, 2, 1, 0, 0}};
        int[] moves2 = {1, 2, 3, 3, 2, 3, 1};

        int result = solution.solution(board2, moves2);
        System.out.println(result);
    }

    public int solution(int[][] board, int[] moves) {
        int matchingCount = 0;
        Stack<Integer> shippingBasket = new Stack<>();
        int boardLen = board.length;

        for (int move : moves) {
            int col = move - 1;
            int basketUpperNumber;
            int pickedNumber = -1;

            //1.크레인으로 인형 뽑는 로직
            for (int row = 0; row < boardLen; row++) {
                if (board[row][col] != 0) {
                    pickedNumber = board[row][col];
                    board[row][col] = 0;
                    break;
                }
                pickedNumber = -1;
            }

            if(pickedNumber < 0){
                continue;
            }

            //2.비어있는 바구니 예외처리
            if(shippingBasket.size() == 0){
                shippingBasket.push(pickedNumber);
                continue;
            }

            //3.꺼낸 인형과 바구니 윗 숫자와 비교
            basketUpperNumber = shippingBasket.peek();

            if(pickedNumber == basketUpperNumber){
                shippingBasket.pop();
                matchingCount += 2;
            }else{
                shippingBasket.push(pickedNumber);
            }
        }

        return matchingCount;
    }
}
