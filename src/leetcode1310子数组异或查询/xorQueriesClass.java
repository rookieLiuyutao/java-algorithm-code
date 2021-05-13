//package leetcode1310子数组异或查询;
//
//import java.util.Arrays;
//
///**
// * @see 前缀和 异或 https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
// */
//public class xorQueriesClass {
//    public int[] xorQueries(int[] arr, int[][] queries) {
//        int n = arr.length;
//        int m = queries.length;
//        int [] sum = new int[n+1];
//        sum[0] = arr[0];
//        for(int i = 1; i <n; i++) {
//          sum[i]^= sum[i-1]^arr[i];
//        }
//        System.out.println("前缀和数组："+Arrays.toString(sum));
//        int[] ans = new int[m];
//
//        for(int i = 0; i <m; i++) {
//            if (i>queries[i][1]-queries[i][0]){
//                arr[i] = sum[queries[i][1]-queries[i][0]-1];
//            }
//
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,3,4,8};
//        int [][] queryArr = {{0,1},{1,2},{0,3},{3,3}};
//
//        System.out.println(Arrays.toString(new xorQueriesClass().xorQueries(arr,queryArr)));
//    }
//}
