package kio.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_b16928_뱀과사다리게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pos = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[101];
        boolean[] visited = new boolean[101];
        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        visited[1] = true;
        int answer = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curPos = cur[0];
            int curWeight = cur[1];
            if(curPos == 100){
                answer = curWeight;
                break;
            }
            for(int i=1;i<=6;i++){
                if(i+curPos > 100) break;
                if(visited[i+curPos]) continue;
                visited[i+curPos] = true;
                if(map[i+curPos] != 0){
                    int next = map[i+curPos];
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.offer(new int[]{next,curWeight+1});
                }
                else{
                    q.offer(new int[]{i+curPos,curWeight+1});
                }
            }
        }
        System.out.println(answer);
    }
}
