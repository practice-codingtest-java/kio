package kio.week15;

import java.io.*;
import java.util.*;

public class Main_b1283_단축키지정 {
    static HashSet<Character> used = new HashSet<>();

    static String markShortcut(String line) {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            char c = Character.toLowerCase(words[i].charAt(0));
            if (!used.contains(c)) {
                used.add(c);
                // 대괄호로 감싸서 반환
                words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
                return String.join(" ", words);
            }
        }

        for (int i = 0; i < line.length(); i++) {
            char c = Character.toLowerCase(line.charAt(i));
            if (c != ' ' && !used.contains(c)) {
                used.add(c);
                return line.substring(0, i) + "[" + line.charAt(i) + "]" + line.substring(i + 1);
            }
        }

        // 3️⃣ 등록할 수 있는 단축키 없음
        return line;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            sb.append(markShortcut(line)).append("\n");
        }

        System.out.print(sb);
    }
}
