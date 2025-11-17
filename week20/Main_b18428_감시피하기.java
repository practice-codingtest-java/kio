package kio.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_b18428_감시피하기 {
    static int N;
    static boolean answer;
    static List<int[]> teachers;
    static boolean check(char[][] board){
        for(int[] teacher: teachers) {
            int x = teacher[0];
            int y = teacher[1];
            int nx = x;
            int ny = y;
            while(nx >= 0){
                if(board[nx][ny] == 'S') return false;
                if(board[nx][ny] == 'O') break;
                nx--;
            }
            nx = x;
            while(nx < N){
                if(board[nx][ny] == 'S') return false;
                if(board[nx][ny] == 'O') break;
                nx++;
            }
            nx = x;
            while(ny >= 0){
                if(board[nx][ny] == 'S') return false;
                if(board[nx][ny] == 'O') break;
                ny--;
            }
            ny = y;
            while(ny < N){
                if(board[nx][ny] == 'S') return false;
                if(board[nx][ny] == 'O') break;
                ny++;
            }
        }
        return true;
    }
    static void dfs(int depth, int prev, char[][] map){
        if(depth == 3){
            if(check(map)){
                answer = true;
            }
            return;
        }
        for(int i = prev+1; i < N*N; i++){
            int row = i/N;
            int col = i%N;
            if(map[row][col] != 'X') continue;
            map[row][col] = 'O';
            dfs(depth+1, i, map);
            map[row][col] = 'X';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        answer = false;
        teachers = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') teachers.add(new int[] {i,j});
            }
        }
        dfs(0,-1, map);
        System.out.println(answer ? "YES" : "NO");
    }
}
