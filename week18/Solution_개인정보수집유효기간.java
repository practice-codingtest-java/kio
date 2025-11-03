package kio.week18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_개인정보수집유효기간 {
    static public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] sp = term.split(" ");
            map.put(sp[0], Integer.parseInt(sp[1]));
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 1;
        for(String privacy : privacies){
            String[] sp = privacy.split(" ");
            String[] date = sp[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            month += map.get(sp[1]);
            if(month > 12){
                year += (month-1)/12;
                month = month % 12 == 0 ? 12 : month % 12;
            }
            String expiredDate = String.format("%04d.%02d.%02d", year, month, day);
            if(today.compareTo(expiredDate) >= 0){
                answer.add(i);
            }
            i++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }
}
