package kio.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_b15681_트리와쿼리 {
    static int N,R,Q;
    static int[] subTreeSize;
    static List<Integer>[] graph;

    static void dfs(int cur, int parent){
        subTreeSize[cur] = 1;
        for(int next : graph[cur]){
            if(next == parent) continue;
            dfs(next, cur);
            subTreeSize[cur] += subTreeSize[next];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        subTreeSize = new int[N+1];
        dfs(R,-1);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=Q;i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(subTreeSize[q]).append("\n");
        }
        System.out.println(sb);
    }
}
