package kio.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_b2607_비슷한단어 {
    static boolean isSimilar(int[] count1, int[] count2, int len1, int len2) {
        int diff = 0;
        for(int i = 0; i < 26; i++) {
            diff += Math.abs(count1[i] - count2[i]);
        }

        if(len1 == len2) {
            // 같은 길이 → 한 글자만 바뀌거나 동일
            return diff == 0 || diff == 2;
        } else if(Math.abs(len1 - len2) == 1) {
            // 길이 차이가 1 → 한 글자 추가/삭제
            return diff == 1;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] target = br.readLine().toCharArray();
        int[] targetCount = new int[26];
        for(int i=0;i<target.length;i++){
            targetCount[target[i]-'A']++;
        }
        int ans = 0;
        for(int i=0;i<n-1;i++){
            char[] candidate = br.readLine().toCharArray();
            int[] candidateCount = new int[26];
            for(int j=0;j<candidate.length;j++){
                candidateCount[candidate[j]-'A']++;
            }
            if(isSimilar(targetCount, candidateCount, target.length, candidate.length)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
