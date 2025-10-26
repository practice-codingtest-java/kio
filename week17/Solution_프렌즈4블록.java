package kio.week17;

import java.util.Arrays;

public class Solution_프렌즈4블록 {
    static int checkAndRemove(int m, int n, char[][] board){
        int removed = 0;
        boolean[][] changed = new boolean[m][n];
        for(int r = 0; r < m - 1; r++) {
            for(int c = 0; c < n - 1; c++) {
                char ch = board[r][c];
                if(ch != 0 && ch == board[r][c+1] && ch == board[r+1][c] && ch == board[r+1][c+1]) {
                    changed[r][c] = true;
                    changed[r+1][c] = true;
                    changed[r+1][c+1] = true;
                    changed[r][c+1] = true;
                }
            }
        }
        char[][] newBoard = new char[m][n];
        for(int c=0; c<n; c++){
            int idx = m-1; // 새 보드에서 채워나갈 위치
            for(int r=m-1; r>=0; r--){
                if(!changed[r][c]){
                    newBoard[idx--][c] = board[r][c];
                }

            }
            // 남은 칸은 빈칸 처리
            for(; idx>=0; idx--){
                newBoard[idx][c] = 0;
                removed++;
            }
        }
        for(int r=0; r<m; r++){
            System.arraycopy(newBoard[r], 0, board[r], 0, n);
        }
        return removed;
    }
    static public int solution(int m, int n, String[] board) {
        char[][] cBoard = new char[m][n];
        for(int i = 0; i < cBoard.length; i++){
            cBoard[i] = board[i].toCharArray();
        }
        int answer = 0;
        for(int removed = checkAndRemove(m, n, cBoard); removed > 0; removed = checkAndRemove(m, n, cBoard)) {
            answer += removed;
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4, 5, board));
        board = new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(6, 6, board));
    }
}
