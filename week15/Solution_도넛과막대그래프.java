package kio.week15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution_도넛과막대그래프 {
    static public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        //out in
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int[] e : edges) {
            int[] from = map.getOrDefault(e[0], new int[2]);
            from[0]++;
            map.put(e[0], from);

            int[] to = map.getOrDefault(e[1], new int[2]);
            to[1]++;
            map.put(e[1], to);
        }
        for (var entry : map.entrySet()) {
            int node = entry.getKey();
            int out = entry.getValue()[0];
            int in = entry.getValue()[1];
            if (out >= 2 && in == 0) answer[0] = node; // 생성 정점
            else if (out == 0 && in >= 1) answer[2]++; // 막대 그래프 끝
            // out degree가 root로 인해 +1이 될 가능성 존재. >= 2 로 씀
            else if (out == 2 && in >= 2) answer[3]++; // 8자 그래프
        }
        answer[1] = map.get(answer[0])[0] - answer[2] - answer[3]; // 도넛 그래프 개수
        return answer;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {2,3},{4,3},{1,1},{2,1}
        };
        System.out.println(Arrays.toString(solution(edges)));
        int[][] edges2 = {
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
                {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
                {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        };
        System.out.println(Arrays.toString(solution(edges2))); // [4,0,1,2]
    }
}