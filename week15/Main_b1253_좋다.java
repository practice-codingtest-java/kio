package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        int[] seq =  new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = n-1;
            while(left < right) {
                if(left == i){
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }
                int sum = seq[left] + seq[right];
                if(sum == seq[i]) {
                    ans++;
                    break;
                }
                else if(sum > seq[i]) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        System.out.println(ans);
    }
}
