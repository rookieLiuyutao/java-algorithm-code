package leetcode5785合并若干三元组以形成目标三元组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * @see
 */
public class mergeTripletsClass {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int x = 0,y = 0,z = 0;
        for (int []i:triplets){
            if (i[0]>target[0]||i[1]>target[1]||i[2]>target[2]){
                continue;
            }
            x = Math.max(x,i[0]);
            y = Math.max(y,i[1]);
            z = Math.max(z,i[2]);
        }
        return x == target[0]&&y == target[1]&&z == target[2];
    }

}
