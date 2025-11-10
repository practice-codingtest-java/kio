package kio.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_중앙값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = null;
            int cnt = 0; // number of medians (=(N+1)/2)
            result.append((N + 1) / 2).append("\n");

            for(int i = 0; i < N; i++){
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int cur = Integer.parseInt(st.nextToken());
                // 새 값 삽입: left의 최댓값보다 작거나 같으면 left에, 아니면 right에
                if (left.isEmpty() || cur <= left.peek()) {
                    left.offer(cur);
                } else {
                    right.offer(cur);
                }

                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                } else if (right.size() > left.size()) {
                    left.offer(right.poll());
                }

                if (i % 2 == 0) {
                    sb.append(left.peek()).append(" ");
                    cnt++;
                    if (cnt % 10 == 0) sb.append("\n");
                }
            }
            result.append(sb).append("\n");
        }
        System.out.println(result);
    }
}
