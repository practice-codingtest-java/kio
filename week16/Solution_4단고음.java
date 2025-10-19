package kio.week16;


public class Solution_4단고음 {
    static int answer;
    static void dfs(int n,int plusCnt){
        // 3보다 작은 경우 더 진행 불가. 이미 사용한 +가 앞으로 나올 수 있는 *보다 많다면 불가능
        if(n < 3 || Math.pow(3, Math.ceil((double) plusCnt /2)) > n) return;
        if(n == 3){
            // *한개와 +2개가 남았다면 성곹
            if(plusCnt == 2) answer++;
            return;
        }
        // *를 쓴 경우 + 2개 소모
        if(n%3 == 0 && plusCnt >= 2) dfs(n/3, plusCnt - 2);
        // +를 쓴 경우 + 1개 추가
        dfs(n-1,plusCnt+1);
    }
    static public int solution(int n) {
        answer = 0;
        // 마지막 2개는 무조건 +이므로
        dfs(n-2,2);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(41));
        System.out.println(solution(2147483647));
    }
}
