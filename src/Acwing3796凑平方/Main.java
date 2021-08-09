package Acwing3796凑平方;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static HashSet<String> set = new HashSet<>();
    static int n;
    static boolean[] st;
    static StringBuilder sb = new StringBuilder();
    static String ss;
    static int  dfs(int u) {
        if (u <= n-1) {
            for (int i = 0; i < n; i++) {
                if (st[i]) {
                    sb.append(ss.charAt(i));
                }
            }
        }
        if (set.contains(sb.toString())){
            return ss.length();
        }
        st[u] = true;
        dfs(u + 1);
        st[u] = false;
        dfs(u + 1);
        return -1;
    }

    public static void main(String[] args) {
        int m = sc.nextInt();
        for (int i = 0; i < 100000; i++) {
            set.add(String.valueOf(i * i));
        }
        while (m-- > 0) {
             ss = sc.next();

            n = ss.length();
            st = new boolean[n + 10];
            System.out.println(dfs(0));
        }

    }
}
