package leetcode5777使数组元素相等的减少操作次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
public class Main {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i <n; i++) {
          map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        map.put(nums[0],0);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int m = list.size();
        int[] sum = new int[m];
        for(int i = 1; i <m; i++) {
          sum[i]+=sum[i-1]+map.get(list.get(m-i));
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(Arrays.toString(sum));
        res+= Arrays.stream(sum).sum();
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {49995,49999,49993,49997,49996,50000,49991,49998,49992,49994};
        System.out.println(new Main().reductionOperations(arr));
    }
}