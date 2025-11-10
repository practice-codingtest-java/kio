package kio.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b22251_빌런호석 {
    static int[] led = {
            0b1111011,//0
            0b0010010,//1
            0b0111101,//2
            0b0110111,//3
            0b1010110,//4
            0b1100111,//5
            0b1101111,//6
            0b0110010,//7
            0b1111111,//8
            0b1110111 //9
    };
    static int N,K,P,X;
    static int answer;
    static void dfs(int depth, int n, int used, int res) {
        if(used > P) return;
        if(depth == K){
            if(res != 0 && res != X && res <= N){
                answer++;
            }
            return;
        }
        int cur = n%10;
        int next = n/10;
        for(int i = 0; i<led.length; i++){
            int diff = Integer.bitCount(led[cur]^led[i]);
            dfs(depth+1, next, used+ diff, res + (int)Math.pow(10, depth) * i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dfs(0,X,0,0);
        System.out.println(answer);
    }
}
