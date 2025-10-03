package kio.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1325_효율적인해킹 {
    static List<Integer>[] graph;
    static int bfs(int start){
        boolean[] visited = new boolean[graph.length];
        int ret = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        ret++;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i : graph[cur]){
                if(visited[i]) continue;
                visited[i] = true;
                ret++;
                queue.add(i);
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        StringBuilder answer = new StringBuilder();
        int max = 0;
        for(int i=1;i<=n;i++){
            int hacked = bfs(i);
            if(max < hacked){
                max = hacked;
                answer.setLength(0);
                answer.append(i).append(" ");
            }
            else if(max == hacked){
                answer.append(i).append(" ");
            }
        }
        System.out.println(answer);
    }
}
