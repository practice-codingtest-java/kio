package kio.week23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수학적인 풀이 문제
 * 만약 지금까지 1,2,3,4를 만들 수 있고, 현재 값이 5라면 6,7,8,9를 만들수 있다.
 * 즉, 지금까지 나타난 모든 합보다 현재 값이 작거나 같다면 (둘의 합 - 1)까지 만들기 가능하다.
 */
public class Main_b2437_저울 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int res = 1;
        for(int i=0;i<N;i++) {
            if(arr[i] > res){
                break;
            }
            res += arr[i];
        }
        System.out.println(res);
    }
}
