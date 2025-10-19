package kio.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 순방향 풀이 -> 시간초과
public class Main_b12919_A와B2 {
    static String T;
    static boolean dfs(StringBuilder sb, int a, int b){
        if(a == 0 && b == 0){
            if(sb.toString().equals(T))  return true;
            else return false;
        }
        boolean res = false;
        StringBuilder copy;
        if(a > 0){
            copy = new StringBuilder(sb);
            copy.append('A');
            res |= dfs(copy, a - 1, b);
        }
        if(b > 0){
            copy = new StringBuilder(sb);
            copy.append('B');
            copy.reverse();
            res |= dfs(copy, a, b-1);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        T = br.readLine();
        StringBuilder sb =  new StringBuilder(s);
        int a = 0;
        int b = 0;
        for(char c: T.toCharArray()) {
            if(c == 'A') a++;
            else b++;
        }
        for(char c: s.toCharArray()) {
            if(c == 'B') b--;
            else a--;
        }
        if(dfs(sb, a, b)){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}
