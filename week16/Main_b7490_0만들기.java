package kio.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_b7490_0만들기 {
    static int n;
    static StringBuilder answer;
    static List<String> subAnswer;
    static void dfs(int idx, StringBuilder sb) {
        if(idx == n+1){
            String expr = sb.toString().replace(" ", "");
            int sum = 0;
            int i = 0;
            char op = '.';
            int len = expr.length();
            while(i < len){
                int j = i;
                while (j < len && Character.isDigit(expr.charAt(j))) j++;
                int a = Integer.parseInt(expr.substring(i, j));
                if (op == '.' || op == '+') sum += a;
                else if (op == '-') sum -= a;
                if (j < len) op = expr.charAt(j);
                i = j+1;
            }
            if(sum == 0){
                subAnswer.add(sb.toString());
            }
            return;
        }
        // + 연산자 추가
        dfs(idx+1, new StringBuilder(sb).append('+').append(idx));

        // - 연산자 추가
        dfs(idx+1, new StringBuilder(sb).append('-').append(idx));

        // 공백(숫자 이어붙이기)
        dfs(idx+1, new StringBuilder(sb).append(' ').append(idx));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        answer = new StringBuilder();
        for(int i = 0; i < t; i++) {
            subAnswer = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            dfs(2, new StringBuilder().append(1));
            Collections.sort(subAnswer);
            for(String s : subAnswer) {
                answer.append(s).append('\n');
            }
            answer.append('\n');
        }
        System.out.println(answer);
    }
}
