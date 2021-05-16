package leetcode421数组中两个数的最大异或值;

import java.util.Arrays;

/**
 * @see 前缀树 https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class lxp2Class {

        static int N = 20010;
        static int n, idx;

        static int[][] son = new int[N * 31][2];

    /**
     * 可以使用数组来实现 TrieTrie，但由于 OJ 每跑一个样例都会创建一个新的对象，因此使用数组实现，
     * 相当于每跑一个数据都需要 new 一个百万级别的数据，会 TLE 。
     * 因此这里使用数组实现必须要做的一个优化是：使用 static 来修饰 TrieTrie 数组，然后在初始化时做相应的清理工作。
     * 用构造方法实现清空
     */
//    public lxp2Class() {
//        for (int i = 0; i <= idx; i++) {
//            Arrays.fill(son[i], 0);
//        }
//        idx = 0;
//    }


        int queryLargestXORPair(int x) {
            int p = 0, res = 0;
            for (int i = 30; i >= 0; i--) {
                int m = x >> i & 1;//x的二进制的第i位是几
                if (son[p][1 - m] != 0) {
                    res += (1 << i);
                    p = son[p][1 - m];
                } else {
                    p = son[p][m];
                }
            }
            return res;
        }


        void insert(int x) {
            int p = 0;
            for (int i = 30; i >= 0; i--) {
                int m = x >> i & 1;
                if (son[p][m] == 0) {
                    son[p][m] = ++idx;
                }
                p = son[p][m];
            }

        }
        public int findMaximumXOR(int[] nums) {
            int res = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                insert(nums[i]);
            }
            for (int i = 0; i < n; i++) {
                res = Math.max(res, queryLargestXORPair(nums[i]));
            }
            return res;
        }

    public static void main(String[] args) {
        int[]arr = {0};
        System.out.println(new lxp2Class().findMaximumXOR(arr));
    }


}
