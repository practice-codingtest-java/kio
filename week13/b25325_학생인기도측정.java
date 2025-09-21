package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b25325_학생인기도측정 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            map.put(st.nextToken(),0);
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String cur = st.nextToken();
                map.put(cur,map.get(cur)+1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp == 0) return a.getKey().compareTo(b.getKey());
            return cmp;
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : list){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.print(sb);
    }
}
