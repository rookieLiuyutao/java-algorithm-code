package leetcode5202最大的幻方;

import java.util.Arrays;

/**
 * @see
 */
public class largestMagicSquareClass {

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int x = Math.min(n,m)+1;
        int[][] sumR = new int[x][x];
        int[][] sumL = new int[x][x];
        int[][] sumX = new int[x][x];

        for(int i = 1; i <=x; i++) {
            for(int len = 2; len +i<=x; len++) {
                sumR[i][len] = sumR[i-1][len-1]+grid[i][len];
                sumL[i][len] = sumL[i-1][len-1]+grid[i][len];
                sumX[i][len] = sumX[i-1][len-1]+grid[i][len];
            }
        }
        int res = 1;
        for(int i = 0; i <x; i++) {
            for(int len = 1; len +i<x; len++) {
                if (sumL[i][len]==sumR[i][len]&&sumX[i][len]==sumL[i][len]){
                    res = Math.max(res,len);
                }
            }
        }
        for (int[] i:sumL){
            System.out.println(Arrays.toString(i));
        }
        for (int[] i:sumR){
            System.out.println(Arrays.toString(i));
        }
        for (int[] i:sumX){
            System.out.println(Arrays.toString(i));
        }


        return res;
    }
}
