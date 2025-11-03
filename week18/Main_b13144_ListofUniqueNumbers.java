package kio.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b13144_ListofUniqueNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        int start = 0;
        for(int end = 0 ; end < n ; end++) {
            while (visited[arr[end]]) {
                visited[arr[start]] = false;
                start++;
            }
            visited[arr[end]] = true;
            answer += (end - start + 1);
        }
        System.out.println(answer);
    }
}
