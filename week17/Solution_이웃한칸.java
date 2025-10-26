package kio.week17;

public class Solution_이웃한칸 {
    static public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
        for(int d = 0; d < 4; d++) {
            int nx = h + dx[d];
            int ny = w + dy[d];
            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
            if(board[nx][ny].equals(board[h][w])) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] board ={{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        System.out.println(solution(board, 1, 1));
    }
}
