package kio.week17;

public class Solution_n진수게임 {
    static public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(t*m > sb.length()){
            sb.append(Integer.toString(i++,n));
        }
        StringBuilder res = new StringBuilder();
        for(int j=0;j<t;j++){
            res.append(sb.charAt(j*m+p-1));
        }
        return res.toString().toUpperCase();
    }
    public static void main(String[] args) {
        System.out.println(solution(2,4,2,1));
        System.out.println(solution(16,16,2,1));
    }
}
