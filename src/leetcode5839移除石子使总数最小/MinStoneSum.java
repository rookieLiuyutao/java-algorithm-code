package leetcode5839移除石子使总数最小;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinStoneSum {

    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
//        if (k>n){
//            k = n;
//        }
        PriorityQueue<Integer>queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int x:piles){
            queue.add(x);
        }

        while (k-- > 0) {
            queue.add(Math.toIntExact(Math.round(queue.poll() / 2.0)));
        }
        int res = 0;
        while (n-- > 0) {
            res+= queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int []a =  {10000};
        System.out.println(new MinStoneSum().minStoneSum(a,10000));
    }

}
