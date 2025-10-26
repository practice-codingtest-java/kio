package kio.week17;

public class Solution_지폐접기 {
    static public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true){
            if((wallet[0] >= bill[0] && wallet[1] >= bill[1]) || (wallet[1] >= bill[0] && wallet[0] >= bill[1])){
                break;
            }
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            }
            else{
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};
        System.out.println(solution(wallet, bill));
        wallet = new int[]{50,50};
        bill = new int[]{100,241};
        System.out.println(solution(wallet, bill));
    }
}
