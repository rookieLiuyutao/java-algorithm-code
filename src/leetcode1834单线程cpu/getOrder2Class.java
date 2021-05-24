package leetcode1834单线程cpu;

import java.util.*;

/**
 *
 */
public class getOrder2Class {


        public class Task {
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
            long timestamp = 0;
            int idx = 0, i = 0;
            while(i<n) {
                while (i<n&&list.get(i).enqueueTime <= timestamp) {
                    queue.add(list.get(i));
                    i++;
                }
                if (queue.isEmpty()) {
                    timestamp = (long) list.get(i).enqueueTime;
                    while (i<n&&list.get(i).enqueueTime <= timestamp) {
                        queue.add(list.get(i));
                        i++;
                    }
                }

                Task timeOrder = queue.poll();
                res[idx++] = timeOrder.id;
                timestamp += timeOrder.processingTime;
            }
            while (!queue.isEmpty()){
                res[idx++] = queue.poll().id;
            }
            return res;

        }




}
