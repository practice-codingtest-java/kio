package kio.week15;

import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_가장많이받은선물 {
    static public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n  = friends.length;
        int m = gifts.length;
        int[][] trade =  new int[n][n];
        HashMap<String, Integer> index = new HashMap<>();
        for(int i = 0; i < n; i++) {
            index.put(friends[i], i);
        }
        // trade[a][b] -> a가 b에게 준 개수
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int a = index.get(st.nextToken());
            int b = index.get(st.nextToken());
            trade[a][b]++;
        }
        //선물 지수 계산
        int[] giftScore = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                giftScore[i] -= trade[j][i]; //받은 선물
                giftScore[i] += trade[i][j]; //준 선물
            }
        }

        //다음달에 받을 선물
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(trade[i][j] > trade[j][i]){
                    result[i]++;
                }
                else if(trade[i][j] < trade[j][i]){
                    result[j]++;
                }
                else {
                    if( giftScore[i] > giftScore[j]) {
                        result[i]++;
                    }
                    else if( giftScore[i] < giftScore[j]) {
                        result[j]++;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));
    }
}
