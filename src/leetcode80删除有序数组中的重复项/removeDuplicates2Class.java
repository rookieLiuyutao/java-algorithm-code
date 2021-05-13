package leetcode80删除有序数组中的重复项;

public class removeDuplicates2Class {
    public static int removeDuplicates3(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return 2;

        }
        boolean isDifferent=true;
        int i=0;
        int temp = 0;
        for (int j=1;j<nums.length;j++){
            if (nums[i] == nums[j] && isDifferent){
                i++;
               if (i==1){
                   temp++;
               }else {
                   temp+=2;
               }
                isDifferent=false;
            }else if (nums[i] == nums[j]){

            }else {
                nums[temp+1]=nums[j];
                i=temp+1;
                isDifferent=true;
            }

        }
        return temp+2;
    }
public static int removeDuplicates2(int[] nums){
    if(nums.length<=2){
        return nums.length;
    }
    int slow=2,fast=2;
    while (fast<nums.length){
        if (nums[slow-2]!=nums[fast]){
            nums[slow]=nums[fast];
            ++slow;
        }
        ++fast;
    }
    return slow;
}
    public static int removeDuplicates4(int[] nums, int k) {
            int u = 0;
            for (int x : nums) {
                if (u < k || nums[u - k] != x) {
                    nums[u++] = x;
                }
            }
            return u;
    }


        public static int removeDuplicates(int[] nums) {
            int i=0,j;
            boolean isSame=true;
            for(j=1;j<nums.length;j++){
                if(nums[i]==nums[j]&& isSame){
                    isSame=false;
                    i++;
                    nums[i]=nums[j];
                    continue;
                }
                if(nums[i]!=nums[j]){
                    nums[i+1]=nums[j];
                    i++;
                    isSame=true;
                }

            }
            return i+1;
        }






    public static void main(String[] args) {
        int [] arr={1,1,1,1,2,2,2,3,3,3,4};
        int len=removeDuplicates3(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
