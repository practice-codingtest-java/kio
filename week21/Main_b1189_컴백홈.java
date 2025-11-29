package kio.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b1189_컴백홈 {
    static int answer, N, M, K;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void dfs(int row, int col, int depth, boolean[][] visited) {
        if(depth == K) {
            if(row == 0 && col == M-1) answer++;
            return;
        }
        for(int d=0; d<4;d++){
            int nx = row + dx[d];
            int ny = col + dy[d];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(board[nx][ny] == 'T' || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, depth+1, visited);
            visited[nx][ny] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        boolean[][] visited = new boolean[N][M];
        visited[N-1][0] = true;
        dfs(N-1,0, 1, visited);
        System.out.println(answer);
    }
}
