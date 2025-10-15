package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_b1446_지름길_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] shortcut = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) shortcut[i] = new ArrayList<>();

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(end > D || cost >= end - start) continue;
            shortcut[start].add(new int[]{end, cost});
        }
        int[] dp = new int[D+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < D; i++) {
            // 1. 일반 도로 이동
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            // 2. i에서 시작하는 지름길들만 확인
            for (int[] next : shortcut[i]) {
                int end = next[0];
                int cost = next[1];
                dp[end] = Math.min(dp[end], dp[i] + cost);
            }
        }
        System.out.println(dp[D]);
    }
}
