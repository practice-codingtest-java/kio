package kio.week17;

import java.util.*;

public class Solution_오픈채팅방 {
    static public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String id = parts[1];

            if (action.equals("Enter")) {
                nameMap.put(id, parts[2]);
                logs.add(new String[]{"Enter", id});
            } else if (action.equals("Leave")) {
                logs.add(new String[]{"Leave", id});
            } else { // Change
                nameMap.put(id, parts[2]);
            }
        }
        String[] result = new String[logs.size()];
        int idx = 0;
        for (String[] log : logs) {
            String name = nameMap.get(log[1]);
            result[idx++] = name + "님이 " + (log[0].equals("Enter") ? "들어왔습니다." : "나갔습니다.");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}
