package kio.week14;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int value = now[0], steps = now[1];

            if (value == y) return steps;

            int[] nexts = {value + n, value * 2, value * 3};
            for (int next : nexts) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, steps + 1});
                }
            }
        }
        return -1;
    }
}
