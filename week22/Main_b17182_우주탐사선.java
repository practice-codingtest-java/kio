package kio.week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b17182_우주탐사선 {
    static int[][] graph;
    static int[][] dp;
    static int answer, N, full_mask;
    static int dfs(int pos, int visited){
        visited |= (1<<pos);
        if (visited == full_mask) {
            return 0;
        }

        if (dp[pos][visited] != -1) {
            return dp[pos][visited];
        }

        int ret = Integer.MAX_VALUE;

        for (int nxt = 0; nxt < N; nxt++) {
            if ((visited & (1 << nxt)) == 0) {
                int cost = graph[pos][nxt] + dfs(nxt, visited | (1 << nxt));
                ret = Math.min(ret, cost);
            }
        }

        return dp[pos][visited] = ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        full_mask = (1 << N) - 1;
        int start = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        dp = new int[N][1<<N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i],-1);
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
        answer = dfs(start, 0);
        System.out.println(answer);
    }
}
