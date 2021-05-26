package leetcode461明汉距离;

/**
 * @see 位运算 https://leetcode-cn.com/problems/hamming-distance/
 */
public class hammingDistanceClass {

    public int hammingDistance(int x, int y) {
        int count = 0;
        for(int i = 31; i >0; i--) {
            int n = x>>i&1;
            int m = y>>i&1;
            if (m!=n){
                count++;
            }
        }
        return count;
    }

}
