package kio.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b22866_탑보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] towers = new int[n];
        for(int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        int[] answers = new int[n];
        int[] nearest = new int[n];
        Arrays.fill(nearest, Integer.MAX_VALUE);
        // 0: 높이 1: idx
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        // 왼쪽 한번에 탐색
        for(int i = 0; i < n; i++) {
            // 현재 높이보다 작은건 모두 꺼내기. -> 0번부터 내림차순으로 남게됨.
            while (!stack.isEmpty() && stack.peek()[0] <= towers[i])
                stack.pop();
            if (!stack.isEmpty()) {
                answers[i] += stack.size();
                int leftIdx = stack.peek()[1];
                if ( nearest[i] == Integer.MAX_VALUE || Math.abs((i+1) - leftIdx) < Math.abs((i+1) - (nearest[i])))
                    nearest[i] = leftIdx;
            }
            stack.push(new int[] {towers[i],i+1});
        }
        stack.clear();
        //오른쪽도 누적해서 탐색
        for(int i=n-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= towers[i])
                stack.pop();
            if (!stack.isEmpty()) {
                answers[i] += stack.size();
                int rightIdx = stack.peek()[1];
                if (nearest[i] == Integer.MAX_VALUE || Math.abs((i+1) - rightIdx) < Math.abs((i+1) - (nearest[i])))
                    nearest[i] = rightIdx;
            }

            stack.push(new int[] {towers[i],i+1});
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(answers[i]).append(" ");
            if(answers[i] == 0) sb.append("\n");
            else sb.append(nearest[i]).append("\n");
        }
        System.out.println(sb);
    }
}
