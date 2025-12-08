package kio.week23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_파이프옮기기1 {
    static int N;
    static int[][] board;
    static long[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][N][3];

        // 초기 상태: (0,1) 가로 파이프
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 가로
                if (j + 1 < N && board[i][j+1] == 0) {
                    dp[i][j+1][0] += dp[i][j][0];
                    dp[i][j+1][0] += dp[i][j][2];
                }

                // 세로
                if (i + 1 < N && board[i+1][j] == 0) {
                    dp[i+1][j][1] += dp[i][j][1];
                    dp[i+1][j][1] += dp[i][j][2];
                }


                // 대각선
                if (i + 1 < N && j + 1 < N &&
                        board[i][j+1] == 0 &&
                        board[i+1][j] == 0 &&
                        board[i+1][j+1] == 0) {

                    dp[i+1][j+1][2] += dp[i][j][0];
                    dp[i+1][j+1][2] += dp[i][j][1];
                    dp[i+1][j+1][2] += dp[i][j][2];
                }
            }
        }

        long answer = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(answer);
    }
}
