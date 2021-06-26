package leetcode5780删除一个元素使数组严格递增;

import java.util.ArrayList;

/**
 * @see
 */
public class canBeIncreasingClass {


    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int l = 0;


        ArrayList<Integer>list =new ArrayList<>();
        for (int i:nums){
            list.add(i);
        }
        if (n == 1) {
            return true;
        }else {

            for(int i = 0; i <n; i++) {
                if (list.get(i) > l) {
                    l = list.get(i);
                }else {

                    break;
                }
            }
            l = 0;
            for (int i:list){
                if (i > l) {
                    l = i;
                }else {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int []arr = {105,924,32,968};
        System.out.println(new canBeIncreasingClass().canBeIncreasing(arr));
    }
}
