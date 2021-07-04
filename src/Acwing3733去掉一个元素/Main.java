package Acwing3733去掉一个元素;

import java.io.*;
import java.util.Arrays;

/**
 * @see https://www.acwing.com/problem/content/3736/
 */
public class Main {
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

    static int []arr;
    static int n;

    public static void main(String[] args)throws Exception {
        n = nextInt();
        arr = new int[n];
        for(int i = 0; i <n; i++) {
          arr[i] = nextInt();
        }
        int sum = Arrays.stream(arr).sum();
        int count = 0;
        for(int i = 0; i <n; i++) {
          if ((sum-arr[i])%2==0){
              count++;
          }
        }
        out.println(count);
        out.flush();
    }


}
