package kio.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b15591_MooTube {
    static int N;
    static List<int[]>[] graph;
    static int bfs(int k, int start) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        visited[start] = true;
        q.offer(new int[] {start, Integer.MAX_VALUE});

        int count = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int usado = curr[1];

            for(int[] next : graph[node]) {
                int v = next[0];
                int w = next[1];
                if(!visited[v]) {
                    visited[v] = true;
                    int nextUsado = Math.min(usado, w);
                    if(nextUsado >= k) {
                        count++;
                        q.offer(new int[] {v, nextUsado});
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[x].add(new int[] {y, w});
            graph[y].add(new int[] {x, w});
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(bfs(k,v)).append('\n');
        }
        System.out.println(sb);
    }
}
