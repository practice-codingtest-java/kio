package kio.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_b1647_도시분할계획 {
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
    static int[] parent;
    static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a,b,w});
        }
        int sum = 0;
        int maxCost = 0;

        while (!edges.isEmpty()) {
            int[] e = edges.poll();

            if (find(e[0]) != find(e[1])) {
                union(e[0], e[1]);
                sum += e[2];
                maxCost = e[2];
            }
        }
        System.out.println(sum - maxCost);
    }
}
