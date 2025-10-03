package kio.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b3184_양 {
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static int [] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    static int totalWolf, totalSheep;
    static void bfs(int row, int col) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int wolf = 0;
        int sheep = 0;
        if(map[row][col] == 'v') wolf = 1;
        else if(map[row][col] == 'o') sheep = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            for(int i = 0;i < 4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == '#') continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                if(map[nx][ny] == 'v') wolf++;
                else if(map[nx][ny] == 'o') sheep++;
            }
        }
        if(wolf < sheep){
            totalSheep +=  sheep;
        }
        else{
            totalWolf +=  wolf;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map =  new char[N][];
        visited = new boolean[N][M];
        for(int i =0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }
        totalSheep = 0;
        totalWolf = 0;
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                if(!visited[i][j] && map[i][j] != '#') {
                    bfs(i,j);
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }
}
