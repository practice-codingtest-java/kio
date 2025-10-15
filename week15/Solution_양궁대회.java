package kio.week15;

import java.util.Arrays;

public class Solution_양궁대회 {
    static int max;
    static int[] answer;
    static boolean tieBreak(int[] a, int[] b){
        if(a == null) return true;
        for(int i=10;i>=0;i--){
            if(a[i] < b[i]) return true;
            else if(a[i] > b[i]) return false;
        }
        return false;
    }
    static void backtrack(int remain, int[] info, int[] lion, int target){
        if(target == 11){
            int apeach = 0;
            int total = 0;
            if(remain > 0){
                lion[10] += remain;
            }
            for(int i = 0; i < info.length; i++){
                if(lion[i] > info[i]){
                    total += 10 - i;
                }
                else if(info[i] != 0){
                    apeach += 10 - i;
                }
            }
            int diff = total - apeach;
            if (total > apeach && (diff > max || (diff == max && tieBreak(answer, lion)))) {
                max = diff;
                answer = Arrays.copyOf(lion, 11);
            }
            if (remain > 0) lion[10] -= remain;
            return;
        }
        if(remain > info[target]){
            lion[target] = info[target] + 1;
            backtrack(remain - (info[target] + 1), info, lion, target + 1);
            lion[target] = 0; // 복원
        }
        backtrack(remain, info, lion, target+1);
    }
    public static int[] solution(int n, int[] info) {
        max = 0;
        backtrack(n,info,new int[11], 0);

        return (answer == null)? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n, info)));
    }
}
