package kio.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b12919_A와B2_reverse {
    static String T, S;
    static boolean dfs(StringBuilder sb){
        if(sb.length() == S.length()) {
            return sb.toString().equals(S);
        }
        boolean res = false;
        StringBuilder next;
        if(sb.charAt(0) == 'B'){
            next = new StringBuilder(sb);
            next.reverse();
            next.deleteCharAt(next.length()-1);
            res |= dfs(next);
        }
        if(sb.charAt(sb.length()-1) == 'A'){
            next = new StringBuilder(sb);
            next.deleteCharAt(next.length()-1);
            res |= dfs(next);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        System.out.println(dfs(new StringBuilder(T))?1:0);
    }
}
