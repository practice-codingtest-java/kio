package kio.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_b1949_우수마을 {
    static int[][] dp;
    static int[] weight;
    static List<Integer>[] adj;
    static void dfs(int cur, int parent) {
        dp[cur][0] = 0;
        dp[cur][1] = weight[cur];

        for(int next : adj[cur]) {
            if(next == parent) continue;

            dfs(next, cur);

            // cur 선택 X → next는 선택O/선택X 중 더 큰 값을 선택
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);

            // cur 선택 O → next는 반드시 선택X
            dp[cur][1] += dp[next][0];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weight = new int[n+1];
        dp = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1, -1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
