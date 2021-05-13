package Acwing789数的范围;
/**
 * @see 数的范围 https://www.acwing.com/problem/content/791/
 */

import java.io.BufferedInputStream;
import java.util.Scanner;

public class rangeOfNumber {
    /**
     *
     * @param arr 输入的数组
     * @param n 数组的长度
     * @param k 要查询的数
     * @return 返回左右指针重合的位置
     */
    public static int findLeft(int[] arr, int n, int k) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            //下取整
            int mid = left + right >> 1;
            //当right=left-1时，mid=left，不会影响right=mid
            if (arr[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[right] == k ? left : -1;
        //return arr[left] == k ? left : -1;也可
    }

    public static int findRight(int[] arr, int n, int k) {
        int left = 0, right = n - 1;
        while (left < right) {
            //上取整
            int mid = left + right + 1 >> 1;
            //当right=left-1时，mid=left，如果下取整，会造成下面一句 left=left;会造成死循环
            if (arr[mid] <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return arr[right] == k ? left : -1;
//        return arr[left] == k ? left : -1;也可
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));//用BufferedInputStream提升输入性能
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k;
        while (q-- > 0) {
            k = sc.nextInt();
            System.out.println(findLeft(arr, n, k) + " " + findRight(arr, n, k));
        }

    }
}
