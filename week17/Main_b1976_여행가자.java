package kio.week17;

import java.io.*;
import java.util.StringTokenizer;

public class Main_b1976_여행가자 {
    static int[] parent;
    static int[] rank;
    static int find(int x) {
        // root가 아니라면 root까지 재귀
        if (parent[x] != x) {
            // 경로 압축 - root 와의 거리를 1로 줄이기
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;
        // rank가 높은 쪽으로 합치기
        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }else if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                String x =(st.nextToken());
                if(x.equals("0")) continue;
                union(i,j);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int i = 0; i<m-1;i++){
            int current = Integer.parseInt(st.nextToken());
            if(find(prev) != find(current)){
                System.out.println("NO");
                return;
            }
            prev = current;
        }
        System.out.println("YES");
    }
}
