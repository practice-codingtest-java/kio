package kio.week19;

import java.util.Arrays;

public class Solution_최고의집합 {
    public int[] solution(int n, int s) {
        // 불가능한 경우
        if(s/n <= 0 ) return new int[]{-1};
        int[] answer = new int[n];
        // 최대한 값이 유사하게 n등분 했을때가 최고이다
        int max = s/n;
        Arrays.fill(answer, max);
        int remain = s%n;
        for(int i = n-remain; i < n; i++) {
            answer[i]++;
        }
        return answer;
    }
}
