package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b2056_작업 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];
        List<Integer>[] graph = new ArrayList[N];
        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                int pre = Integer.parseInt(st.nextToken()) - 1;
                graph[pre].add(i);   // pre → i
                indegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                dp[next] = Math.max(dp[next], dp[cur] + cost[next]);
                if (--indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) answer =  Math.max(answer, dp[i]);
        System.out.println(answer);
    }
}
