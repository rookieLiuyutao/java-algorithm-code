package Acwing3483二的幂次方;

import java.util.Scanner;

/**
 * @see 深搜 字符串 https://www.acwing.com/problem/content/3486/
 */
public class powerOfTwoClass {

    static final int N = 20010;
    static int n;

    static String dfs(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 29;i>=0;i--){
            if ((n>>i&1)==1){
                //除了第一位，其他前面都有+
                if (res.length()!=0) {
                    res.append("+");
                }
                String temp = "";
                if (i==0){
                    res.append("2(0)");
                }else if (i==1){
                    res.append("2");
                }else {
                   temp = "2("+dfs(i)+")";
                }
                res.append(temp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            System.out.println(dfs(n));
        }

    }
}
