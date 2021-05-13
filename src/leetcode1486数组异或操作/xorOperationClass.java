package leetcode1486数组异或操作;

/**
 * @see 异或 https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class xorOperationClass {
    public static int xorOperation(int n, int start) {
        int temp = 0;

        for(int i = 0; i <n; i++) {
            temp^= start+2*i;

        }
        return temp;
    }

    public static void main(String[] args) {


        System.out.println(xorOperation(4,3));
    }

}
