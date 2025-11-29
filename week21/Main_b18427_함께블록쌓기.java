package kio.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b18427_함께블록쌓기 {
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] dp = new int[H + 1];
        dp[0] = 1; // 아무도 선택하지 않은 경우

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int[] next = new int[H + 1];

            // 이 사람을 선택하지 않는 경우
            for (int h = 0; h <= H; h++) {
                next[h] = dp[h];
            }

            // 이 사람이 가진 블록을 하나 선택
            while (st.hasMoreTokens()) {
                int b = Integer.parseInt(st.nextToken());
                if (b == 0) continue;   // 0 높이 블록은 의미 없음

                for (int h = b; h <= H; h++) {
                    next[h] = (next[h] + dp[h - b]) % MOD;
                }
            }

            dp = next;
        }

        System.out.println(dp[H] % MOD);
    }
}
