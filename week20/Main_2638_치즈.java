package kio.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2638_치즈 {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void bfs() {
        boolean[][] visited = new boolean[N+2][M+2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        map[0][0] = -1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N+2 || ny >= M+2) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                map[nx][ny] = -1;
                q.offer(new int[]{nx,ny});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map =  new int[N+2][M+2];
        int cnt = 0;
        Deque<int[]> cheese = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    cnt++;
                    cheese.offer(new int[]{i, j});
                }
            }
        }
        int time= 0;
        while(cnt > 0){
            bfs();
            int size = cheese.size();
            List<int[]> melt =  new ArrayList<>();
            for(int i=0;i<size;i++){
                int[] ch = cheese.poll();
                int x = ch[0];
                int y = ch[1];
                int air = 0;
                for(int d = 0; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(map[nx][ny] == -1) air++;
                }
                if(air >= 2){
                    cnt--;
                    melt.add(ch);
                }
                else{
                    cheese.offer(ch);
                }
            }
            for(int[] r : melt){
                map[r[0]][r[1]] = 0;
            }
            time++;
        }
        System.out.println(time);
    }
}
