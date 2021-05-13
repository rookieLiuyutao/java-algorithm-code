package Acwing53最小的k个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see 垃圾题 https://www.acwing.com/problem/content/49/
 */
public class getLeastNumbersClass {
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

}
