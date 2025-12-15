package kio.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b2234_성곽 {
    static int N,M;
    // mask order: 1(west), 2(north), 4(east), 8(south)
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static List<Integer> rooms;
    static int max, num;
    static int[][] visited;

    static void bfs(int x, int y, int idx) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x,y});
        visited[x][y] = idx;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int mask = 1;
            for(int i=0;i<4;i++){
                if((mask & board[cur[0]][cur[1]]) == 0){
                    int nx = cur[0]+dx[i];
                    int ny = cur[1]+dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == 0){
                        visited[nx][ny] = idx;
                        q.offer(new int[] {nx,ny});
                        cnt++;
                    }
                }
                mask <<= 1;
            }
        }
        max = Math.max(max, cnt);
        rooms.add(cnt);
        num++;
    }

    static int removeMaxSize(){
        int maxAfterRemove = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int roomA = visited[i][j];     // 현재 칸의 방 번호
                int walls = board[i][j];       // 벽 정보

                int mask = 1;
                for (int d = 0; d < 4; d++) {
                    // 현재 방향에 벽이 있을 때만 제거 가능
                    if ((walls & mask) != 0) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        // 범위 체크
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            int roomB = visited[nx][ny];

                            // 같은 방이면 제거해도 합쳐질 방이 없다
                            if (roomA != roomB) {
                                int sizeA = rooms.get(roomA - 1);
                                int sizeB = rooms.get(roomB - 1);

                                maxAfterRemove = Math.max(maxAfterRemove, sizeA + sizeB);
                            }
                        }
                    }
                    mask <<= 1;
                }
            }
        }
        return maxAfterRemove;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        max = 0;
        num = 0;
        board = new int[N][M];
        visited = new int[N][M];
        rooms = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j] != 0) continue;
                bfs(i,j,idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("\n");
        sb.append(max).append("\n");
        sb.append(removeMaxSize()).append("\n");
        System.out.print(sb);
    }
}
