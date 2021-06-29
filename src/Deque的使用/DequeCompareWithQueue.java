package Deque的使用;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeCompareWithQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new ArrayDeque<>();

        String res = "返回值为:";
        deque.add("初始的元素0");
        deque.add("初始的元素1");
        deque.add("初始的元素2");

        queue.add("初始的元素0");
        queue.add("初始的元素1");
        queue.add("初始的元素2");


        System.out.println("初始的queue:"+queue);
        System.out.println("初始的deque:"+deque);


        System.out.println("deque执行push前:"+deque);
        deque.push("添加元素1");
        System.out.println("deque执行push后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("queue执行offer前:"+queue);
        System.out.println(queue.offer("添加元素1"));
        System.out.println("queue执行queue后:"+queue);
        System.out.println("-------------------------------------------");


    }


}
