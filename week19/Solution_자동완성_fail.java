package kio.week19;

import java.util.*;

public class Solution_자동완성_fail {
    // 풀이 자체는 맞지만 메모리 초과 발생. trie 구조로 풀어야 효율적으로 메모리 활용 가능
    public int solution(String[] words) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            StringBuilder sub = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                sub.append(word.charAt(i));
                String subStr = sub.toString();
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }
        for(String word : words) {
            int prev = answer;
            StringBuilder sub = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                sub.append(word.charAt(i));
                String subStr = sub.toString();
                if(map.getOrDefault(subStr, 0) == 1) {
                    answer += (i+1);
                    break;
                }
            }
            if(prev == answer) answer += word.length();
        }
        return answer;
    }
}
