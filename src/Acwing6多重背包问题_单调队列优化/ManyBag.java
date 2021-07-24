package Acwing6多重背包问题_单调队列优化;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @see 动态规划 背包问题 https://www.acwing.com/problem/content/description/6/
 */
public class ManyBag {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    static int N = 110;
    static int n, bagVolume;
    static int[] arr, queue;
    static int[] dp;

    public static void main(String[] args) throws Exception {
//        朴素做法
//        for(int i=1;i<=n;i++)
//            for(int j=0;j<=m;j++)
//                for(int k=0;k<=s[i]&&k*v[i]<=j;k++)
//                    f[i][j]=max(f[i][j],f[i-1][j-v[i]*k]+w[i]*k);
        n = nextInt();
        bagVolume = nextInt();
        arr = new int[bagVolume+1];
        queue = new int[bagVolume+1];
        dp = new int[bagVolume+1];
//        因为枚举到第i个物品时,要将f[0~m]的状态全部都更新一遍.所以在这里
//        f[j]为体积为j的情况下获得价值的最大值,对于每一个物品i来说都要更新f[0]~f[m]的值,枚举完i个物品之后,f[m]就是最优解.
//                讲到这里先举个例子,0~11可以如何表示出来呢?答:
//        0 3 6 9
//        1 4 7 10
//        2 5 8 11
//        所以f[0]~f[m]的状态也可以这样表示出来:
//        f[0], f[v],   f[2*v],   f[3*v],   …… , f[k*v]
//        f[1], f[v+1], f[2*v+1], f[3*v+1], …… , f[k*v+1]
//        f[2], f[v+2], f[2*v+2], f[3*v+2], …… , f[k*v+2]...
//        f[r], f[v+r], f[2*v+r], f[3*v+r], …… , f[k*v+r]
//        其中0<r<v,如果有f[x]中,x>m的,会在代码中被筛除,其中m=k*v+x;(0<x<=r);
        for (int i = 0; i < n; i++) {
            //拷贝数组
            arr = Arrays.copyOf(dp,bagVolume+1);
            int volume = nextInt();
            int worth = nextInt();
            int solidNum = nextInt();
            //把所有体积按除v进行剩余分类
            //j枚举余数r
            for (int j = 0; j < volume; j++) {
                //相当于在【体积上限】的数组上，维护一个长度为物品数量的窗口，寻找最大值
                int hh = 0, tt = -1;
                //因为选择的物品既要满足【不超过背包的体积上限】又【不能超过给定物品的数量】
                //所以k枚举的是体积，k每一次+=【单个物品的体积】，相当于枚举【物品数量】
                for (int k = j; k <= bagVolume; k += volume) {
                    if (hh <= tt && k - solidNum * volume > queue[hh]) {
                        ++hh;
                    }

                    while (hh <= tt && arr[k] - (k - j) / volume * worth >= arr[queue[tt]]-(queue[tt]-j)/volume*worth) {
                        --tt;
                    }
                    if (hh <= tt) {
                        dp[k] = Math.max(dp[k], arr[queue[hh]] + (k - queue[hh]) / volume * worth);
                    }
                    queue[++tt] = k;
                }
            }
        }
        //时间复杂度o(n*bagVolume)
        //因为剩余分类，分的类多，每一类个数就少
        //类的数量*每类的数量=bagVolume
        out.println(Arrays.toString(dp));
        out.println(dp[bagVolume]);
        out.flush();
        out.close();
    }
}
