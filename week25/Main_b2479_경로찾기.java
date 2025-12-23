package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b2479_경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] val = new int[N];
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(br.readLine(),2);
        }
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for(int j=i+1;j<N;j++){
                if(Integer.bitCount(val[i] ^ val[j]) == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[N];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end) break;

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;   // ⭐ 경로 기록
                    queue.add(next);
                }
            }
        }
        if (!visited[end]) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = end; v != -1; v = parent[v]) {
            path.add(v);
        }

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int v : path) {
            sb.append(v + 1).append(" ");
        }
        System.out.println(sb);
    }
}
