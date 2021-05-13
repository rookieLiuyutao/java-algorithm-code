package leetcode26删除有序数组中的重复项;

public class removeDuplicatesClass {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,2,5,6,8,8,9};
        int len=removeDuplicates(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }


    }
}
