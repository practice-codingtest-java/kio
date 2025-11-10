package kio.week19;

import java.util.PriorityQueue;

public class Solution_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int work : works) pq.offer(work);
        while(n > 0 && !pq.isEmpty()){
            n--;
            int cur = pq.poll();
            if(cur == 1) continue;
            pq.offer(cur-1);
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer += (long) cur *cur;
        }
        return answer;
    }
}
