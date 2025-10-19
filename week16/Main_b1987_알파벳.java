package kio.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b1987_알파벳 {
    static int answer = 1;
    static int n,m;
    static char[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static void dfs(int x, int y, boolean[] visited, int cnt){
        answer = Math.max(answer,cnt);
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            int idx = board[nx][ny]-'A';
            if(visited[idx]) continue;
            visited[idx] = true;
            dfs(nx,ny, visited,cnt+1);
            visited[idx] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][];
        for(int i = 0;i<n;i++){
            String line = br.readLine();
            board[i] = line.toCharArray();
        }
        boolean[] visited = new boolean[26];
        visited[board[0][0]-'A'] = true;
        dfs(0,0, visited, 1);
        System.out.println(answer);
    }
}
