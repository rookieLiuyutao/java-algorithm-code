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
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        Set<Integer> list3 = new HashSet<>();

        for(int i = 0; i <n; i++) {
          if (target[0]==triplets[i][0]){
              list1.add(i);
          }
          if (target[1]==triplets[i][1]){
              list2.add(i);
          }
          if (target[2]==triplets[i][2]){
              list3.add(i);
          }
        }
        System.out.println("1:"+list1);
        System.out.println(list1.isEmpty());
        System.out.println("2:"+list2);
        System.out.println(list2.isEmpty());

        System.out.println("3:"+list3);
        System.out.println(list3.isEmpty());




        return !list1.isEmpty()&&!list2.isEmpty()&&!list3.isEmpty();

    }

}
