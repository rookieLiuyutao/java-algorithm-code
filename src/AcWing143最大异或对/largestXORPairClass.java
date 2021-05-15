package AcWing143最大异或对;

import java.util.Scanner;

/**
 * @see trie树 https://www.acwing.com/problem/content/description/145/
 * 数据范围
 * 1≤N≤105,
 * 0≤Ai<2^31
 */
public class largestXORPairClass {
    static int N = 100010;
    static int n, idx;
    /**
     * 第一维N是题目给的数据范围，像在trie树中的模板题当中N为字符串的总长度（这里的总长度为所有的字符串的长度加起来），在本题中N需要自己计算，最大为N*31（其实根本达不到这么大，举个简单的例子假设用0和1编码，按照前面的计算最大的方法应该是4乘2=8但其实只有6个结点）。
     * 第二维x代表着儿子结点的可能性有多少，模板题中是字符串，而题目本身又限定了均为小写字母所以只有26种可能性，在本题中下一位只有0或者1两种情况所以为2。
     * 而这个二维数组本身存的是当前结点的下标，就是N喽，所以总结的话son[N][x]存的就是第N的结点的x儿子的下标是多少，然后idx就是第一个可以用的下标。
     * <p>
     * son的每31行存放着一个arr[i]，每一行存它的一个二进制位
     */
    static int[][] son = new int[N * 31][2];
    static int[] arr = new int[N];

    static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int m = x >> i & 1;
            if (son[p][m] == 0) {
                son[p][m] = ++idx;
            }
            p = son[p][m];
        }

    }

    static int queryLargestXORPair(int x) {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        int[] arr2 = {5, 1, 8, 13};

        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
            insert(arr[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, queryLargestXORPair(arr[i]));
        }

//        for(int i = 0; i <31*4; i++) {
//            for(int j = 0; j <2; j++) {
//                System.out.print(son[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(res);
    }


}
