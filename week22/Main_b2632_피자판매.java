package kio.week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b2632_피자판매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] pizzaA = new int[N*2];
        int[] pizzaB = new int[M*2];
        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < N; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
            pizzaA[i+N] = pizzaA[i];
            totalA += pizzaA[i];
        }
        for (int i = 0; i < M; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
            pizzaB[i+M] = pizzaB[i];
            totalB += pizzaB[i];
        }
        long[] cntA = new long[size+1];
        cntA[0] = 1;
        for(int left = 0; left < N; left++) {
            int acc = 0;
            for(int right = left; right < left+N-1; right++) {
                acc += pizzaA[right];
                if(acc > size){
                    break;
                }
                cntA[acc]++;
            }
        }
        if(totalA <= size) cntA[totalA]++;
        long[] cntB = new long[size+1];
        cntB[0] = 1;
        for(int left = 0; left < M; left++) {
            int acc = 0;
            for(int right = left; right < left+M-1; right++) {
                acc += pizzaB[right];
                if(acc > size){
                    break;
                }
                cntB[acc]++;
            }
        }
        if(totalB <= size) cntB[totalB]++;
        long ans = 0;
        for(int i=0;i<size+1;i++){
            ans += cntA[i]*cntB[size-i];
        }
        System.out.println(ans);
    }
}
