package kio.week18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution_보석쇼핑 {
    static public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int total = set.size();

        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int answerLeft = 0, answerRight = 0;

        while(right < gems.length) {
            // 오른쪽 보석 추가
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            // 현재 구간에 모든 보석 포함되면 왼쪽 줄이기
            while(map.size() == total) {
                if(right - left < minLength) {
                    minLength = right - left;
                    answerLeft = left;
                    answerRight = right;
                }

                // 왼쪽 보석 제거
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            }

            right++;
        }

        // 1-based index로 반환
        return new int[]{answerLeft + 1, answerRight + 1};

    }
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }
}
