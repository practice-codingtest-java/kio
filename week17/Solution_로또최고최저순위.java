package kio.week17;

import java.util.Arrays;

public class Solution_로또최고최저순위 {
    static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correct = 0;
        int zero = 0;
        for(int lot : lottos) {
            if(lot == 0){
                zero++;
                continue;
            }
            for(int win : win_nums) {
                if(win == lot) {
                    correct++;
                    break;
                }
            }
        }
        if(zero + correct > 1){
            answer[0] = 7 - zero - correct;
        }
        else{
            answer[0] = 6;
        }

        if(correct > 1){
            answer[1] = 7 - correct;
        }
        else{
            answer[1] = 6;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}
