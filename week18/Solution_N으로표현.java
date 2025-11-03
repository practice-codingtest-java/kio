package kio.week18;

import java.util.*;

public class Solution_N으로표현 {
    static public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            // N을 i번 연결
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            dp.get(i).add(num);

            // i = j + (i-j) 형태로 분할
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) {
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(y - x);
                        dp.get(i).add(x * y);
                        if (y != 0) dp.get(i).add(x / y);
                        if (x != 0) dp.get(i).add(y / x);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1; // 8번 이상 사용 불가
    }

    public static void main(String[] args) {
        System.out.println(solution(5,12));
        System.out.println(solution(2,11));
    }
}
