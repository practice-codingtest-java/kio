package kio.week23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        for(int[] r : road){
            int x = r[0];
            int y = r[1];
            int w = r[2];
            graph[x].add(new int[]{y,w});
            graph[y].add(new int[]{x,w});
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for(int[] next : graph[cur[1]]){
                int y = next[0];
                int w = next[1];
                if(dist[y] > dist[cur[1]] + w){
                    dist[y] = dist[cur[1]] + w;
                    pq.offer(new int[]{dist[y], y});
                }
            }
        }
        for(int d : dist){
            if(d <= K) answer++;
        }
        return answer;
    }
}
