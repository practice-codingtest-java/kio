package week12;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b23288_주사위굴리기2 {
    static int[][] map;
    static int n,m;
    static int bfs(int target, int startX, int startY){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX,startY});
        visited[startX][startY] = true;
        int ret = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d =0;d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] != target){
                    continue;
                }
                visited[nx][ny] = true;
                ret++;
                q.offer(new int[]{nx,ny});
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //실행
        //이동 시 일어나는 일
        //위에 있던 수 -> 이동방향으로 ex) 동쪽으로 이동 시 다음 위치는 동쪽이 됨.
        //아래 있던 수 -> 이동방향 반대
        //이동 방향에 있던 수(동쪽으로 이동 시 동쪽) -> 아래로
        //이동 방향 반대에 있던 수(동쪽 이동시 서쪽) -> 위로
        //무관한 2개의 수(동서 이동 시 남북, 남북 이동시 동서) -> 그대로

        //0 동 (0,1) 1 남 (1,0) 2 서 (0,-1) 3 북 (-1,0)
        //시계방향 +1 반시계 방향 -1
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        //위 동 서 북 남 아래
        int[] dice = {1,3,4,2,5,6};
        int answer = 0;
        int curX = 0;
        int curY = 0;
        int dir = 0;
        for(int i=0;i<k;i++){
            int nextX = curX + dx[dir];
            int nextY = curY + dy[dir];
            // 범위 벗어나면 방향 반대로 바꾸고 다시 이동
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                dir = (dir + 2) % 4;
                nextX = curX + dx[dir];
                nextY = curY + dy[dir];
            }
            //이동
            curX = nextX;
            curY = nextY;
            //주사위 굴리기
            int tmp;
            switch(dir){
                case 0: // 동
                    tmp = dice[0];
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = tmp;
                    break;
                case 1: // 남
                    tmp = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = tmp;
                    break;
                case 2: // 서
                    tmp = dice[0];
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = tmp;
                    break;
                case 3: // 북
                    tmp = dice[0];
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = tmp;
                    break;
            }

            //점수 계산
            int a = dice[5];
            int b = map[curX][curY];
            int c = bfs(b,curX,curY);
            if(a > b){
                dir = (dir + 1) % 4;
            }
            else if(a < b){
                dir = (dir + 3) % 4;
            }
            answer += b*c;
        }
        System.out.println(answer);

    }
}
