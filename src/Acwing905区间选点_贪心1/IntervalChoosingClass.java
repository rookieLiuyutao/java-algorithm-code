package Acwing905区间选点_贪心1;
/**
 * @see 贪心 https://www.acwing.com/solution/content/10615/
 */

import java.util.*;


public class IntervalChoosingClass {

    public static int intervalChoosing(int[][] arr, int N) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();

        }
        int res = 0;
        int flag = arr[0][1];
        for (int i = 0; i < N; i++) {

            if (arr[i][0] < flag) {
                res++;

            }
            flag = arr[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(intervalChoosing(arr, N));

    }
}
