package Acwing1225正则问题;

import java.util.Scanner;

/**
 * @see 字符串 深搜 dfs
 * https://www.acwing.com/problem/content/1227/
 */
public class RegularProblem {
    static Scanner sc = new Scanner(System.in);

    static String ss;
    static int u;

    static int dfs(){
        int res = 0;
        while (u<ss.length()){
            if (ss.charAt(u)=='('){
                u++;
                res+=dfs();
                u++;
            }else if (ss.charAt(u)=='|'){
                u++;
                res = Math.max(res,dfs());
            }else if (ss.charAt(u)==')'){
                break;
            }else {
                u++;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ss = sc.next();
        System.out.println(ss);
        System.out.println(dfs());

    }
}
