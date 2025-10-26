package kio.week17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_뉴스클러스터링 {
    static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }
    static public int solution(String str1, String str2) {
        List<String> list1 = makeBigrams(str1.toLowerCase());
        List<String> list2 = makeBigrams(str2.toLowerCase());

        if (list1.isEmpty() && list2.isEmpty()) return 65536;

        // 교집합 구하기 (멀티셋 개념)
        List<String> intersection = new ArrayList<>();
        List<String> tempList2 = new ArrayList<>(list2);
        for (String s : list1) {
            if (tempList2.contains(s)) {
                intersection.add(s);
                tempList2.remove(s);
            }
        }

        // 합집합 = list1 + list2 - intersection
        int interSize = intersection.size();
        int unionSize = list1.size() + list2.size() - interSize;

        double jaccard = (double) interSize / unionSize;
        return (int) (jaccard * 65536);
    }
    static List<String> makeBigrams(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (isAlpha(c1) && isAlpha(c2)) {
                result.add("" + c1 + c2);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String a = "handshake";
        String b= "shake hands";
        System.out.println(solution(a,b));
        a ="FRANCE";
        b = "french";
        System.out.println(solution(a,b));
    }
}
