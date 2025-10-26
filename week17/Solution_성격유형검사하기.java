package kio.week17;

import java.util.HashMap;
import java.util.Map;

public class Solution_성격유형검사하기 {
    static public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
        int n = survey.length;

        // 각 질문마다 점수 반영
        for (int i = 0; i < n; i++) {
            char first = survey[i].charAt(0);  // 비동의 쪽
            char second = survey[i].charAt(1); // 동의 쪽
            int choice = choices[i];

            // 4는 중립 → 4보다 작으면 비동의 쪽, 크면 동의 쪽
            if (choice < 4) {
                score.put(first, score.get(first) + (4 - choice));
            } else if (choice > 4) {
                score.put(second, score.get(second) + (choice - 4));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(score.get('R') >= score.get('T') ? 'R' : 'T');
        result.append(score.get('C') >= score.get('F') ? 'C' : 'F');
        result.append(score.get('J') >= score.get('M') ? 'J' : 'M');
        result.append(score.get('A') >= score.get('N') ? 'A' : 'N');
        return result.toString();
    }
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }
}
