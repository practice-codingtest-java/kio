package kio.week25;

import java.util.ArrayList;
import java.util.List;

public class Solution_수식최대화 {
    long answer;
    char[] op = {'+','-','*'};
    String expr;

    boolean np(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) --i;
        if (i == 0) return false;

        int j = array.length - 1;
        while (array[i - 1] >= array[j]) --j;
        swap(array, i - 1, j);

        int k = array.length - 1;
        while (i < k) {
            swap(array, i++, k--);
        }
        return true;
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void calc(int[] order) {
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        long num = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                nums.add(num);
                ops.add(c);
                num = 0;
            }
        }
        nums.add(num);

        // 우선순위 적용
        for (int idx : order) {
            char curOp = op[idx];

            for (int i = 0; i < ops.size();) {
                if (ops.get(i) == curOp) {
                    long a = nums.get(i);
                    long b = nums.get(i + 1);
                    long res = calc(a, b, curOp);

                    nums.remove(i + 1);
                    nums.set(i, res);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }

        answer = Math.max(answer, Math.abs(nums.get(0)));
    }

    long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }

    public long solution(String expression) {
        this.expr = expression;
        answer = 0;

        int[] order = {0, 1, 2};
        while (true) {
            calc(order);
            if (!np(order)) break;
        }
        return answer;
    }
}
