package kio.week17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b2170_선긋기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        ArrayList<int[]> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] line = new int[2];
            line[0] = Integer.parseInt(st.nextToken());
            line[1] = Integer.parseInt(st.nextToken());
            lines.add(line);
        }
        lines.sort((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] init = lines.getFirst();
        int start = init[0];
        int end = init[1];
        for(int i=1;i <n;i++) {
            int[] next = lines.get(i);
            int x = next[0];
            int y = next[1];
            if(x > end){
                sum += (end - start);
                start = x;
                end = y;
            }
            else if(y > end){
                end = y;
            }
        }
        sum += (end - start);
        System.out.println(sum);
    }
}
