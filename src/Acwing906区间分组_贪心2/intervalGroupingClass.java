package Acwing906区间分组_贪心2;
/**
 * @see 区间分组 https://www.acwing.com/solution/content/17649/
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class intervalGroupingClass {
    public static int intervalGrouping(int[][] arr, int n) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            if (heap.isEmpty()||heap.peek()>=arr[i][0]) {
                heap.offer(arr[i][1]);
            }else {
                heap.poll();
                heap.offer(arr[i][1]);
            }
        }
        return heap.size();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(intervalGrouping(arr,n));

    }
}
