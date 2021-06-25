package Acwing998起床困难综合症;

import java.io.*;
import java.util.Arrays;

/**
 * @see 位运算 贪心 https://www.acwing.com/problem/content/1000/
 *                https://www.acwing.com/solution/content/26589/
 * 思路：因为m的最大长度是10的9次方，最大二进制位数应该是2^31
 * 要使操作后的数最大，就要使结果的二进制位中出现尽可能多的1
 * 由于是在0——m中选一个数，设m的二进制位数为x
 * 相当于在从0——m个1的操作结果中出现尽可能多的1
 * 对于某一位，如果用0操作后变成1，结果中此位一定是1
 * 如果用1操作后变成0，结果中此位应该是0
 * 如果用1操作后变成1，结果中此位应该是1(前提是m的这一位是1)
 * 为了保存0 和1在每一位操作后的结果，开两个数组，一个全0，一个全1
 * 不用考虑前导0，0和0的任何操作都为0
 */
public class BitOperationChooseMostOne {
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

    static final int N = 31;
    static int [] none = new int[N],full = new int[N];

    public static void main(String[] args)throws Exception {
        int n = nextInt();
        int m = nextInt();
        int ans = 0;
        Arrays.fill(full,1);
        Arrays.fill(none,0);
        while (n-- > 0) {
            String option = next();
            int num = nextInt();
            if ("AND".equals(option)){
                for(int i = 0; i <31; i++) {
                  int x = num>>i&1;
                  full[i] &=x;
                  none[i]&=x;
                }
            }
            if ("OR".equals(option)){
                for(int i = 0; i <31; i++) {
                  int x = num>>i&1;
                  full[i] |=x;
                  none[i]|=x;
                }
            }
            if ("XOR".equals(option)){
                for(int i = 0; i <31; i++) {
                  int x = num>>i&1;
                  full[i] ^=x;
                  none[i]^=x;
                }
            }
        }
        for(int i = 0; i <31; i++) {
            if (none[i] == 1) {//0操作后为1
                ans+= (1<<i);
            } else if (full[i] == 1 && m >= (1 << i) + ans) {//1操作后为1
                ans+=(1<<i);
            }
        }
        out.println(ans);
        out.flush();
    }

}
