package kio.week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b10836_여왕벌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] acc =  new int[2*M-1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            int idx = 0;
            while (zero-- > 0) acc[idx++] += 0;
            while (one-- > 0) acc[idx++] += 1;
            while (two-- > 0) acc[idx++] += 2;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {

            // 첫 번째 열 (왼쪽 경계)
            int left = acc[M - 1 - i];
            sb.append(left + 1).append(" ");

            // 나머지 열 (위쪽에서 온 값)
            for (int j = 1; j < M; j++) {
                int top = acc[M - 1 + j];
                sb.append(top + 1).append(" ");
            }

            sb.append("\n");
        }


        System.out.print(sb);
    }
}
