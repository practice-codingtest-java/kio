package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_b20920_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String input = br.readLine();
            if(input.length()<M) continue;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return e2.getValue() - e1.getValue(); // 빈도 내림차순
            }
            if (e1.getKey().length() != e2.getKey().length()) {
                return e2.getKey().length() - e1.getKey().length(); // 길이 내림차순
            }
            return e1.getKey().compareTo(e2.getKey()); // 사전순 오름차순
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
