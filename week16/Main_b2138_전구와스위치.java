package kio.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b2138_전구와스위치 {
    static int n;
    static char[] target;

    static int simulate(char[] bulbs, boolean pressFirst) {
        int cnt = 0;
        if (pressFirst) {
            press(bulbs, 0);
            cnt++;
        }

        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                press(bulbs, i);
                cnt++;
            }
        }

        // 끝까지 맞췄는지 확인
        for (int i = 0; i < n; i++) {
            if (bulbs[i] != target[i]) return -1;
        }

        return cnt;
    }

    static void press(char[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] current =  br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        int case1 = simulate(current.clone(), false); // 0번 안 누름
        int case2 = simulate(current.clone(), true);  // 0번 누름

        if (case1 == -1 && case2 == -1) System.out.println(-1);
        else if (case1 == -1) System.out.println(case2);
        else if (case2 == -1) System.out.println(case1);
        else System.out.println(Math.min(case1, case2));
    }
}
