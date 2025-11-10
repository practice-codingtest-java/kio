package kio.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];
        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        long l = 1;
        long r = 0;
        for (int len : lan) {
            r = Math.max(r, len);
        }
        long answer = 0;
        while(l <= r) {
            long mid = (l+r)/2;
            long cnt = 0;
            for(int i = 0; i < K; i++) {
                cnt += lan[i]/mid;
            }
            if(cnt >= N){
                l = mid+1;
                answer = mid;
            }
            else{
                r = mid-1;
            }
        }
        System.out.println(answer);
    }
}
