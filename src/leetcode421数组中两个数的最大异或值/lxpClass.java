package leetcode421数组中两个数的最大异或值;

/**
 * @see 前缀树 https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class lxpClass {
    class Trie{
        Trie left;
        Trie right;
    }
    Trie root = new Trie();

    void insert(int x){
        Trie p  = root;
        for(int i = 30; i >=0; i--) {
          int m = (x>>i)&1;
          if (m==0){
              if (p.left==null){
                  p.left = new Trie();
              }
              p = p.left;
          }else {
              if (p.right == null) {
                  p.right = new Trie();
              }
              p=p.right;
          }
        }
    }
    int query(int x){
        Trie p =root;
        int res = 0;
        for (int i=30;i>=0;i--){
            int m  = (x>>i)&1;
            if (m == 0) {
                if (p.right != null) {
                    p = p.right;
                    res =res*2+1;
                }else {
                    p = p.left;
                    res = res*2;
                }
            }else {
                if (p.left != null) {
                    p = p.left;
                    res = res*2+1;
                }else {
                    p = p.right;
                    res*=2;
                }

            }

        }
        return res;
    }

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;

        int res = Integer.MIN_VALUE;
        for(int i = 0; i <n; i++) {
          insert(nums[i]);
        }
        for(int i = 0; i <n; i++) {
          res = Math.max(res,query(nums[i]));
        }
        return res;
    }
}
