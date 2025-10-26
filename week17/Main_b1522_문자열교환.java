package kio.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b1522_문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int aCnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='a') aCnt++;
        }
        int answer = 0;
        int range = s.length() + aCnt;
        s += s;
        for(int i=0; i<aCnt; i++) {
            if(s.charAt(i)=='b') answer++;
        }
        int current = answer;
        for(int i=aCnt; i<range; i++) {
            if(s.charAt(i-aCnt)=='b') current--;
            if(s.charAt(i)=='b') current++;
            answer = Math.min(answer, current);
        }
        System.out.println(answer);
    }
}
