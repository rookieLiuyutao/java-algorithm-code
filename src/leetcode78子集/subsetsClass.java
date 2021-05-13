package leetcode78子集;

/**
 * @see 深搜 https://leetcode-cn.com/problems/subsets/
 */

import java.util.*;


public class subsetsClass {
    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return ans;
    }
    public static void dfs(int[] nums,int cur){
        if (cur==nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(nums,cur+1);
        t.remove(t.size()-1);
        dfs(nums,cur+1);

    }

    public static void main(String[] args) {
        int[] num ={0};
        System.out.println(subsets(num).toString());
    }
}
