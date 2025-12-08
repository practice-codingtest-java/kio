package kio.week23;

import java.util.Arrays;

public class Solution_숫자카드나누기 {
    int gcd(int a,int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    int arrGcd(int[] arr){
        int res = arr[0];
        for(int i = 1; i < arr.length ; i++){
            res = gcd(res, arr[i]);
            if(res == 1) break;
        }
        return res;
    }
    boolean canNotAllElementDivide(int num, int[] arr){
        for(int a : arr){
            if(a%num == 0) return false;
        }
        return true;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int a = arrGcd(arrayA);
        int b = arrGcd(arrayB);

        boolean flagA = a != 1 && canNotAllElementDivide(a, arrayB);
        boolean flagB = b != 1 && canNotAllElementDivide(b, arrayA);

        int answer = 0;

        if (flagA) answer = a;
        if (flagB) answer = Math.max(answer, b);

        return answer;
    }
}
