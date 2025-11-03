package kio.week18;

import java.util.Arrays;

public class Solution_징검다리 {
    boolean check(int[] rocks, int distance, int n, int minDistance) {
        int removed = 0;
        int prev = 0; // 출발점
        for (int rock : rocks) {
            if (rock - prev < minDistance) { // 최소 거리 미만이면 제거
                removed++;
            } else {
                prev = rock; // 현재 바위 살리기
            }
        }
        // 마지막 도착지까지 고려
        if (distance - prev < minDistance) removed++;

        return removed <= n;
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = distance/rocks.length;
        int right = distance;
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(check(rocks, distance, n, mid)) {
                left = mid+1;
                answer = mid;
            }
            else{
                right = mid-1;
            }
        }
        return answer;
    }
}
