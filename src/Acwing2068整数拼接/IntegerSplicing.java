package Acwing2068整数拼接;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/2070/
 */
public class IntegerSplicing {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }

    static int []val ;

    public static void main(String[] args)throws Exception {
        int n = nextInt();
        int k = nextInt();
        val = new int[n];
        int sum = 0;
        for(int i = 0; i <n; i++) {
          val[i] = nextInt();
        }
        String temp = Arrays.toString(val);

        for (int i = n-1;i>=0;i--){
            sum+=val[i]*Math.pow(10,(n-i-1));
        }

        int res = 0;
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <n; j++) {

            }
        }
        System.out.println(temp);
        System.out.println(sum);

    }


}
