package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_b6087_레이저통신_01BFS {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int sx = -1, sy = -1, ex = -1, ey = -1;
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 'C') {
                    if(sx == -1) sx = i;
                    else ex = i;
                    if(sy == -1) sy = j;
                    else ey = j;
                }
            }
        }
        int[][][] dist = new int[N][M][4];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], 123456);
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        for(int d = 0; d < 4; d++) {
            dist[sx][sy][d] = 0;
            q.offerLast(new int[]{sx, sy, d});
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int prevDir = cur[2];
            int x = cur[0];
            int y = cur[1];
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == '*') continue;
                int cost;
                if(prevDir == d) {     // 같은 방향
                    cost = dist[x][y][prevDir];
                }
                else{                      // 방향 전환
                    cost = dist[x][y][prevDir] + 1;
                }
                if(cost >= dist[nx][ny][d]) continue;
                dist[nx][ny][d] = cost;
                if(prevDir == -1 || prevDir == d) {
                    q.addFirst(new int[]{nx, ny, d}); // 비용 0
                } else {
                    q.addLast(new int[]{nx, ny, d});  // 비용 1
                }
            }
        }
        int answer = 123456;
        for(int d = 0; d < 4; d++) {
            answer = Math.min(answer, dist[ex][ey][d]);
        }
        System.out.println(answer);
    }
}
