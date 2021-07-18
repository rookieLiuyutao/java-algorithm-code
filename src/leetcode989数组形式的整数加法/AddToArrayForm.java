package leetcode989数组形式的整数加法;

import java.util.*;

/**
 * 高精度加法
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> res= new ArrayList<>();
        int n = num.length;
        for(int i = n-1; i >=0||k>0; i--) {
            if (i >= 0) {
                k +=num[i];
            }
            res.add(k%10);
            k/=10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4};
        System.out.println(new AddToArrayForm().addToArrayForm(arr,1));
    }
}
