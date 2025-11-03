package kio.week18;

public class Solution_유연근무제 {
    static public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        for(int i=0;i<n;i++){
            int hour = schedules[i]/100;
            int minute = schedules[i]%100;
            int totalMinute = hour*60 + minute;
            boolean flag = true;
            for(int j=0;j<timelogs[i].length;j++){
                int dayOfWeek = (startday + j) % 7;
                if(dayOfWeek == 0 || dayOfWeek == 6 ) continue;
                int logHour = timelogs[i][j] / 100;
                int logMinute = timelogs[i][j] % 100;
                int logTotalMinute = logHour*60 + logMinute;
                if(totalMinute + 10 < logTotalMinute){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        System.out.println(solution(schedules, timelogs, 5));
    }
}
