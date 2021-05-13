package Acwing1540主导颜色;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class dominantColorOptimizationIOClass {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int maxCount = 0, max = -1;
        Map<String, Integer> map = new HashMap<>();
        int m = Integer.parseInt(strs[0]), n = Integer.parseInt(strs[1]);
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map.put(line[j], map.getOrDefault(line[j], 0) + 1);
                int x = map.get(line[j]);
                if (x>maxCount){
                    maxCount = x;
                    max= Integer.parseInt(line[j]);
                }
            }
        }

        System.out.println(max);


    }
}
