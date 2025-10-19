package kio.week16;


public class Solution_숫자문자열영단어 {
    static public int solution(String s) {
        String[] words =
                {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<words.length; i++){
            s = s.replace(words[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        String s ="one4seveneight";
        System.out.println(solution(s));
    }
}
