package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b4195_친구네트워크 {
    static int[] parent;
    static int[] size;
    static int find(int v){
        if(v==parent[v]) return v;
        return parent[v] = find(parent[v]);
    }
    static int union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x==y) return size[x];
        if(size[x] < size[y]){
            parent[x] = y;
            size[y] += size[x];
            return size[y];
        } else {
            parent[y] = x;
            size[x] += size[y];
            return size[x];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            int n =  Integer.parseInt(br.readLine());
            parent = new int[2 * n];
            size = new int[2 * n];
            for(int i=0; i<2*n; i++){
                parent[i] = i;
                size[i] = 1;
            }
            Map<String, Integer> map = new HashMap<>();
            int idx = 0;
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)){
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)){
                    map.put(b, idx++);
                }
                int result = union(map.get(a), map.get(b));
                sb.append(result).append('\n');
            }
        }
        System.out.print(sb);
    }
}
