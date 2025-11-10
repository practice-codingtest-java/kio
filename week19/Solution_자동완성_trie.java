package kio.week19;

import java.util.HashMap;
import java.util.Map;

public class Solution_자동완성_trie {
    private class TrieNode{
        int count = 0;
        TrieNode[] children = new TrieNode[26];
    }
    private class Trie{
        TrieNode root = new  TrieNode();
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) node.children[idx] = new TrieNode();
                node = node.children[idx];
                node.count++;
            }
        }

        int uniquePrefixLength(String word) {
            TrieNode node = root;
            int len = 0;
            for (char c : word.toCharArray()) {
                len++;
                node = node.children[c - 'a'];
                if (node.count == 1) break; // 유일해지는 순간
            }
            return len;
        }

    }
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            answer += trie.uniquePrefixLength(word);
        }

        return answer;
    }
}
