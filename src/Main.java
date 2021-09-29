import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void chooseSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10个整数");
        int []arr = new int[10];
        for(int i = 0; i <10; i++) {
          arr[i] = sc.nextInt();
        }
        chooseSort(arr);
    }

}
