package kio.week17;

import java.util.ArrayDeque;

public class Solution_크레인인형뽑기 {
    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int move : moves){
            int picked = 0;
            for (int i = 0; i < board.length; i++){
                if(board[i][move-1] != 0){
                    picked = board[i][move - 1];
                    board[i][move-1] = 0;
                    break;
                }
            }
            if (picked == 0) continue;
            if(!stack.isEmpty() && stack.peek() == picked){
                stack.pop();
                answer += 2;
            }
            else{
                stack.push(picked);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
}
