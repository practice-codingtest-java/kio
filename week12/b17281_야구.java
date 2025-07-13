package week12;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b17281_야구 {
    static int max;
    static int n;
    static int[][] map;
    static boolean[] visited;
    static void perm(int[] order, int idx){
        if(idx == 9){
            simulate(order);
            return;
        }
        if(idx == 3){
            perm(order, 4);
        }
        else{
            for(int i=1;i<9;i++){
                if(visited[i]) continue;
                visited[i] = true;
                order[idx] = i;
                perm(order, idx+1);
                visited[i] = false;
            }
        }

    }
    static void simulate(int[] order){
        int inning = 0;
        int point = 0;
        int batterIdx = 0;

        while (inning < n) {
            int out = 0;
            int runner = 0;
            while(out < 3){
                int player = order[batterIdx % 9];
                int hit = map[inning][player];
                // 안타 처리
                if (hit == 4) { // 홈런
                    point++; // 타자 점수
                    point += Integer.bitCount(runner); // 루상 주자 모두 득점
                    runner = 0;
                }
                else if(hit == 0){
                    out++;
                }
                else {
                    runner <<= hit; // 모든 주자 hit 만큼 진루
                    runner |= (1 << (hit - 1)); // 타자 진루

                    // 득점 체크: 4루(비트 3 이상) 도달한 주자 처리
                    point += Integer.bitCount(runner >> 3); // 비트 3(8) 이상인 주자 점수
                    runner &= 0b111; // 3비트까지만 유지 (1루, 2루, 3루)
                }
                batterIdx++;
            }
            inning++;
        }
        max = Math.max(max, point);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][9];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        visited = new boolean[9];
        visited[0] = true;
        int[] order = new int[9];
        order[3] = 0;
        perm(order,0);
        System.out.print(max);
    }
}
