package kio.week21;

import java.util.*;

public class Solution_swea1868_지뢰찾기 {

    static char[][] board;
    static boolean[][] visited;
    static int n;

    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    static int checkBomb(int x, int y){
        int cnt = 0;
        for(int d=0; d<8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0||nx>=n||ny<0||ny>=n) continue;
            if(board[nx][ny] == '*') cnt++;
        }
        return cnt;
    }

    static void bfs(int x, int y){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            int bombs = checkBomb(cx, cy);
            if(bombs > 0) continue;  // 숫자칸은 퍼지지 않음

            for(int d=0; d<8; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(board[nx][ny]=='*' || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=T; tc++){
            n = sc.nextInt();
            board = new char[n][n];
            visited = new boolean[n][n];

            for(int i=0; i<n; i++){
                String s = sc.next();
                for(int j=0; j<n; j++){
                    board[i][j] = s.charAt(j);
                }
            }

            int clicks = 0;

            // 1) 0 칸 BFS 먼저 실행
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == '*' || visited[i][j]) continue;
                    if(checkBomb(i,j) == 0){
                        bfs(i,j);
                        clicks++;
                    }
                }
            }

            // 2) BFS로 안 열린 숫자칸 하나씩 클릭
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] != '*' && !visited[i][j]){
                        clicks++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(clicks).append("\n");
        }

        System.out.print(sb);
    }
}
