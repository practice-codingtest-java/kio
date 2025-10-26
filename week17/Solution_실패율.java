package kio.week17;

import java.util.Arrays;

public class Solution_실패율 {
    private static class Node implements Comparable<Node> {
        double rate;
        int index;
        public Node(double rate, int index) {
            this.rate = rate;
            this.index = index;
        }
        @Override
        public int compareTo(Node o) {
            int cmp = Double.compare(o.rate, this.rate); // 실패율 내림차순
            if (cmp == 0) return Integer.compare(this.index, o.index); // 번호 오름차순
            return cmp;
        }
    }
    static public int[] solution(int N, int[] stages) {
        // 현재 머물고 있는 스테이지 = 클리어하지 못한 사람
        int[] current = new int[N+2];
        for(int stage : stages) {
            current[stage]++;
        }
        // 해당 스테이지에 도달한 사람
        int[] clears = Arrays.copyOf(current, current.length);
        for(int i = N+1; i > 0; i--) {
            clears[i-1] += clears[i];
        }
        // 실패율, 스테이지 순서
        Node[] sorted = new Node[N];
        for(int i = 0;i<N;i++){
            double rate = clears[i + 1] == 0 ? 0 : (double) current[i + 1] / clears[i + 1];
            int index = i+1;
            sorted[i] = new Node(rate,index);
        }
        Arrays.sort(sorted);

        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = sorted[i].index;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
