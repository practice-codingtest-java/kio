package kio.week18;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_아이템줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[51][51];
        for(int[] r : rectangle){
            //1,1,7,4
            for(int i = r[0]; i <= r[2] ; i++){
                for(int j = r[1]; j <= r[3] ; j++){
                    if(i == r[0] || i == r[2] || j == r[1] || j == r[3]){
                        map[i][j] = 1;
                    }
                    else{
                        map[i][j] = 0;
                    }
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{characterX, characterY, 0});
        boolean[][] visited = new boolean[51][51];
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == itemX && cur[1] == itemY) return cur[2];
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx > 50 || ny < 0 || ny > 50 || visited[nx][ny] || map[nx][ny] != 1) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, cur[2]+1});
            }
        }
        return -1;
    }
}
