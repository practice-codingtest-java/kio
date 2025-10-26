package kio.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_b4485_젤다 {
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    static void dijkstra(int[][] map, int t, int n, StringBuilder sb){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{map[0][0],0,0});
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0] = map[0][0];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int w = cur[0];
            int x = cur[1];
            int y = cur[2];
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(dist[nx][ny] > w + map[nx][ny]){
                    dist[nx][ny] = w + map[nx][ny];
                    pq.offer(new int[]{dist[nx][ny],nx,ny});
                }
            }
        }
        sb.append("Problem ").append(t).append(": ").append(dist[n-1][n-1]).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int t = 1;
        while(n != 0){
            int[][] map = new int[n][n];
            for(int i = 0;i <n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0;j <n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra(map, t, n, sb);
            n = Integer.parseInt(br.readLine());
            t++;
        }
        System.out.println(sb);
    }
}
