package Acwing3481阶乘的和;

import java.util.Scanner;

/**
 * @see 哈希表 https://www.acwing.com/problem/content/3484/
 */
public class factorialSum {
    /**
     * 求一个数阶乘的函数
     * 发现一个数的阶乘多次重复计算，可以把每个结果放到set里优化
     * @param x
     * @return
     */
    static int jirC(int x){
        int sum = 1;
        int num = x;
        while (x>0){
            sum*=x;
            x-=1;
        }
        return num==0? 1:sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if(n<0){
                break;
            }
            if(n==0){
                System.out.println("NO");
                continue;//***
            }
            for(int i = 9; i >=0; i--) {
                int m = jirC(i);
                if (n>=m){
                    n-=m;
                }
            }
            if (n==0){
                System.out.println("YES");
            }
            if(n>0){
                System.out.println("NO");
            }
        }

    }


}
