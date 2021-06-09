package Acwing6多重背包问题_单调队列优化;

import java.io.*;
import java.util.Arrays;

public class Main {

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
        arr = new int[bagVolume + 1];
        queue = new int[bagVolume + 1];
        dp = new int[bagVolume + 1];

        for (int i = 0; i < n; ++i) {
            arr = Arrays.copyOf(dp,bagVolume+1);

            int v = nextInt();
            int w = nextInt();
            int s = nextInt();

            for (int j = 0; j < v; ++j) {
                int head = 0, tail = -1;
                for (int k = j; k <= bagVolume; k += v) {

                    if (head <= tail && k - s*v > queue[head])
                        ++head;

                    while (head <= tail && arr[queue[tail]] - (queue[tail] - j)/v * w <= arr[k] - (k - j)/v * w)
                        --tail;

                    if (head <= tail)
                        dp[k] = Math.max(dp[k], arr[queue[head]] + (k - queue[head])/v * w);

                    queue[++tail] = k;
                }
            }
        }
        out.println(Arrays.toString(dp));
        out.println(dp[bagVolume]);
        out.flush();
        out.close();
    }
}
