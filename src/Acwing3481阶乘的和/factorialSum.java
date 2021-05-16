package Acwing3481阶乘的和;

import java.util.Scanner;

/**
 * @see   https://www.acwing.com/problem/content/3484/
 */
public class factorialSum {
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
            int c = n;
            if(n==-1){
                break;
            }
            if(n==0){
                System.out.println("NO");
                continue;
            }
            for(int i = 9; i >=0; i--) {
                int m = jirC(i);
                if (c>=m){
                    c-=m;
                }
            }
            if (c==0){
                System.out.println("YES");
            }
            if(c>0){
                System.out.println("NO");
            }

        }

    }


}
