package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1039_교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int m = Integer.parseInt(st.nextToken());
        // 최대 7자리 숫자 1<=n<=1,000,000
        Set<String> visited[] = new HashSet[m+1];
        for(int i=0;i<=m;i++){
            visited[i] = new HashSet<>();
        }
        int answer = -1;
        Deque<String[]> dq = new ArrayDeque<>();
        dq.offer(new String[]{n,"0"});
        while(!dq.isEmpty()){
            String[] cur = dq.poll();
            String num = cur[0];
            int depth = Integer.parseInt(cur[1]);
            if(depth == m) {
                answer = Math.max(answer, Integer.parseInt(num));
                continue;
            }
            int len = num.length();
            for(int i=0;i<len-1;i++){
                for(int j=i+1;j<len;j++){
                    char[] arr = num.toCharArray();
                    // swap
                    char tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
                    if(arr[0] == '0') continue;
                    String next = new String(arr);
                    if(visited[depth + 1].contains(next)) continue;
                    visited[depth + 1].add(next);
                    dq.offer(new String[]{next,String.valueOf(depth+1)});
                }
            }
        }
        System.out.println(answer);
    }
}
