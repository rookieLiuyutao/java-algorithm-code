package leetcode90子集2;

/**
 * @see 深搜 https://leetcode-cn.com/problems/subsets-ii/submissions/
 */

import java.util.*;


public class subsetClass2 {
    List<Integer> list = new ArrayList<Integer>();
    Set<List<Integer>> ans = new HashSet<>();

    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return new ArrayList<>(ans);
    }

    public void dfs(int[] num, int cur) {
        if (cur == num.length) {
            ans.add(new ArrayList<Integer>(this.list));
            return;
        }
        list.add(num[cur]);
        dfs(num,cur+1);
        list.remove(list.size()-1);
        dfs(num,cur+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(new subsetClass2().subsetsWithDup(arr));
    }

}
