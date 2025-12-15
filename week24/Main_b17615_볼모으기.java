package kio.week24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_b17615_볼모으기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        System.out.println(Math.min(
                Math.min(moveLeft(arr, 'R'), moveLeft(arr, 'B')),
                Math.min(moveRight(arr, 'R'), moveRight(arr, 'B'))
        ));
    }

    // 왼쪽으로 c색을 몰기
    private static int moveLeft(char[] arr, char c) {
        int n = arr.length;
        int i = 0;
        // 왼쪽부터 c가 연속되는 부분은 그대로 둔다
        while (i < n && arr[i] == c) i++;

        // 그 이후에 등장하는 c의 개수가 이동 횟수
        int cnt = 0;
        for (int j = i; j < n; j++) {
            if (arr[j] == c) cnt++;
        }
        return cnt;
    }

    // 오른쪽으로 c색을 몰기
    private static int moveRight(char[] arr, char c) {
        int n = arr.length;
        int i = n - 1;
        // 오른쪽부터 c가 연속되는 부분은 그대로 둔다
        while (i >= 0 && arr[i] == c) i--;

        // 그 이전에 등장하는 c의 개수가 이동 횟수
        int cnt = 0;
        for (int j = 0; j <= i; j++) {
            if (arr[j] == c) cnt++;
        }
        return cnt;
    }
}
