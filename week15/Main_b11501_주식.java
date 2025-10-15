package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int T0=0;T0<T;T0++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            boolean[] action = new boolean[N];
            for(int i=N-1;i>=0;i--) {
                if(arr[i]>max) {
                    max = arr[i];
                }
                else if(arr[i] < max){
                    action[i] = true;
                }
            }
            int stock = 0;
            long outcome = 0;
            long income = 0;
            for(int i=0;i<N;i++) {
                if(action[i]) {
                    stock++;
                    outcome += arr[i];
                }
                else{
                    income += ((long) arr[i] *stock);
                    stock = 0;
                }
            }
            System.out.println(income - outcome);
        }
    }
}
