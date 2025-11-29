package kio.week21;

import java.util.*;

public class Hanhaw_block_review {
    public static int countBlockSubstrings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // 1. 블록 단위 길이 저장
        List<Integer> blocks = new ArrayList<>();
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) len++;
            else {
                blocks.add(len);
                len = 1;
            }
        }
        blocks.add(len);

        int answer = 0;
        int size = blocks.size();

        // 2. 투 포인터를 사용하여 한 번만 순회
        int end = 1;  // start 다음 블록부터 탐색 시작
        for (int start = 0; start < size - 1; start++) {
            int first = blocks.get(start);
            int second = blocks.get(start + 1);

            // end 이 start + 1보다 작은 경우 갱신
            end = Math.max(end, start+1);

            if (first < second) {
                // first보다 두 번째 블록이 크면 부분 문자열 개수는 first
                answer += first;
            } else {
                // 2 2 2 3 2
                // first >= second인 경우, 최대한 end를 늘려가며 카운트
                while (end + 1 < size && blocks.get(end + 1) == second) {
                    end++;
                }
                int extended = end;
                if (end + 1 < size && blocks.get(end + 1) > second) {
                    extended++;
                }
                answer += (extended - start);
                answer += (second - 1);
            }
//            System.out.println(start + " " + end + " " + answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countBlockSubstrings("AAABBCC"));       // 5
        System.out.println(countBlockSubstrings("AABBAAABBBCCC")); // 12
        System.out.println(countBlockSubstrings("AABBBCCCCABBCCCD"));
        System.out.println(countBlockSubstrings("AAABBBCCDAAA"));
        System.out.println(countBlockSubstrings("AAABBCCDDDAA"));
        System.out.println(countBlockSubstrings("ABBCCCDDDDEEEEEFFFFFFF"));
    }
}
