package kio.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b25682_체스판다시칠하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] blackAcc = new int[N+1][M+1];
        int[][] whiteAcc = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                boolean isBlack = (line.charAt(j-1) == 'B');
                int blackDiff = 0, whiteDiff = 0;
                if (((i + j) & 1) == 0 ^ isBlack) {
                    blackDiff = 1;
                } else {
                    whiteDiff = 1;
                }
                blackAcc[i][j] = blackAcc[i-1][j] + blackAcc[i][j-1] - blackAcc[i-1][j-1] + blackDiff;
                whiteAcc[i][j] = whiteAcc[i-1][j] + whiteAcc[i][j-1] - whiteAcc[i-1][j-1] + whiteDiff;
            }
        }

        // K×K 부분 체스판의 불일치 최소값 계산
        int ans = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int black = blackAcc[i][j] - blackAcc[i-K][j] - blackAcc[i][j-K] + blackAcc[i-K][j-K];
                int white = whiteAcc[i][j] - whiteAcc[i-K][j] - whiteAcc[i][j-K] + whiteAcc[i-K][j-K];
                ans = Math.min(ans, Math.min(black, white));
            }
        }
        System.out.println(ans);


    }
}
