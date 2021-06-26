package leetcode8字符串转换整数;

/**
 * @see 字符串 https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {

    public int myAtoi(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int k = 0;
        while (k<n&&ss[k]==' ') {
            k++;
        }
        if (k==n) {
            return 0;
        }

        int mu = 1;
        if (ss[k]=='-') {
            mu= -1;
            k++;
        }else if (ss[k]=='+'){
            k++;
        }
        long res = 0;
        while (k<n&&ss[k]>='0'&&ss[k]<='9'){
            res=res*10+ss[k]-'0';
            k++;
            if (res>Integer.MAX_VALUE) {
                break;
            }
        }
        res*=mu;
        if (res>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res< Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)res;

    }

    public static void main(String[] args) {
        String s = "42";
        System.out.println(new MyAtoi().myAtoi(s));

    }
}
