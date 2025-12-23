package kio.week25;

public class Solution_연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long plus = 0, minus = 0, answer = 0;

        for (int i = 0; i < sequence.length; i++) {
            long v = sequence[i];

            long curPlus  = (i % 2 == 0) ? v : -v;
            long curMinus = -curPlus;

            plus  = Math.max(curPlus,  plus  + curPlus);
            minus = Math.max(curMinus, minus + curMinus);

            answer = Math.max(answer, Math.max(plus, minus));
        }

        return answer;
    }
}
