package 快速排序_分治;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class quickSortClass {
    public static void quickSort(int left, int right, int[] arr) {
        if (left >= right) {
            return;
        }
        int i = left - 1, j = right + 1, x = arr[left + right >> 1];
        while (i < j) {
            do {
                i++;
            } while (arr[i] < x);
            do {
                j--;
            } while (arr[j] > x);
            if (i < j) {
                swap(arr,i,j);
            }
        }
        quickSort(left, j, arr);
        quickSort(j + 1, right, arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 5, 2, 8, 6, 8, 4, 5, 23, 5, 6, 9, 45};
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        String[] nums=null;
        System.out.println("请输入一组整数，以空格分隔：");
        nums=sc.nextLine().split(" ");
        int arr[]=new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(nums[i]);
        }

        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));

    }
}
