package kio.week17;

import java.util.regex.*;
import java.util.*;

public class Solution_다트 {
    static public int solution(String dartResult) {
        int answer = 0;

        Pattern p = Pattern.compile("\\d{1,2}[SDT][*#]?");
        Matcher m = p.matcher(dartResult);
        int[] point = new int[3];
        int i = 0;
        while (m.find()) {
            String round = m.group();
            int idx = 0;
            while (Character.isDigit(round.charAt(idx))) idx++;
            int score = Integer.parseInt(round.substring(0, idx));

            char bonus = round.charAt(idx);
            int exp = (bonus == 'S') ? 1 : (bonus == 'D') ? 2 : 3;
            score = (int) Math.pow(score, exp);

            if (round.length() > idx + 1) {
                char option = round.charAt(idx + 1);
                if (option == '*') {
                    score *= 2;
                    if (i > 0) point[i - 1] *= 2;
                } else if (option == '#') {
                    score *= -1;
                }
            }
            point[i++] = score;
        }
        answer = Arrays.stream(point).sum();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
}
