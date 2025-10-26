package kio.week17;

public class Solution_키패드누르기 {
    static int[][] pos = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}  // 9
    };
    private static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    static public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] left = {3, 0};  // * 위치
        int[] right = {3, 2}; // # 위치
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = pos[num];
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = pos[num];
            } else {
                int leftDist = dist(left, pos[num]);
                int rightDist = dist(right, pos[num]);

                if (leftDist < rightDist) {
                    answer.append("L");
                    left = pos[num];
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    right = pos[num];
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = pos[num];
                    } else {
                        answer.append("R");
                        right = pos[num];
                    }
                }
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        int[] numbers = new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }
}
