package kio.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_b2565_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int[][] inp = new int[n][2];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            inp[i][0] = Integer.parseInt(input[0]);
            inp[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(inp, (a,b)->a[0]-b[0]);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(inp[j][1] < inp[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ans = 0;
        for(int i : dp) ans = Math.max(ans,i);
        System.out.println(n - ans);
    }
}
