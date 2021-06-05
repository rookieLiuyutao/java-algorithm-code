package leetcode1882使用服务器处理任务;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see 优先级队列 https://leetcode-cn.com/problems/process-tasks-using-servers/
 */
public class assignTasksClass {
    static class Server{
        int weight,index,time;

        public Server(int weight, int index, int time) {
            this.weight = weight;
            this.index = index;
            this.time = time;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> active = new PriorityQueue<>((o1, o2) -> o1.weight- o2.weight==0?o1.index- o2.index: o1.weight- o2.weight);
        PriorityQueue<Server> wast = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        int n = servers.length;
        int m = tasks.length;
        for(int i = 0; i <n; i++) {
          active.add(new Server(servers[i], i, 0));
        }
        int [] res = new int[m];
        int index = 0,globalTime = -1;
        while (index < m) {
            while (true) {
                globalTime++;
                while (!wast.isEmpty()&&wast.peek().time==globalTime){
                    active.offer(wast.poll());
                }
                if (!active.isEmpty()) {
                    break;
                }else {
                    globalTime = wast.peek().time-1;
                }
            }
            while (!active.isEmpty() && index <= globalTime && index < m) {
                Server server = active.poll();
                server.time = globalTime+tasks[index];
                res[index] = server.index;
                wast.offer(server);
                index++;
            }
        }
        return res;
    }

}
