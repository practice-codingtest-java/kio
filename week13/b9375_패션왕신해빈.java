package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=0 ; tc<T; tc++) {
            int n =  Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(!map.containsKey(type))  map.put(type,1);
                else map.put(type,map.get(type)+1);
            }
            int ans = 1;
            for(int i : map.values()){
                ans *= (i+1);
            }
            ans--;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
