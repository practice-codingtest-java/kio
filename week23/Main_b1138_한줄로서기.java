package kio.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_b1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> line = new ArrayList<>();
        for(int i=N-1;i>=0;i--){
            line.add(arr[i], i+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : line){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
