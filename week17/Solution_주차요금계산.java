package kio.week17;

import java.util.*;

public class Solution_주차요금계산 {
    static public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTimes = new HashMap<>(); // 차량별 누적 주차 시간
        Map<String, Integer> inTimes = new HashMap<>();    // 현재 주차 중인 차량 (입차 시각)

        for (String record : records) {
            String[] token = record.split(" ");
            String timeStr = token[0];
            String car = token[1];
            String action = token[2];

            String[] timeToken = timeStr.split(":");
            int minutes = Integer.parseInt(timeToken[0]) * 60 + Integer.parseInt(timeToken[1]);

            if (action.equals("IN")) {
                inTimes.put(car, minutes);
            } else { // OUT
                int in = inTimes.remove(car);
                totalTimes.put(car, totalTimes.getOrDefault(car, 0) + (minutes - in));
            }
        }

        // 23:59에 출차 처리
        int endTime = 23 * 60 + 59;
        for (var item : inTimes.entrySet()) {
            String car = item.getKey();
            int in = item.getValue();
            totalTimes.put(car, totalTimes.getOrDefault(car, 0) + (endTime - in));
        }

        // 요금 계산
        List<String> cars = new ArrayList<>(totalTimes.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int total = totalTimes.get(cars.get(i));
            int fee = fees[1];
            if (total > fees[0]) {
                int over = total - fees[0];
                fee += over/fees[2]*fees[3];
                if(over%fees[2]>0){
                    fee += fees[3];
                }
            }
            answer[i] = fee;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
