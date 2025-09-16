package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left<right){
            if(arr[left] + arr[right] == target){
                ans++;
                left++;
            }
            else if(arr[left] + arr[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println(ans);
    }
}
