package kio.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b14938_서강그라운드 {
    static int[] weights;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지역 수
        int M = Integer.parseInt(st.nextToken()); // 수색 범위
        int R = Integer.parseInt(st.nextToken()); // 길 수

        weights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            weights[i] = Integer.parseInt(st.nextToken());


        int[][] dist = new int[N + 1][N + 1];

        // dist 배열 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
            dist[b][a] = c;
        }


        // 플로이드–워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 각 시작점에서 아이템 최대 합 계산
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] <= M) {
                    sum += weights[j];
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}