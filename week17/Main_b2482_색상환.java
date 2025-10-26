package kio.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b2482_색상환 {
    static final int MOD = 1_000_000_003;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][k+1];
        // i개의 색 중 n개를 선택하는 경우의 수 1개
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        // i개중 1개를 선택하는 경우 1개
        for (int i = 1; i <= n; i++) dp[i][1] = i;
        // i개중 k개를 선택하는 경우 = i번째 선택 x + i번째 선택 o
        for (int i = 2; i <= n; i++){
            for(int j = 2; j <= k; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
            }
        }

        // 원형이므로 1번을 선택한 경우와 선택하지 않은 경우로 나눠서 생각해야함.
        // 1번을 선택하지 않은 경우 = dp[n-1][k] (n-1개 중에서 k개 선택)
        // 1번을 선택한 경우 -> 2번,n번 제외 & 1번 고정 = dp[n-3][k-1] (n-3개 중 k-1개 선택)
        int ans = (dp[n-1][k] + dp[n-3][k-1]) % MOD;
        System.out.println(ans);

    }
}
