package ccf202012_2期末预测之最佳阈值;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.acwing.com/problem/content/3301/
 */
public class OptimalThresholdForEndOfTermForecast {
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

    public static void main(String[] args) throws Exception {
        int m = nextInt();
        int[][] g = new int[m + 1][2];
        int[] cnt0 = new int[m + 1];
        int[] cnt1 = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            g[i][0] = nextInt();
            g[i][1] = nextInt();
        }
        Arrays.sort(g, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i <= m; i++) {
            int x = g[i][1] == 0 ? 1 : 0;
            int y = g[i][1] == 1 ? 1 : 0;
            cnt0[i] = cnt0[i - 1] + x;
            cnt1[i] = cnt1[i - 1] + y;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int ans = -1, res = -1;
        for (int i = 1; i <= m; i++) {
            int j = i;
            while (j + 1 <= m && g[j + 1][0] == g[i][0]) {
                j++;
            }
            int t = cnt0[i - 1] + cnt1[m] - cnt1[j - 1];
            list.add(t);
            if (t >= ans) {
                ans = t;
                res = g[i][0];
            }
            i = j;
        }
        System.out.println(res);
        System.out.println(list);
        System.out.println(Arrays.toString(cnt0));
        System.out.println(Arrays.toString(cnt1));
    }

}
