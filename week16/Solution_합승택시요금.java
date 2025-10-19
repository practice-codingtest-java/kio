package kio.week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_합승택시요금 {
    static List<int[]>[] map;
    static int[] dijkstra(int n, int s) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, s}); // {거리, 노드}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0];
            int curNode = cur[1];

            // 이미 더 짧은 거리로 처리된 노드라면 건너뜀
            if (curDist > dist[curNode]) continue;

            for(int[] next : map[curNode]){
                int nextNode = next[0];
                int weight = next[1];

                if (dist[nextNode] > dist[curNode] + weight) {
                    dist[nextNode] = dist[curNode] + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist;
    }
    static public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        map = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            map[i] = new ArrayList<>();
        for(int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int d = fare[2];
            map[x].add(new int[]{y,d});
            map[y].add(new int[]{x,d});
        }
        int[] distS = dijkstra(n,s);
        int[] distA = dijkstra(n,a);
        int[] distB = dijkstra(n,b);
        for(int i=1;i<=n;i++){
            if(distS[i] == Integer.MAX_VALUE || distA[i] == Integer.MAX_VALUE || distB[i] == Integer.MAX_VALUE) continue;
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }
}
