package kio.week18;

public class Solution_징검다리건너기 {
    static public int solution(int[] stones, int k) {
        int answer = 0;
        int right = 0;
        for(int stone : stones) right = Math.max(right, stone);
        int left = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int jump = 0;
            int cnt = 0;
            for (int stone : stones) {
                if (stone < mid) {
                    cnt++;
                } else {
                    jump = Math.max(jump, cnt);
                    cnt = 0;
                }
            }
            jump = Math.max(jump, cnt);
            if(jump >= k){
                right = mid - 1;
            }
            else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] stones = new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }
}
