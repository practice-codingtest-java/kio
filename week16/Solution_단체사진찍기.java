package kio.week16;

import java.util.Arrays;

public class Solution_단체사진찍기 {
    static boolean check(char[] s, String[] data) {
        for (String str : data) {
            char a = str.charAt(0);
            char b = str.charAt(2);
            char op = str.charAt(3);
            int dist = str.charAt(4) - '0';

            int posA = -1, posB = -1;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == a) posA = i;
                if (s[i] == b) posB = i;
            }
            int d = Math.abs(posA - posB) - 1;

            if (op == '=' && d != dist) return false;
            if (op == '<' && d >= dist) return false;
            if (op == '>' && d <= dist) return false;
        }
        return true;
    }

    static boolean np(char[] array) {

        int i = array.length - 1;
        while( i > 0 && array[i-1] >= array[i] ) --i;

        if( i == 0 ) return false;

        int j = array.length - 1;
        while( array[i-1] >= array[j]) --j;
        swap( array, i-1, j );

        // i 부터 맨 뒤까지 reverse
        int k = array.length - 1;
        while( i < k ) {
            swap(array, i++, k--);
        }
        return true;

    }

    static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    static public int solution(int n, String[] data) {
        int answer = 0;
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}; // 문제에 주어진 8명
        Arrays.sort(friends); // 사전순으로 시작
        do {
            System.out.println(friends);
            if (check(friends, data)) answer++;
        } while (np(friends));
        return answer;
    }
    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        int n = 2;
        System.out.println(solution(n, data));
    }
}
