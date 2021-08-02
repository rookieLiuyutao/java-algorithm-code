package ccf201312_1出现次数最多的数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class theMostFrequentOccurrences {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = 0, t = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (t < entry.getValue() || (t == entry.getValue() && res > entry.getKey())){
                t = entry.getValue();
                res = entry.getKey();
            }
        }
        System.out.println(res);
    }

}
