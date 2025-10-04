package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b1515_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int ans = 0;
        int idx = 0;

        while (idx < input.length) {
            ans++;
            char[] now = Integer.toString(ans).toCharArray();
            for (char c : now) {
                if (idx < input.length && input[idx] == c) {
                    idx++;
                }
            }
        }

        System.out.println(ans);
    }
}
