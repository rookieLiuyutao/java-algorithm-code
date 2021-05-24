package leetcode1834单线程cpu;

import java.util.*;

public class getOrder3Class {
    static class Task {
        private int id;
        private int enqueueTime;
        private int processingTime;

        public Task(int id, int enqueueTime, int processingTime) {
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
//---------------------------入队前的准备工作------------------------------
        //因为返回的是任务标号序列，但优先级队列与数组不同，是无序的，所以要先给每个Task标上原来在数组中时的序列号
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(list, Comparator.comparingInt(t -> t.enqueueTime));
        PriorityQueue<Task> queue = new PriorityQueue<>((t1, t2) -> t1.processingTime == t2.processingTime ? t1.id - t2.id : t1.processingTime - t2.processingTime);
//------------------------------------------------------------------

//-------------------模拟过程--------------------
        long timestamp = list.get(0).enqueueTime;
        int idx = 0, i = 0;
        for (; i < n; i++) {
            if (list.get(i).enqueueTime <= timestamp) {
                queue.offer(list.get(i));
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            Task timeOrder = queue.poll();
            timestamp += timeOrder.processingTime;
            res[idx++] = timeOrder.id;
            if (i < n && queue.isEmpty() && timestamp < list.get(i).enqueueTime) {
                timestamp = list.get(i).enqueueTime;
            }
            for (; i < n; ++i) {
                // 把所有不超过当前时间 T 的元素都放到优先级队列里面去
                if (list.get(i).enqueueTime <= timestamp) {
                    queue.offer(list.get(i));
                } else {
                    // 如果 i 指向的任务开始时间已经超过了 T，那么后面的都超过，就跳出来
                    break;
                }
            }
        }
        return res;

    }


}
