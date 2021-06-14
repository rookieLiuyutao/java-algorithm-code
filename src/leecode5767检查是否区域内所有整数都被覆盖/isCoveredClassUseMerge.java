package leecode5767检查是否区域内所有整数都被覆盖;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @see 区间合并
 */
public class isCoveredClassUseMerge {
    //创建一个类表示每个区间
    static class Intervals {
        int left;
        int right;

        public Intervals(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
         //用list保存合并后的新区间组
        ArrayList<Intervals> list = new ArrayList<>();
        int n= ranges.length;
        //将每个区间按照左端点排序
        Arrays.sort(ranges,Comparator.comparingInt(o->o[0]));

        //区间合并
        int l = ranges[0][0];
        int maxR= ranges[0][1];
        for(int i = 0; i <n; i++) {
            //贪心的合并每个可以合并的区间
            while (ranges[i][0]<=maxR+1){
                maxR = Math.max(maxR,ranges[i][1]);
                if (i == n-1) {
                    break;
                }
                i++;
            }
            //将每个新区间加入list
            list.add(new Intervals(l, maxR));
            l = ranges[i][0];
            maxR = ranges[i][1];
        }
        for (int[] x:ranges){
            System.out.println(Arrays.toString(x));
        }
        for (Intervals x:list){
            System.out.print("["+x.left+","+x.right+"]  ");
        }
        //判断[left,right]是否属于list中的某个区间
        for (Intervals x: list){
            if (left>=x.left&&right<=x.right){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
         int[][]ranges = {{1,50}};
//         int [][]ranges = {{1,2,},{3,4},{5,6}};
        System.out.println(new isCoveredClassUseMerge().isCovered(ranges,1,50));

    }

}
