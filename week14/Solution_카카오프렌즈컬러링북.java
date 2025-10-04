package kio.week14;

class Solution_카카오프렌즈컬러링북 {
    boolean[][] visited;
    int M,N;
    int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    int dfs(int x, int y, int[][] picture){
        int ans = 1;
        visited[x][y] = true;
        for(int d = 0; d < 4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || picture[nx][ny] != picture[x][y])
                continue;
            ans += dfs(nx,ny,picture);
        }
        return ans;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        M = m;
        N = n;
        int[] answer = new int[2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(dfs(i,j,picture), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}