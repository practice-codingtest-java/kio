package kio.week15;

public class Solution_택배배달과수거하기 {
    static public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int remainD = 0; // 남은 배달 상자
        int remainP = 0; // 남은 수거 상자

        for (int i = n - 1; i >= 0; i--) {
            // 누적 (아직 처리되지 않은 상자)
            remainD += deliveries[i];
            remainP += pickups[i];

            // 둘 중 하나라도 처리할 게 있으면, 왕복해야 함
            while (remainD > 0 || remainP > 0) {
                remainD -= cap;
                remainP -= cap;
                answer += (i + 1) * 2L; // 왕복 거리
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = new int[] {1,0,3,1,2};
        int[] pickups = new int[] {0,3,0,4,0};
        System.out.println(solution(cap, n, deliveries, pickups));
    }
}
