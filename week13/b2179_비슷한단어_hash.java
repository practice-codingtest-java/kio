package kio.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b2179_비슷한단어_hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Map<String, List<Integer>> prefixMap = new HashMap<>();
        int maxLen = 0;
        int ansA = 0, ansB = 1; // 초기값: 입력 순서 0과 1

        // 모든 단어에 대해 접두사 길이 1~L 생성
        for (int i = 0; i < N; i++) {
            String w = words[i];
            for (int len = 1; len <= w.length(); len++) {
                String prefix = w.substring(0, len);
                prefixMap.computeIfAbsent(prefix, k -> new ArrayList<>()).add(i);

                List<Integer> list = prefixMap.get(prefix);
                if (list.size() >= 2) { // 반드시 2개 이상 존재할 때만 후보
                    int a = list.get(0);
                    int b = list.get(1);
                    if (len > maxLen || (len == maxLen && (a < ansA || (a == ansA && b < ansB)))) {
                        maxLen = len;
                        ansA = a;
                        ansB = b;
                    }
                }
            }
        }

        System.out.println(words[ansA]);
        System.out.println(words[ansB]);
    }
}
