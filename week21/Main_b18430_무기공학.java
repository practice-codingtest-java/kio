package kio.week21;

import java.io.*;
import java.util.*;

public class Main_b18430_무기공학 {
    static int N, M;
    static int[][] map;
    static boolean[][] used;
    static int answer = 0;

    // 부메랑 4방향
    static int[][] wing1 = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] wing2 = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        used = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int sum) {
        answer = Math.max(answer, sum);
        if (idx == N * M) return;

        int r = idx / M;
        int c = idx % M;

        // 1) 건너뛰기
        dfs(idx + 1, sum);

        // 2) 부메랑 놓기
        if (!used[r][c]) {
            for (int d = 0; d < 4; d++) {
                int r1 = r + wing1[d][0];
                int c1 = c + wing1[d][1];
                int r2 = r + wing2[d][0];
                int c2 = c + wing2[d][1];

                if (!inRange(r1, c1) || !inRange(r2, c2)) continue;
                if (used[r1][c1] || used[r2][c2]) continue;

                used[r][c] = used[r1][c1] = used[r2][c2] = true;

                int value = map[r][c] * 2 + map[r1][c1] + map[r2][c2];
                dfs(idx + 1, sum + value);

                used[r][c] = used[r1][c1] = used[r2][c2] = false;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }
}
