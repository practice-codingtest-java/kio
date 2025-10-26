package kio.week17;

import java.util.Arrays;

public class Solution_파일명정렬 {
    static private class File implements Comparable<File> {
        String head;
        String number;
        String tail;
        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if(this.head.toLowerCase().compareTo(o.head.toLowerCase())==0) return Integer.parseInt(number)-Integer.parseInt(o.number);
            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
    static File parsing(String input) {
        String[] arr = new String[3];
        int idx = 0;
        while(idx < input.length()) {
            char c =  input.charAt(idx);
            if(c >= '0' && c <= '9') break;
            idx++;
        }
        String head = input.substring(0,idx);
        int sIdx = idx;
        while(idx < input.length()) {
            char c =  input.charAt(idx);
            if(c < '0' || c > '9') break;
            idx++;
        }
        String number = input.substring(sIdx,idx);
        String tail = input.substring(idx);
        return new File(head,number,tail);
    }
    static public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        int idx = 0;
        for(String file : files){
            fileArr[idx++] = parsing(file);
        }
        Arrays.sort(fileArr);
        String[] result = new String[files.length];
        idx = 0;
        for(File file : fileArr) {
            result[idx++] = file.head + file.number + file.tail;
        }
        return result;
    }
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
    }
}
