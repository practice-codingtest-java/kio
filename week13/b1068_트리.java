package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1068_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i;
            else tree[parent].add(i);
        }
        int erase = Integer.parseInt(br.readLine());
        if (erase == root) {
            System.out.println(0);
            return;
        }

        System.out.print(dfs(root,erase,tree));

    }
    static int dfs(int node, int erase, ArrayList<Integer>[] tree) {
        if (node == erase) return 0;
        if (tree[node].isEmpty() || (tree[node].size() == 1 && tree[node].get(0) == erase)) {
            return 1;
        }
        int cnt = 0;
        for (int child : tree[node]) {
            cnt += dfs(child, erase, tree);
        }
        return cnt;
    }

}
