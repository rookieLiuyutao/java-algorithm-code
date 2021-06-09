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
        n = nextInt();
        bagVolume = nextInt();
        arr = new int[bagVolume+1];
        queue = new int[bagVolume+1];
        dp = new int[bagVolume+1];

        for (int i = 0; i < n; i++) {
            //拷贝数组
            arr = Arrays.copyOf(dp,bagVolume+1);
            int volume = nextInt();
            int worth = nextInt();
            int solidNum = nextInt();
            for (int j = 0; j < volume; j++) {
                int hh = 0, tt = -1;
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
        out.println(Arrays.toString(dp));
        out.println(dp[bagVolume]);
        out.flush();
        out.close();
    }
}
