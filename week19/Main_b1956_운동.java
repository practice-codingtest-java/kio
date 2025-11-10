package kio.week19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_b1956_운동 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        int[][] dist = new int[V+1][V+1];
        final int INF = 1_000_000_000;
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[a][b] = w;
        }
        for (int k = 1; k <= V; k++) {        // 중간 노드
            for (int i = 1; i <= V; i++) {    // 출발 노드
                for (int j = 1; j <= V; j++) { // 도착 노드
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dist[i][i]);
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}
