package kio.week19;

import java.util.ArrayList;
import java.util.List;

public class Solution_추석트래픽 {
    long parseMillie(String time){
        String[] s_time = time.split(":");
        long s_hour = Integer.parseInt(s_time[0]) * 1000L;
        long s_minute = Integer.parseInt(s_time[1])* 1000L;
        long s_second = (long)(Double.parseDouble(s_time[2])*1000);
        return s_hour * 3600 + s_minute * 60 + s_second;
    }
    public int solution(String[] lines) {
        List<long[]> logs = new ArrayList<>();
        for(String line : lines){
            String[] tokens = line.split(" ");
            long end =  parseMillie(tokens[1]);
            long duration = (long)(Double.parseDouble(tokens[2].substring(0, tokens[2].length() - 1))*1000); // 's' 제거
            long start =  end - duration + 1;
            logs.add(new long[]{start,end});
        }
        // logs.sort(Comparator.comparingLong(a -> a[1]));
        int maxCount = 0;
        for (int i = 0; i < logs.size(); i++) {
            long windowStart = logs.get(i)[1];          // 현재 로그 끝 시간
            long windowEnd = windowStart + 999;         // 1초 = 1000ms, 끝 포함

            int count = 0;
            for (int j = 0; j < logs.size(); j++) {
                long s = logs.get(j)[0];
                long e = logs.get(j)[1];
                if (e >= windowStart && s <= windowEnd) { // 겹치면 카운트
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
