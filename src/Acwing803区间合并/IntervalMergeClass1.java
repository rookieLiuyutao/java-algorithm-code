package Acwing803区间合并;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @see 区间合并 https://www.acwing.com/solution/content/10915/
 */
public class IntervalMergeClass1 {
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

    static class Intervals {
        int left;
        int right;

        public Intervals(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static ArrayList<Intervals> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        int n = nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new Intervals(nextInt(), nextInt()));
        }
        list.sort(Comparator.comparingInt(o -> o.left));
        int res = 1;
        int maxR = list.get(0).right;
        for (int i = 1; i < n; i++) {
            if (list.get(i).left <= maxR) {
                maxR = Math.max(maxR,list.get(i).right);
            }else {
                res++;
                maxR = list.get(i).right;
            }
        }
        out.println(res);
        
        out.flush();
    }
}
