package kio.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b10655_마라톤1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int[] dist = new int[n-1];
        int total = 0;
        for(int i = 0; i < n-1; i++) {
            dist[i] = Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]);
            total += dist[i];
        }
        int skip = 0;
        for(int i = 1; i < n-1; i++) {
            int d = Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]);
            int origin = dist[i-1] + dist[i];
            skip = Math.max(skip, origin - d);
        }
        System.out.println(total - skip);
    }
}
