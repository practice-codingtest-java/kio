package kio.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_b12886_돌그룹 {
    static int A,B,C;
    static boolean bfs(int a, int b, int c) {

        // 세 그룹의 합이 3으로 안 나눠지면 false
        if((a + b + c) % 3 != 0) return false;

        Deque<int[]> q = new ArrayDeque<>();
        // 3차원이 아닌 2차원으로 한 이유는 총 돌의 갯수는 변하지 않기 때문에 2개의 그룹만 알아도 남은 1개의 그룹을 알 수 있기 때문이다.
        boolean[][] isChecked = new boolean[1501][1501];

        q.add(new int[]{a, b, c});
        isChecked[a][b] = true;

        while(!q.isEmpty()) {
            int[] s = q.poll();

            a = s[0];
            b = s[1];
            c = s[2];

            // 세 개가 모두 같아지면 true 반환
            if(a == b && b == c) {
                return true;
            }

            // 갯수가 다른 두 개 골라서 연산
            if(a != b) {
                int na = a > b ? a-b : a+a;
                int nb = a > b ? b+b : b-a;

                if(!isChecked[na][nb]) {
                    q.add(new int[]{na, nb, c});
                    isChecked[na][nb] = true;
                }
            }

            if(b != c) {
                int nb = b > c ? b-c : b+b;
                int nc = b > c ? c+c : c-b;

                if(!isChecked[nb][nc]) {
                    q.add(new int[]{a, nb, nc});
                    isChecked[nb][nc] = true;
                }
            }

            if(a != c) {
                int na = a > c ? a-c : a+a;
                int nc = a > c ? c+c : c-a;

                if(!isChecked[na][nc]) {
                    q.add(new int[]{na, b, nc});
                    isChecked[na][nc] = true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // true: 1 출력, false: 0 출력
        System.out.println(bfs(A, B, C) ? 1 : 0);
    }
}
