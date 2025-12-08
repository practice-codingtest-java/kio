package kio.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b8980_택배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[][] packages = new int[M][3];
        int[] remain = new int[N+1];
        Arrays.fill(remain, limit);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                packages[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(packages, (a,b)->{
            if(a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });
        int answer = 0;
        for(int i=0;i<M;i++){
            int s = packages[i][0];
            int e = packages[i][1];
            int w = packages[i][2];

            // ✔ 구간 s ~ e-1 최소 용량 찾기
            int minCap = Integer.MAX_VALUE;
            for (int j = s; j < e; j++) {
                minCap = Math.min(minCap, remain[j]);
            }

            int use = Math.min(w, minCap);  // 싣을 수 있는 만큼만

            // ✔ 구간 s~e-1에 실제 용량 차감
            for (int j = s; j < e; j++) {
                remain[j] -= use;
            }

            answer += use;
        }
        System.out.println(answer);
    }
}
