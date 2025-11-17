package kio.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_b17780_새로운게임 {
    static ArrayList<Integer>[][] board;
    static int N,K;

    // 1 right 2 left 3 up 4 down
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] units;
    static int[][] map;
    static boolean move(int idx){
        int x = units[idx][0];
        int y = units[idx][1];
        int dir = units[idx][2];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 1. 먼저 이동하려는 칸이 범위 밖이거나 파란색이면 → 방향 반전
        if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
            // 방향 반전
            if (dir == 1) dir = 2;
            else if (dir == 2) dir = 1;
            else if (dir == 3) dir = 4;
            else if (dir == 4) dir = 3;
            units[idx][2] = dir;

            // 반전한 방향으로 재계산
            nx = x + dx[dir];
            ny = y + dy[dir];

            // 반전한 방향도 불가능하면 이동하지 않음
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2)
                return false;
        }

        // 2. 이동할 말들 추출 (idx부터 끝까지)
        int pos = board[x][y].indexOf(idx);
        if (pos == -1) return false;

        ArrayList<Integer> moving = new ArrayList<>();
        int size = board[x][y].size();
        for (int i = pos; i < size; i++) {
            moving.add(board[x][y].get(i));
        }
        // 기존 칸에서는 제거
        while (board[x][y].size() > pos) board[x][y].remove(pos);

        // 3. 도착 칸의 색에 따라 처리
        if (map[nx][ny] == 1) { // red → 반전
            java.util.Collections.reverse(moving);
        }

        // 4. 새로운 칸에 쌓기 + 좌표 업데이트
        for (int piece : moving) {
            board[nx][ny].add(piece);
            units[piece][0] = nx;
            units[piece][1] = ny;
        }

        // 5. 종료 조건
        return board[nx][ny].size() >= 4;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 0 white - 1 red - 2 blue
        map = new int[N][N];
        board = new ArrayList[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        units = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            units[i][0] = x;
            units[i][1] = y;
            units[i][2] = d;

            board[x][y].add(i);
        }
        for(int turn = 1; turn <= 1000; turn++) {
            for(int i = 0; i < K; i++) {
                // 가장 아래에 있는 말이 아니라면 움직일 수 없다.
                if (board[units[i][0]][units[i][1]].get(0) != i) continue;
                if (move(i)) {
                    System.out.println(turn);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
