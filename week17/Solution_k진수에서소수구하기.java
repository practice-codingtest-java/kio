package kio.week17;


public class Solution_k진수에서소수구하기 {
    static boolean isPrime(long num) {
        if (num < 2) return false;
        for(int i=2; i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
    static public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%k);
            n /= k;
        }
        sb.reverse();
        String[] tokens = sb.toString().split("0+");
        int answer = 0;
        for(String token : tokens){
            if(isPrime(Long.parseLong(token))) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674,3));
        System.out.println(solution(110011,10));
    }
}
