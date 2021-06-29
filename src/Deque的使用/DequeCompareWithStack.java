package Deque的使用;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DequeCompareWithStack {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Deque<String> deque = new ArrayDeque<>();
        String res = "返回值为:";
        deque.add("初始的元素0");
        deque.add("初始的元素1");
        deque.add("初始的元素2");

        stack.push("初始的元素0");
        stack.push("初始的元素1");
        stack.push("初始的元素2");

        System.out.println("初始的stack:"+stack);
        System.out.println("初始的deque:"+deque);

        System.out.println("****************************添加元素***********************************");
        System.out.println("stack执行push前:"+stack);
        stack.push("添加元素1");
        System.out.println("stack执行push后:"+stack);
        System.out.println("-------------------------------------------");

        System.out.println("deque执行push前:"+deque);
        deque.push("添加元素1");
        System.out.println("deque执行push后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("stack执行add前:"+stack);
        System.out.println(res+stack.add("默认添加元素2"));
        System.out.println("stack执行add后:"+stack);
        System.out.println("-------------------------------------------");

    }

}
