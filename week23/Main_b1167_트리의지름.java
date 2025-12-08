package kio.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b1167_트리의지름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]>[] tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while(next != -1) {
                int weight = Integer.parseInt(st.nextToken());
                tree[idx].add(new int[] {weight, next});
                next = Integer.parseInt(st.nextToken());
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        int start = -1;
        int max1 = 0;
        boolean[] visited = new boolean[N+1];
        q.offer(new int[] {0, 1});
        visited[1] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] > max1){
                max1 = curr[0];
                start = curr[1];
            }
            for(int[] next : tree[curr[1]]) {
                if(visited[next[1]]) continue;
                visited[next[1]] = true;
                q.offer(new int[] {curr[0] + next[0], next[1]});
            }
        }
        int max2 = 0;
        visited = new boolean[N+1];
        q.offer(new int[] {0, start});
        visited[start] =  true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] > max2){
                max2 = curr[0];
            }
            for(int[] next : tree[curr[1]]) {
                if(visited[next[1]]) continue;
                visited[next[1]] = true;
                q.offer(new int[] {curr[0] + next[0], next[1]});
            }
        }
        System.out.println(max2);
    }
}
