package kio.week18;

import java.util.Arrays;

public class Solution_입국심사 {
    static public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long)Arrays.stream(times).max().getAsInt() * n;
        while(left <= right) {
            // 오버플로우 방지
            long mid = left + (right - left) / 2;
            long cnt = 0;
            for(int i = 0; i < times.length; i++) {
                cnt += mid/times[i];
            }
            if(cnt >= n){
                answer = mid;
                right = mid - 1;
            }
            else if(cnt < n){
                left = mid + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1,2}));
    }
}
