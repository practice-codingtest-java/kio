package kio.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b5927_택배배송 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b,c});
            graph[b].add(new int[] {a,c});
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, 1_000_000_000);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] {1,0});
        dist[1] = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            for(int[] next : graph[x]){
                int nx = next[0];
                int nw = next[1];
                if(dist[nx] > dist[x] + nw ){
                    dist[nx] = dist[x] + nw;
                    pq.offer(new int[] {nx,dist[nx]});
                }
            }
        }
        System.out.println(dist[N]);
    }
}
