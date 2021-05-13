package leetcode179最大数;
/**
 * @see 贪心 https://leetcode-cn.com/problems/largest-number/
 */

import java.util.*;

public class largestNumberClass {
    public static String largestNumber(int[] nums) {
        ArrayList<Integer> arr =new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               String s1= o1+""+o2;
               String s2 =o2+""+o1;
               return s2.compareTo(s1);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(arr.get(i));
        }
        String res = ans.toString();
        return res.charAt(0)=='0'?"0":res;

    }

    public static void main(String[] args) {
        int[] arr= {1,8,9,56,5,2,21,46,98};
        System.out.println(largestNumber(arr));
    }
}
