package week12;

public class prog_이모티콘할인행사 {
    static int[][] cases;
    static int idx;
    static int[] discounts = {10, 20, 30, 40};

    static void make_perm(int depth, int size, int[] current) {
        if (depth == size) {
            cases[idx++] = current.clone();  // 깊은 복사하여 저장
            return;
        }

        for (int i = 0; i < 4; i++) {
            current[depth] = discounts[i];
            make_perm(depth + 1, size, current);
        }
    }
    static public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int emoticonCount = emoticons.length;
        int userCount = users.length;
        int totalCases = (int) Math.pow(4, emoticonCount);
        cases = new int[totalCases][];
        idx = 0;
        make_perm(0, emoticonCount, new int[emoticonCount]);
        for(int i=0;i<totalCases;i++){
            int[] totalAmount = new int[userCount];
            for(int j=0;j<emoticonCount;j++){
                for(int k=0;k<userCount;k++){
                    if(cases[i][j] >= users[k][0]){
                        int discountedPrice = emoticons[j] * (100 - cases[i][j]) / 100;
                        totalAmount[k] += discountedPrice;
                    }
                }
            }
            int totalAssign = 0;
            int totalSale = 0;
            for (int k = 0; k < userCount; k++) {
                if (totalAmount[k] >= users[k][1]) {
                    totalAssign++;
                } else {
                    totalSale += totalAmount[k];
                }
            }

            if (totalAssign > answer[0]) {
                answer[0] = totalAssign;
                answer[1] = totalSale;
            } else if (totalAssign == answer[0] && totalSale > answer[1]) {
                answer[1] = totalSale;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] users = {{40,10000},{25,10000}};
        int[] emoticons = {7000, 9000};
        int[] res = solution(users, emoticons);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
