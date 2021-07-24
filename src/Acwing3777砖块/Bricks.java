package Acwing3777砖块;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3780/
 * 递推
 */
public class Bricks {

    static Scanner sc = new Scanner(System.in);
    static char[]ss;
    static void update(int i){
        if (ss[i]=='W'){
            ss[i] = 'B';
        }else {
            ss[i] = 'W';
        }
    }
    static boolean check(String temp ,char c) {
         ArrayList<Integer> res = new ArrayList<>();
        ss = temp.toCharArray();
        int n = ss.length;
        for (int i = 0; i + 1 < n; i++) {

            if (ss[i] != c) {
                update(i);
                update(i+1);
                res.add(i);
            }
        }
        if (ss[ss.length-1]!=ss[0]){
            return false;
        }
        System.out.println(res.size());
        for (Integer re : res) {
            System.out.print(re+1 +" ");
        }
        if (res.size()!=0){
            System.out.println();
        }
        return true;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String temp = sc.next();

            if (!check(temp, 'W') && !check(temp, 'B')) {
                System.out.println("-1");
            }
        }
    }

}
