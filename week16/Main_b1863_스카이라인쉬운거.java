package kio.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b1863_스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int top = -1;
        int answer = 0;
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            while(top != -1 && stack[top] > y){
                top--;
                answer++;
            }
            // 같은 높이는 중복 세지 않음
            if (top == -1 || stack[top] < y) {
                stack[++top] = y;
            }
        }
        while (top != -1) {
            if (stack[top--] != 0) answer++;
        }
        System.out.println(answer);
    }
}
