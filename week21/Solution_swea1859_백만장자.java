package kio.week21;

import java.util.Scanner;

public class Solution_swea1859_백만장자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            int[] price = new int[N];
            for (int i = 0; i < N; i++) price[i] = sc.nextInt();

            long profit = 0;
            int maxPrice = price[N - 1]; // 마지막 날부터 시작
            for (int i = N - 2; i >= 0; i--) {
                if (price[i] < maxPrice) {
                    profit += maxPrice - price[i]; // 매수 후 매도
                } else {
                    maxPrice = price[i]; // 최고값 갱신
                }
            }

            System.out.println("#" + test + " " + profit);
        }
    }
}
