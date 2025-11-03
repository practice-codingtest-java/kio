package kio.week18;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_서버증설횟수 {
    static public int solution(int[] players, int m, int k) {
        int answer = 0;
        int usingServer = 1;
        Queue<int[]> server = new ArrayDeque<>();
        for(int i=0;i<players.length;i++){
            if(!server.isEmpty() && i - server.peek()[0] >= k){
                int[] removed = server.poll();
                usingServer -= removed[1];
            }
            int player = players[i];
            int capacity = usingServer*m;
            if(player >= capacity){
                int extra = (player-capacity) / m + 1;
                answer +=  extra;
                server.offer(new int[]{i,extra});
                usingServer +=  extra;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        System.out.println(solution(players,3,5));
        players = new int[] {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
        System.out.println(solution(players,5,1));
    }
}
