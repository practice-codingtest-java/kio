package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1268_임시반장정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] cnt = new int[n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) continue;
                for(int k=0;k<5;k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt[i]++;
                        break;
                    }
                }
            }
        }
        int max = -1;
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(cnt[i]>max) {
                max = cnt[i];
                ans = i+1;
            }
        }
        System.out.println(ans);
    }
}
