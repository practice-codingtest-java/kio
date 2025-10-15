package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b9017_크로스컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int T0=0;T0<T;T0++){
            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            HashMap<Integer, Integer> teamCount = new HashMap<>();
            for(int team : input){
                teamCount.put(team, teamCount.getOrDefault(team, 0)+1);
            }
            // 2. 6명 미만 팀 제거 & 남은 선수들의 순서대로 새 rank 저장
            int rank = 1;
            HashMap<Integer, ArrayList<Integer>> teams = new HashMap<>();
            for(int team : input){
                if(teamCount.get(team) < 6) continue; // 실격팀
                teams.putIfAbsent(team, new ArrayList<>());
                teams.get(team).add(rank++);
            }
            // 점수 계산
            int bestTeam = -1;
            int bestScore = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;

            for(var entry : teams.entrySet()){
                ArrayList<Integer> ranks = entry.getValue();
                int total = ranks.get(0) + ranks.get(1) + ranks.get(2) + ranks.get(3);
                int fifth = ranks.get(4);

                if(total < bestScore || (total == bestScore && fifth < fifthScore)){
                    bestTeam = entry.getKey();
                    bestScore = total;
                    fifthScore = fifth;
                }
            }
            sb.append(bestTeam).append("\n");
        }
        System.out.print(sb);
    }
}
