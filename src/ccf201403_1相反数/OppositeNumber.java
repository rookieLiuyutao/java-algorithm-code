package ccf201403_1相反数;

import java.io.*;
import java.util.HashSet;

/**
 * https://www.acwing.com/problem/content/3200/
 */
public class OppositeNumber {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }


    public static void main(String[] args)throws Exception {
        HashSet<Integer> set = new HashSet<>();
        int n = nextInt();
        int res = 0;
        while (n-- > 0) {
            int x = nextInt();
            if (set.contains(-x)){
                res++;
            }
            set.add(x);
        }
        System.out.println(res);
    }

}
