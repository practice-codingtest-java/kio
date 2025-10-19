package kio.week16;

import java.util.*;

public class Solution_네트워크 {
    static void bfs(int i, boolean[] visited, List<Integer>[] graph){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    static public int solution(int n, int[][] computers) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i<n;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(computers[i][j]==1){
                    graph[i].add(j);
                }
            }
        }
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(i, visited, graph);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] comp = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, comp));
    }
}
