package kio.week15;


public class Solution_두큐합같게만들기 {
    static public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] totalQ = new int[2*n];
        long sum = 0;
        long total = 0;
        for(int i = 0; i < n; i++){
            totalQ[i]=queue1[i];
            sum+=totalQ[i];
            totalQ[i+n]=queue2[i];
            total += queue1[i] + queue2[i];
        }
        System.out.println(sum + " " + total);
        if(total % 2 == 1) return -1;
        int start = 0;
        int end = n-1;
        int cnt = 0;
        int limit = n * 3; // 무한루프 방지
        long target = total/2;
        while (cnt <= limit) {
            if (sum == target) return cnt;
            else if (sum > target) {
                sum -= totalQ[start];
                start++;
            } else {
                end++;
                if (end >= 2 * n) break;
                sum += totalQ[end];
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] queue1 = {1,1};
        int[] queue2 = {1,5};
        System.out.println(solution(queue1,queue2));
    }
}
