package kio.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b16401_과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        long left = 1;
        long right = 1;
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        long answer = 0;
        while(left <= right) {
            long mid = (left + right)/2;
            long cnt = 0;
            for(int i = 0; i < M; i++) {
                cnt += arr[i] / mid;
            }
            if(cnt >= N){
                answer = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
