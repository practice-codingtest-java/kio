package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_b20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int ans = 1;
        while(right < N) {
            int num = arr[right];
            cnt[num]++;

            // M 초과 시, 왼쪽 포인터 이동하며 조정
            while (cnt[num] > M) {
                int leftNum = arr[left];
                cnt[leftNum]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        System.out.println(ans);
    }
}
