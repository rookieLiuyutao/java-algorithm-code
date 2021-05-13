package 矩阵旋转;

/**
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成 顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 */
public class matrixRotat {
    public static void matrix(int[][] arr) {
        int ulx = 0;
        int uly = 0;
        int drx = arr.length - 1;
        int dry = arr[0].length - 1;

        while (ulx < drx) {
            rotate(arr, ulx++, uly++, drx--, dry--);
        }
    }

    public static void rotate(int[][] arr, int ulx, int uly, int drx, int dry) {
        int times = dry - uly;
        int temp ;
        for (int i = 0; i < times; i++) {
            temp = arr[ulx][uly + i];
            arr[ulx][uly + i] = arr[drx-i][uly];
            arr[drx-i][uly] = arr[drx][dry-i];
            arr[drx][dry-i] = arr[ulx+i][dry];
            arr[ulx+i][dry] = temp;
        }

    }
    public static void printMatrix(int[][] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(arr);
        matrix(arr);
        System.out.println("=========");
        printMatrix(arr);

    }

}
