package leetcode35搜索插入位置;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0,r = n;
        while (l < r) {
            int mid = l+r>>1;
            if (nums[mid]>=target){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return r;
    }

}
