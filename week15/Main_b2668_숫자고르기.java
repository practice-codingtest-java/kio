package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_b2668_숫자고르기 {
    static int N;
    static int[] arr;

    static ArrayList<Integer> checkCycle(int start) {
        boolean[] visited = new boolean[N+1];
        int cur = start;
        ArrayList<Integer> res = new ArrayList<>();
        while (true) {
            if (cur > N) return null;  // 잘못된 인덱스
            if (visited[cur]) break;   // 순환 시작
            visited[cur] = true;
            res.add(cur);
            cur = arr[cur];
        }
        // 순환이 start를 포함하는 경우만 반환
        if (cur == start) return res;
        return null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        boolean[] used = new boolean[N+1];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> cycle = checkCycle(i);
            if (cycle != null) {
                for (int x : cycle) used[x] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) answer.add(i);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int x : answer) {
            sb.append(x).append("\n");
        }
        System.out.print(sb);
    }
}
