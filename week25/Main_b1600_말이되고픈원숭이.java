package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_b1600_말이되고픈원숭이 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}, hx = {-1,-1,-2,-2,2,2,1,1}, hy = {-2,2,-1,1,-1,1,-2,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][][] visited = new boolean[h][w][k+1];
        int[][] map = new int[h][w];
        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        int answer = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0],y = cur[1];
            int ck = cur[2];
            int cost = cur[3];
            if(x==h-1 && y==w-1){
                answer = cost;
                break;
            }
            for(int d=0;d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if(map[nx][ny] == 1 || visited[nx][ny][ck]) continue;
                visited[nx][ny][ck] = true;
                q.offer(new int[]{nx,ny,ck,cost+1});
            }
            if(ck < k) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur[0] + hx[d];
                    int ny = cur[1] + hy[d];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (map[nx][ny] == 1 || visited[nx][ny][ck + 1]) continue;
                    visited[nx][ny][ck + 1] = true;
                    q.offer(new int[]{nx, ny, ck + 1,cost+1});
                }
            }
        }
        System.out.println(answer);
    }
}
