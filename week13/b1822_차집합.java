package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1822_차집합 {
    public static void main(String[] args) throws IOException {
        TreeSet<Integer> set = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int a = Integer.parseInt(st.nextToken());
            set.remove(a);
        }
        int size = set.size();
        System.out.println(size);
        if(size > 0){
            StringBuilder sb = new StringBuilder();
            for (int i : set) {
                sb.append(i).append(" ");
            }
            System.out.print(sb);
        }


    }
}
