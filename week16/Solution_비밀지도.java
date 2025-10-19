package kio.week16;

import java.util.Arrays;

public class Solution_비밀지도 {
    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            int row = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();

            for(int j = n - 1; j >= 0; j--) { // 왼쪽 비트부터 처리
                if((row & (1 << j)) != 0) sb.append('#');
                else sb.append(' ');
            }

            answer[i] = sb.toString();
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(5, arr1, arr2)));
    }
}
