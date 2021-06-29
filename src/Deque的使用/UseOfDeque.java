package Deque的使用;

import java.util.ArrayDeque;
import java.util.Deque;

public class UseOfDeque {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        String res = "返回值为:";
        deque.push("初始的元素0");
        deque.push("初始的元素1");
        deque.push("初始的元素2");

        System.out.println("****************************添加元素***********************************");
        System.out.println("执行push前:"+deque);
        deque.push("添加元素1");
        System.out.println("执行push后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行add前:"+deque);
        System.out.println(res+deque.add("添加元素2"));
        System.out.println("执行add后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行addFirst前:"+deque);
        deque.addFirst("添加元素3");
        System.out.println("执行addFirst后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行addLast前:"+deque);
        deque.addLast("添加元素4");
        System.out.println("执行addLast后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行offer前:"+deque);
        System.out.println(deque.offer("添加元素5"));
        System.out.println("执行offer后"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行offerFirst前:"+deque);
        System.out.println(res+deque.offerFirst("添加元素6"));
        System.out.println("执行offerFirst后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行offerLast前:"+deque);
        System.out.println(res+deque.offerLast("添加元素7"));
        System.out.println("执行offerLast后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("*********************************************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*******************删除并返回元素*******************************");
        System.out.println("执行pop前:"+deque);
        System.out.println(res+deque.pop());
        System.out.println("执行pop后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行poll前:"+deque);
        System.out.println(res+deque.poll());
        System.out.println("执行poll后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行pollFirst前:"+deque);
        System.out.println(res+deque.pollFirst());
        System.out.println("执行pollFirst后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行remove前:"+deque);
        System.out.println(res+deque.remove());
        System.out.println("执行remove后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行removeFirst前:"+deque);
        System.out.println(res+deque.removeFirst());
        System.out.println("执行removeFirst后:"+deque);
        System.out.println("-------------------------------------------");


        System.out.println("执行removeLast前:"+deque);
        System.out.println(res+deque.removeLast());
        System.out.println("执行remove后Last:"+deque);
        System.out.println("-------------------------------------------");
        System.out.println("***************************************************************************");
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("******************只返回元素****************************");
        System.out.println("执行peek前:"+deque);
        System.out.println(res+deque.peek());
        System.out.println("执行peek后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行peekFirst前:"+deque);
        System.out.println(res+deque.peekFirst());
        System.out.println("执行peekFirst后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行peekLast前:"+deque);
        System.out.println(res+deque.peekLast());
        System.out.println("执行peekLast后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行getFirst前:"+deque);
        System.out.println(res+deque.getFirst());
        System.out.println("执行getFirst后:"+deque);
        System.out.println("-------------------------------------------");

        System.out.println("执行getLast前:"+deque);
        System.out.println(res+deque.peekLast());
        System.out.println("执行getLast后:"+deque);
        System.out.println("-------------------------------------------");



    }

}
