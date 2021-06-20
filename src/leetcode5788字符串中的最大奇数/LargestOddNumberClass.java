package leetcode5788字符串中的最大奇数;

/**
 * @see 字符串 https://leetcode-cn.com/problems/largest-odd-number-in-string/
 */
public class LargestOddNumberClass {
    public String largestOddNumber(String num) {
        int n = num.length();
        char[] s = num.toCharArray();
        while (n>=0&&s[n-1]%2==0){
            n--;
        }
        StringBuffer sb  = new StringBuffer(num);
        return sb.substring(0,n);
    }

}
