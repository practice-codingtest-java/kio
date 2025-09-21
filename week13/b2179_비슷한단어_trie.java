package kio.week13;

import java.io.*;
import java.util.*;

public class b2179_비슷한단어_trie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 알파벳 소문자
        List<Integer> indexes = new ArrayList<>(); // 이 노드를 지나간 단어의 입력 순서
    }

    static TrieNode root = new TrieNode();
    static int maxLen = 0;
    static int ansA = -1, ansB = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        // 입력 저장
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // Trie에 단어 삽입하면서 최대 접두사 후보 갱신
        for (int idx = 0; idx < N; idx++) {
            insert(words[idx], idx);
        }

        // 출력
        if (ansA > ansB) {
            int tmp = ansA;
            ansA = ansB;
            ansB = tmp;
        }
        System.out.println(words[ansA]);
        System.out.println(words[ansB]);
    }

    static void insert(String word, int idx) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];

            // 현재 노드를 지난 단어 인덱스 추가
            node.indexes.add(idx);

            // 최대 접두사 후보 갱신 (리스트에 2개 이상 단어가 있으면)
            if (node.indexes.size() >= 2) {
                int len = i + 1;
                List<Integer> sortedIdx = new ArrayList<>(node.indexes);
                Collections.sort(sortedIdx);
                int curA = sortedIdx.get(0);
                int curB = sortedIdx.get(1);

                if (len > maxLen || (len == maxLen && (curA < ansA || (curA == ansA && curB < ansB)))) {
                    maxLen = len;
                    ansA = curA;
                    ansB = curB;
                }
            }
        }
    }
}
