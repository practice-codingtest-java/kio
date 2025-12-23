package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b10159_저울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // heavy[i][j] = i가 j보다 무겁다
        boolean[][] heavy = new boolean[N][N];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            heavy[x][y] = true;
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                if(!heavy[i][k]) continue;
                for(int j = 0; j < N; j++){
                    if(heavy[k][j]) {
                        heavy[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(!heavy[i][j] && !heavy[j][i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
