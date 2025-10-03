package kio.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b1326_폴짝폴짝 {
    static int[] bridge;
    static int n;
    static int bfs(int a, int b){
        boolean[] visited = new boolean[n+1];
        visited[a] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {a,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int pos = cur[0];
            int cost = cur[1];
            if(pos == b) return cost;

            // 오른쪽 점프
            for(int i = 1;;i++){
                int nextPos = pos + bridge[pos]*i;
                if(nextPos > n) break;
                if(visited[nextPos]) continue;
                visited[nextPos] = true;
                queue.offer(new int[] {nextPos,cost+1});
            }
            // 왼쪽 점프
            for(int i = 1;;i++){
                int nextPos = pos - bridge[pos]*i;
                if(nextPos < 1) break;
                if(visited[nextPos]) continue;
                visited[nextPos] = true;
                queue.offer(new int[] {nextPos,cost+1});
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        bridge = new int[n+1];
        for(int i = 1; i <= n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(bfs(a,b));
    }
}
