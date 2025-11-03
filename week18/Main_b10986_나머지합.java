package kio.week18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b10986_나머지합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] acc = new long[N+1];
        long[] count = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=N;i++){
            acc[i] = Long.parseLong(st.nextToken());
            acc[i] = (acc[i]+acc[i-1])%M;
            count[(int)acc[i]]++;
        }
        long ans = count[0];
        // 나머지가 같다면 (a-b)%M==0. nC2를 구하면 된다.
        for (int i = 0; i < M; i++) {
            ans += count[i] * (count[i] - 1) / 2;
        }
        System.out.println(ans);
    }
}
