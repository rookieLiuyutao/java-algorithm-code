package leetcode213打家劫舍2;

public class rob2Class {
    public static int rob2(int[] arr){
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        if (n==2){
            return Math.max(arr[0],arr[1] );
        }
        return Math.max(robRange(arr,0,n-1),robRange(arr,1,n));
    }
    public static int robRange(int[]arr,int start,int end){
        int first = arr[start];
        int second = Math.max(arr[start],arr[start+1]);
        for (int i = start+2; i < end; i++) {
            int temp = second;
            second = Math.max(first+arr[i],second);
            first=temp;
        }
        return second;
    }



    public static void main(String[] args) {
        int []arr = {1,2,3,1};
        System.out.println(rob2(arr));
    }
}
