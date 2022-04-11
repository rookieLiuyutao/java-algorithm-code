package 组成小于n的最大数;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static TreeSet<Integer> list = new TreeSet<>();

    static int gn(int x) {
        int res = 0;
        while (x > 0) {
            x /= 10;
            res++;
        }
        return res;
    }

    static void dfs(int u, int n, int x, int[] a) {
        list.add(x);
        if (u >= n) return;
        for (int j : a) {
            dfs(u + 1, n, x * 10 + j, a);
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int c = gn(n);
        int[] a = {2, 4, 9};
        dfs(0, c, 0, a);
        System.out.println(list.floor(n));
    }
}
