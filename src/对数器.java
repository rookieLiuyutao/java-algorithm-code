import edu.princeton.cs.algs4.*;
public class 对数器 {
    public  static int[] generateRandomArry(int size ,int value){
        //生成随机数组
        int[] arr = new int[(int)((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)((value + 1)*Math.random()-(int)(value*Math.random()));
        }
        return arr;
    }
    public static int[] copyArry(int[] arr){
        if (arr ==null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 ==null && arr2!=null)||(arr1!=null && arr2 ==null)){
            return false;
        }
        if (arr1 == null && arr2 ==null){
            return true;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if ( arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
