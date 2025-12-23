package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b1700_멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 수
        int K = Integer.parseInt(st.nextToken()); // 사용 횟수

        int[] arr = new int[K];   // 사용 순서
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] plug = new int[N];  // 현재 꽂힌 플러그
        int size = 0;
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int cur = arr[i];
            boolean possible = false;

            // 이미 꽂혀 있는지 확인
            for (int j = 0; j < size; j++) {
                if (plug[j] == cur) {
                    possible = true;
                    break;
                }
            }

            if (possible) continue;

            // 빈 자리가 있으면 그냥 꽂기
            if (size < N) {
                plug[size++] = cur;
                continue;
            }

            // 빈 자리가 없으면 victim 선택
            int victim = -1;
            int latest = -1;

            for (int j = 0; j < N; j++) {
                int nextUse = Integer.MAX_VALUE;

                for (int k = i + 1; k < K; k++) {
                    if (arr[k] == plug[j]) {
                        nextUse = k;
                        break;
                    }
                }

                if (nextUse > latest) {
                    latest = nextUse;
                    victim = j;
                }
            }

            plug[victim] = cur;
            answer++;
        }

        System.out.println(answer);
    }
}
