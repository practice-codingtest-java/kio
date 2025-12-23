package kio.week25;

import java.io.*;
import java.util.*;

public class Main_b6087_레이저통신_dijkstra {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int INF = 1_000_000;

    static class Node implements Comparable<Node> {
        int x, y, dir, cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        int sx = -1, sy = -1, ex = -1, ey = -1;

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'C') {
                    if (sx == -1) {
                        sx = i; sy = j;
                    } else {
                        ex = i; ey = j;
                    }
                }
            }
        }

        int[][][] dist = new int[N][M][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                Arrays.fill(dist[i][j], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점: 4방향 모두 시작
        for (int d = 0; d < 4; d++) {
            dist[sx][sy][d] = 0;
            pq.offer(new Node(sx, sy, d, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;

            if (dist[x][y][dir] < cost) continue;

            for (int nd = 0; nd < 4; nd++) {
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == '*') continue;

                int newCost = cost;
                if (dir != nd) newCost++; // 방향 전환

                if (newCost < dist[nx][ny][nd]) {
                    dist[nx][ny][nd] = newCost;
                    pq.offer(new Node(nx, ny, nd, newCost));
                }
            }
        }

        int answer = INF;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, dist[ex][ey][d]);
        }

        System.out.println(answer);
    }
}
