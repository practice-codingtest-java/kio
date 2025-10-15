package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_b1446_지름길_Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] adj = new ArrayList[D+1];
        for (int i=0; i<=D; i++) adj[i] = new ArrayList<>();

        for(int i = 1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (end <= D && end - start > weight) {
                adj[start].add(new int[]{end, weight});
            }
        }
        // cost, pos
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0]==D) {
                System.out.println(cur[1]);
                return;
            }
            int nextPos = cur[0] + 1;
            int nextWeight = cur[1] + 1;
            pq.offer(new int[]{nextPos,nextWeight});
            for(int[] next : adj[cur[0]]){
                nextPos = next[0];
                nextWeight = cur[1] + next[1];
                pq.offer(new int[]{nextPos,nextWeight});
            }
        }
    }
}
