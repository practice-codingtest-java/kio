package kio.week18;

import java.util.Arrays;

public class Solution_2개이하로다른비트 {
    static public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long target = numbers[i];
            if((target & 1) == 0){ // 짝수의 경우 +1
                answer[i] = target | 1;
            }
            else{
                // 가장 먼저 나오는 0 -> 1 그리고 그 다음 비트 1->0 이 목표
                // target+1 -> 가장 먼저 나오는 0 -> 1 그 하위비트 모두 0으로 변경
                // (target + 1)) >> 2) 을 더해서 나머지 비트를 원복
                answer[i] = (target + ((target ^ (target + 1)) >> 2) + 1);
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2,7})));
    }
}
