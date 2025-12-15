package kio.week24;

import java.util.PriorityQueue;

public class Solution_디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int round = 0; // 현재 라운드
        for (int cur : enemy) {
            pq.offer(-cur);
            n -= cur;

            if (n < 0) {  // 병력이 부족한 시점
                if (k > 0) {
                    k--;
                    // 가장 큰 적(음수로 저장된 값)을 무적권 처리 → 그만큼 병력 복구
                    n -= pq.poll();  // n -= (-max) == n += max
                } else {
                    break;
                }
            }

            round++;
        }
        return round;
    }
}
