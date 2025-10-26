package kio.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// LIS 문제. 최장 부분 수열에 포함 되지 않는 어린이의 위치만 바꾸면 된다.
public class Main_b2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        for(int r=0; r<N; r++){
            line[r] = Integer.parseInt(br.readLine());
        }
        // 일반적인 dp 방식 N^2
//        int[] dp = new int[N];
//        int ans = 0;
//        for(int i=0; i<N; i++){
//            dp[i] = 1;
//            for(int j=0; j<i; j++){
//                if(line[j] < line[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
//            }
//            ans = Math.max(ans, dp[i]);
//        }
//        System.out.println(N - ans);
        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : line) {
            // num이 들어갈 위치를 이분탐색으로 찾음
            int pos = Collections.binarySearch(lis, num);

            if (pos < 0) pos = -(pos + 1); // 삽입 위치 변환

            if (pos == lis.size()) lis.add(num); // 뒤에 추가
            else lis.set(pos, num); // 기존 값 대체
        }

        System.out.println(N - lis.size());
    }
}
