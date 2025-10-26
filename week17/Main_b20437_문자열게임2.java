package kio.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_b20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int T0=0;T0<T;T0++) {
            String target = br.readLine();
            int k = Integer.parseInt(br.readLine());
            List<Integer>[] list = new ArrayList[26];
            for(int i=0;i<26;i++) list[i] = new ArrayList<>();
            for(int i=0;i<target.length();i++){
                list[target.charAt(i)-'a'].add(i);
            }
            int a = Integer.MAX_VALUE;
            int b = -1;
            for(List<Integer> current : list){
                if(current.size() < k) continue;
                for(int j=0;j <= current.size() - k; j++){
                    int last = j + k - 1;
                    int len = current.get(last) - current.get(j) + 1;
                    a = Math.min(a, len);
                    b = Math.max(b, len);
                }
            }
            if(a == Integer.MAX_VALUE || b == -1) sb.append("-1").append("\n");
            else sb.append(a).append(" ").append(b).append("\n");
        }
        System.out.println(sb);
    }
}
