package kio.week23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b2310_어드벤처게임 {
    static char[] type;
    static List<Integer>[] graph;
    static int[] cost;
    static boolean[] visited;
    static int N;
    static boolean flag;

    static void dfs(int room, int money) {
        if (flag) return;
        if (room == N) {
            flag = true;
            return;
        }

        visited[room] = true;

        for (int next : graph[room]) {
            if (visited[next]) continue;

            int nextMoney = money;

            if (type[next] == 'L') {
                nextMoney = Math.max(nextMoney, cost[next]);
            } else if (type[next] == 'T') {
                if (nextMoney < cost[next]) continue;
                nextMoney -= cost[next];
            }

            dfs(next, nextMoney);
        }

        visited[room] = false; // 백트래킹!
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            graph = new ArrayList[N+1];
            type = new char[N+1];
            cost = new int[N+1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                type[i] = st.nextToken().charAt(0);
                cost[i] = Integer.parseInt(st.nextToken());
                while (true) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 0) break;
                    graph[i].add(x);
                }
            }

            visited = new boolean[N+1];
            flag = false;

            dfs(1, 0);

            sb.append(flag ? "Yes\n" : "No\n");
        }

        System.out.print(sb);
    }
}
