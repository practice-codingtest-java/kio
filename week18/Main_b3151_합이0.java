package kio.week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b3151_합이0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        int cnt = right - left + 1;
                        answer += (long) cnt * (cnt - 1) / 2;
                        break;
                    } else {
                        int leftVal = arr[left];
                        int rightVal = arr[right];
                        int leftCount = 0, rightCount = 0;
                        while (left < right && arr[left] == leftVal) {
                            left++;
                            leftCount++;
                        }
                        while (right >= left && arr[right] == rightVal) {
                            right--;
                            rightCount++;
                        }
                        answer += (long) leftCount * rightCount;
                    }
                } else if (sum < 0) left++;
                else right--;
            }
        }
        System.out.println(answer);
    }
}
