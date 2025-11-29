package kio.week21;

import java.io.*;
import java.util.*;

public class Main_b13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] truck = new int[n];
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        int totalWeight = 0;
        int time = 0;
        int idx = 0;

        // 다리 위를 w 길이로 초기화
        for (int i = 0; i < w; i++) bridge.add(0);

        while (!bridge.isEmpty()) {
            time++;

            // 1) 다리 맨 앞 칸 빠짐
            totalWeight -= bridge.poll();

            // 2) 새 트럭 진입 시도
            if (idx < n) {
                if (totalWeight + truck[idx] <= L) {
                    // 가능하면 넣는다
                    bridge.add(truck[idx]);
                    totalWeight += truck[idx];
                    idx++;
                } else {
                    // 아니라면 0을 넣어 트럭 이동만
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
