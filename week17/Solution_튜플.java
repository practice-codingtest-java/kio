package kio.week17;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_튜플 {
    static public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] tokens = s.split("},\\{");
        HashMap<String, Integer> map = new HashMap<>();
        for (String token : tokens) {
            String[] nums = token.split(",");
            for (String num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int size = map.size();
        int[] answer = new int[size];
        for(var a : map.entrySet()) {
            // 원소의 위치는 size - 나타난 횟수
            answer[size - a.getValue()] = Integer.parseInt(a.getKey());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }
}
