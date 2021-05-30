package Acwing870单调栈_单调栈模板;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class monotonicStack4Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        while (n-- > 0) {
            int x = sc.nextInt();
            while (!deque.isEmpty()&&deque.peek()>x){
                deque.pop();
            }
            if (deque.isEmpty()){
                System.out.print("-1 ");
            }else {
                System.out.print(deque.peek()+" ");
            }
            deque.push(x);
        }

    }
}
