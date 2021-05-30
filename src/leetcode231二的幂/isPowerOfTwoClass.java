package leetcode231二的幂;

/**
 * @see https://leetcode-cn.com/problems/power-of-two/
 */
public class isPowerOfTwoClass {
    public boolean isPowerOfTwo(int n) {
        int x;

        while (n > 1) {
            x = n%2;
            if (x!=0){
                return false;
            }else {
                n /= 2;
            }
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(new isPowerOfTwoClass().isPowerOfTwo(18));
    }
}
