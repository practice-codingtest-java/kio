package kio.week21;

import java.util.*;

public class Solution_swea1244_최대상금 {
    static String answer;
    static int change;
    static Set<String>[] visited;

    static void dfs(char[] arr, int depth) {
        String cur = new String(arr);
        if (depth == change) {
            answer = max(answer, cur);
            return;
        }
        if (visited[depth].contains(cur)) return;
        visited[depth].add(cur);

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(arr, i, j);
                dfs(arr, depth + 1);
                swap(arr, i, j);
            }
        }
    }

    static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static String max(String a, String b) {
        if (a.compareTo(b) < 0) return b;
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= T; test++) {
            String N = sc.next();
            change = sc.nextInt();
            answer = "0";
            visited = new HashSet[change + 1];
            for (int i = 0; i <= change; i++) visited[i] = new HashSet<>();
            dfs(N.toCharArray(), 0);
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
