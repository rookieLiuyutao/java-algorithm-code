package leetcode1834单线程cpu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see 优先级队列 https://leetcode-cn.com/problems/single-threaded-cpu/
 */
public class getOrderClass {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        //必须先把tasks中的任务按照时间顺序排号，才能入堆
        Integer[] tasksTimeArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            tasksTimeArr[i] = i;

        }
        Arrays.sort(tasksTimeArr,(Comparator.comparingInt(o -> tasks[o][0])));


        //定义优先级队列的入堆排序规则
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (tasks[o1][1]>tasks[o2][1]){
                return 1;
            }else if (tasks[o1][1]==tasks[o2][1]){
                return o1-o2;
            }
            return -1;
        });
        int k = 0,i=0,timestamp = 0;
        while (i<n){
            if (queue.isEmpty()){
                timestamp = Math.max(timestamp,tasks[tasksTimeArr[i]][0]);
            }
            while (i<n&&tasks[tasksTimeArr[i]][0]<=timestamp){
                queue.offer(tasksTimeArr[i]);
                i++;
            }
            res[k++] = queue.peek();
            int[]tasksArr = tasks[queue.poll()];
            timestamp = Math.max(timestamp,tasksArr[0])+tasksArr[1];

            }
        while (!queue.isEmpty()) {
            res[k++] = queue.poll();
        }
        return res;

        }

    }
