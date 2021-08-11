package Acwing888求组合数IV;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class FindTheNumberOfCombinationsIV {
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static Scanner sc = new Scanner(System.in);
    static final int N = 5010;
    //储存范围内所有质数
    static int[] p = new int[N];
    static boolean[] st = new boolean[N];
    //储存所有质数出现的次数
    static int[] sum = new int[N];
    static int count;

    static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                p[count++] = i;
            }
            for (int j = 0; p[j] <= n / i; j++) {
                st[p[j] * i] = true;
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
    }

    static int getPCount(int n, int p){
        int res = 0;
        while (n != 0) {
            res+=n/p;
            n/=p;
        }
        return res;
    }

    static ArrayList<Integer> mul(ArrayList<Integer> a,int b){
        ArrayList<Integer>res = new ArrayList<>();
        int t = 0;
        for (int x : a) {
            t += x * b;
            res.add(t % 10);
            t /= 10;
        }
        while (t != 0) {
            res.add(t%10);
            t/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = sc.nextInt(),b = sc.nextInt();
        getPrimes(a);
        for(int i = 0; i <count; i++) {
            sum[i] = getPCount(a,p[i])-getPCount(b,p[i])-getPCount(a-b,p[i]);
        }
        ArrayList<Integer>res = new ArrayList<>();
        res.add(1);
        for(int i = 0; i <count; i++) {
            for(int j = 1; j <=sum[i]; j++) {
                res = mul(res,p[i]);
            }
        }
        for (int i = res.size()-1;i>=0;i--){
            out.println(res.get(i));
        }
        out.flush();
    }
}
