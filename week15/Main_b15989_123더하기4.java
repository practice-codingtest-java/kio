package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final int MAX = 10000;
        int[] dp = new int[MAX + 1];
        dp[0] = 1;

        // coin-change 방식: coin들을 외부 루프로 두면 "순서 무시" 조합을 센다.
        for (int coin = 1; coin <= 3; coin++) {
            for (int i = coin; i <= MAX; i++) {
                dp[i] += dp[i - coin];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
