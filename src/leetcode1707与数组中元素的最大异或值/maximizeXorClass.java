package leetcode1707与数组中元素的最大异或值;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see 字典树 https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
 */
public class maximizeXorClass {
    class Trie{
        Trie left;
        Trie right;
        int min = Integer.MAX_VALUE;
        Trie root = new Trie();
        void insert(int x){
            //设置一个遍历树的指针
            Trie p = new Trie();
            p.min = Math.min(p.min,x);
            for (int i = 30;i>=0;i--){
                int m = x>>i&1;
                if (m==0){
                    if (p.left==null){
                        p.left=new Trie();
                    }
                    p = p.left;
                }else {
                    if (p.right == null) {
                        p.right = new Trie();
                    }
                    p = p.right;
                }
                p.min = Math.min(p.min,x);
            }

        }
    }

    int  query(int x,int limit){
        Trie p  = new Trie();
        if (p.min>limit){
            return -1;
        }
        int res = 0;
        for (int i = 30;i>=0;i--){
            int m = x>>i&1;
            if (m==0){
                if (p.right != null&&p.right.min<=limit) {
                    p = p.right;
                    res |= 1<<i;
                }else{
                    p = p.left;
                }
            }else {
                if (p.left!=null&&p.left.min<=limit){
                    p = p.left;

                }
            }

        }
        return res;
    }




    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] ans  = new int[n];
        return ans;
    }


}
