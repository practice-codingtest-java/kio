package kio.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for(int i=0; i < n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(wine[0]);
            return;
        }
        if (n == 2) {
            System.out.println(wine[0] + wine[1]);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = wine[0];
        dp[2] = wine[0] + wine[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1], // i-1번째까지 마시고 i번째 건너뜀.
                    Math.max(dp[i - 2] + wine[i - 1], dp[i - 3] + wine[i - 2] + wine[i - 1]) // i-1번 건너 뛰고 i번 마심, i-2번 건너뛰고 i-1,i번 마심
            );
        }
        System.out.println(dp[n]);
    }
}
