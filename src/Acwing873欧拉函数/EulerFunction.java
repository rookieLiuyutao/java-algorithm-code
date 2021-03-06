package Acwing873欧拉函数;
/**
 * https://www.acwing.com/problem/content/875/
 * 质数
 */

import java.io.*;
import java.util.Scanner;

public class EulerFunction {

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
    public static void main(String[] args)throws Exception {
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt();
            int res = a;
            for (int i = 2; i <= a / i; i++) {
                if (a % i == 0) {
                    //先写除再写乘不会报int
                    res = res/i*(i-1);
                    while (a%i==0) {
                        a/=i;
                    }
                }
            }
            if (a>1){
                res = res/a*(a-1);
            }
            out.println(res);
        }
        out.flush();
    }

}
