package kio.week17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_압축 {
    static public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        int next = 1;
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(c + "", next++);
        }
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        while(idx < msg.length()){
            int end = idx+1;
            while(end <= msg.length() && map.containsKey(msg.substring(idx,end))){
                end++;
            }
            String w = msg.substring(idx, end-1);
            list.add(map.get(w));
            if(end <= msg.length()){
                map.put(msg.substring(idx, end), next++);
            }
            idx = end-1;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}
