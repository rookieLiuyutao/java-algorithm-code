package leetcode295数据流的中位数;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 对顶堆
 */
public class MedianFinder {
    PriorityQueue<Integer> up = new PriorityQueue<>((o1, o2) -> o2-o1);
    PriorityQueue<Integer> down = new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (up.isEmpty()|| up.peek()<=num) {
            down.add(num);
        }else {
            up.add(num);
            down.add(up.poll());
        }
        if (up.size()+1<down.size()){
            up.add(down.poll());
        }
    }

    public double findMedian() {
        if (up.size()==down.size()+1){
            return up.peek();
        }else {
            return (up.peek()+down.peek())/2.0;
        }
    }
}
