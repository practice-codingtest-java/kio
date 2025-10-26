package kio.week17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_데이터분석 {
    static int[][] filter(int[][] data, int val_ext, int idx){
        List<int[]> result = new ArrayList<>();
        for(int[] d : data){
            if(d[idx] < val_ext) result.add(d);
        }
        return result.toArray(new int[result.size()][]);
    }
    static public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        int idx_ext = -1;
        switch(ext) {
            case "code": idx_ext = 0; break;
            case "date": idx_ext = 1; break;
            case "maximum": idx_ext = 2; break;
            case "remain": idx_ext = 3; break;
            default: throw new IllegalArgumentException();
        }

        int idx_sort = -1;
        switch(sort_by) {
            case "code": idx_sort = 0; break;
            case "date": idx_sort = 1; break;
            case "maximum": idx_sort = 2; break;
            case "remain": idx_sort = 3; break;
            default: throw new IllegalArgumentException();
        }
        int finalIdx_ext = idx_ext;
        int finalIdx_sort = idx_sort;
        return Arrays.stream(data)
                .filter(d -> d[finalIdx_ext] < val_ext)       // 조건 필터
                .sorted((a, b) -> a[finalIdx_sort] - b[finalIdx_sort]) // 정렬
                .toArray(int[][]::new);                  // 배열 변환
    }
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        System.out.println(Arrays.toString(solution(data, "date", 20300501	, "remain")));
    }
}
