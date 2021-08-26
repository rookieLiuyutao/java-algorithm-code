package x;


import java.util.Arrays;

/**
 * @author 刘宇韬
 */


class test {
    public static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        swap(a,0,1);
        System.out.println(Arrays.toString(a));
    }
}

