package kio.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main_b12852_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int i=n-1;i>=1;i--){
            if(i*2 <= n){
                dp[i] = Math.min(dp[i], dp[i*2]+1);
            }
            if(i*3 <= n){
                dp[i] = Math.min(dp[i], dp[i*3]+1);
            }
            dp[i] = Math.min(dp[i], dp[i+1]+1);
        }
        StringBuilder sb = new StringBuilder();

        sb.append(dp[1]).append("\n");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        for(int i=1;i<n;){
            if(i*2 <= n && dp[i*2] == dp[i]-1){
                i *=2;
            }
            else if(i*3<=n && dp[i*3] == dp[i]-1){
                i *= 3;
            }
            else{
                i++;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
