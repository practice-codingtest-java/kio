package kio.week16;

public class Solution_금과은운반하기 {
    static public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = (long) 1e15; // 최대 시간 (안전한 상한)
        // Nlog(T)
        while(left <= right) {
            long mid = (left+right)/2;
            if(canTransport(a,b,g,s,w,t,mid)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    static boolean canTransport(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalCombined = 0;

        for (int i = 0; i < g.length; i++) {
            long round = time / (t[i] * 2);     // 왕복 횟수
            if (time % (t[i] * 2) >= t[i]) round++; // 마지막 편도 가능하면 추가

            long maxMove = round * w[i];

            totalGold += Math.min(g[i], maxMove);
            totalSilver += Math.min(s[i], maxMove);
            totalCombined += Math.min(g[i] + s[i], maxMove);
        }

        return totalGold >= a && totalSilver >= b && totalCombined >= a + b;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};
        System.out.println(solution(a, b, g, s, w, t));
        a = 90;
        b = 500;
        g = new int[]{70, 70, 0};
        s = new int[]{0, 0, 500};
        w = new int[]{100, 100, 2};
        t = new int[]{4,8,1};
        System.out.println(solution(a, b, g, s, w, t));
    }
}
