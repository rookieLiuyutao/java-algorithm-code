package Acwing220最大公约数;

import java.io.*;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/874/
 */
public class GreatestCommonDivisor {

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
    static Scanner sc = new Scanner(System.in);
    static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args)throws Exception {
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(),b =nextInt();
            out.println(gcd(a,b));
        }
        out.flush();
    }

}
