package kio.week13;

import java.io.*;
import java.util.*;

public class b2179_비슷한단어_sort {
    static class Word{
        String word;
        int rank;
        public Word(String word, int rank) {
            this.word = word;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 정렬 사용
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            list.add(new Word(s, i));
        }

        list.sort(Comparator.comparing(w -> w.word));
        List<Word> candidates = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int prefix = findPrefix(list.get(i).word, list.get(i + 1).word);
            if (prefix > max) {
                max = prefix;
                candidates.clear();
                candidates.add(list.get(i));
                candidates.add(list.get(i + 1));
            }
            else if (prefix == max) {
                candidates.add(list.get(i));
                candidates.add(list.get(i + 1));
            }
        }
        // 입력 순서(rank) 기준 정렬
        candidates.sort(Comparator.comparingInt(w -> w.rank));

        Word first = candidates.get(0);
        Word second = null;
        for (int i = 1; i < candidates.size(); i++) {
            if (findPrefix(first.word, candidates.get(i).word) == max) {
                second = candidates.get(i);
                break;
            }
        }

        if (second != null) {
            sb.append(first.word).append("\n");
            sb.append(second.word);
        }
        System.out.println(sb);
    }
    static int findPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int ans = 0;
        for(int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
