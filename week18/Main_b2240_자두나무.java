package kio.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_b2240_자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int prev = Integer.parseInt(br.readLine());
        List<int[]> blocks = new ArrayList<>();
        int count = 1;
        for(int i = 1; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr == prev) count++;
            else {
                blocks.add(new int[]{prev, count});
                prev = curr;
                count = 1;
            }
        }
        // 마지막 블록 추가
        blocks.add(new int[]{prev, count});

        int K = blocks.size();
        // i번 블록까지 j번 움직였을때 최대 자두 개수
        int[][] dp = new int[K + 1][M + 1];
        for (int i = 0; i < K; i++) {
            int tree = blocks.get(i)[0];
            int amount = blocks.get(i)[1];
            for (int j = 0; j <= M; j++) {

                int pos = (j % 2 == 0) ? 1 : 2;
                int gainStay = (pos == tree) ? amount : 0;
                int gainMove = (pos != tree) ? amount : 0;

                // ① 이동하지 않고 그대로 있는 경우
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + gainStay);

                // ② 이동하는 경우 (이동 횟수 여유 있을 때만)
                if (j + 1 <= M) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + gainMove);
                }
            }
        }

        int result = 0;
        for (int j = 0; j <= M; j++) {
            result = Math.max(result, dp[K][j]);
        }

        System.out.println(result);
    }
}
