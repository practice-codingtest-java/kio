package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        int ans = 0;
        int stack = 0;
        for(int i=0;i<n;i++){
            if(input.charAt(i)=='('){
                if(i+1 < n && input.charAt(i+1)==')'){
                    ans += stack;
                    i++;
                }
                else{
                    stack++;
                }
            }
            else if(input.charAt(i)==')'){
                stack--;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
