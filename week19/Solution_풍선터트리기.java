package kio.week19;

import java.util.Arrays;

public class Solution_풍선터트리기 {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 양쪽 모두 자신보다 작은 값이 존재할 때만 터짐
            if (a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            count++;
        }
        return count;
    }
}
