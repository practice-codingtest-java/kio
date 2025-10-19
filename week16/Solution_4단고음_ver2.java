package kio.week16;


public class Solution_4단고음_ver2 {
    static int answer;
    static void dfs(int n,int m, int p){
        if(n == 1 && m == 0 && p == 0) {
            answer++;
            return;
        }
        //p가 m*2보다 크면 불가능
        if (p > m*2) return;
        if (n <= 1 || m < 0 || p < 0) return;
        
        if(n % 3 == 0) {
            dfs(n / 3, m - 1, p);
            dfs(n - 3, m, p - 3);
        } else {
            dfs(n - n % 3, m, p - n % 3);
        }
    }
    static public int solution(int n) {
        answer = 0;
        int m = (int) (Math.log(n) / Math.log(3));
        System.out.println(m);
        // 마지막 2개는 무조건 +이므로
        dfs(n-2,m,m*2-2);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(41));
        System.out.println(solution(2147483647));
    }
}
