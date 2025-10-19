package kio.week16;

import java.util.*;

public class Solution_가장먼노드 {
    static public int solution(int n, int[][] edge) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n+1];
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        Arrays.fill(dist, -1);
        dist[1] = 0;
        q.offer(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }
        int maxDist = 0;
        int count = 0;
        for (int d : dist) {
            if (d > maxDist) {
                maxDist = d;
                count = 1;
            } else if (d == maxDist) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    }
}
