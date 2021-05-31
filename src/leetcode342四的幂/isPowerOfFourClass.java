package leetcode342四的幂;

/**
 * @see s https://leetcode-cn.com/problems/power-of-four/
 */
public class isPowerOfFourClass {

    public boolean isPowerOfFour(int n) {
        int x ;
        while (n>1){
             x = n%4;
            if (x==0){
                n/=4;
            }else {
                return false;
            }
        }
        return n==1;
    }
}
