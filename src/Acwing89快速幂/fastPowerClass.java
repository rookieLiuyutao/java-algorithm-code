package Acwing89快速幂;

import java.util.Scanner;

/**
 * @see 快速幂 https://www.acwing.com/problem/content/91/
 *  可以将b分解成 : M1 * 2^0 + M2 * 2^1 + M3 * 2^2... (M1..Mk...Mn 代表的是0或者1,具体取值由b决定)
 *   这样的话结果就变成了 : a ^  (M1 * 2^0) * a ^ (M2 * 2^1) *...(这里的Mx的代表的是有效位,也就是mx = 1)
 *   由于a ^  (2^0) --> a ^ (2^1)具有:a ^  (2^0) * a ^  (2^0) = a ^ (2^1),可以通过累乘自身减少计算。
 *   而且因为取模运算的性质:
 *   (a + b) % p = (a % p + b % p) % p （1）
 *   (a - b) % p = (a % p - b % p) % p （2）
 *   (a * b) % p = (a % p * b % p) % p （3）
 *   a ^ b % p = ((a % p)^b) % p （4）
 *

 */
public class fastPowerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //求 a 的 b 次方对 p 取模的值。
        int a = sc.nextInt();
        int b = sc.nextInt();
        int p = sc.nextInt();
        int res = 1%p;
        while (b!=0){
            //b&1 是看b的二进制的最后一位是1还是0
            if ((b&1)!=0){
                //如果最后一位是1，就乘上对应位的2^x
                res = (int)(res*(long)a%p);
            }
         //算出每一位的2^x
            a = (int)(a*(long)a%p);
            //通过位运算，遍历b的二进制位的每一位
            b>>=1;
        }
        System.out.println(res);
    }

}
