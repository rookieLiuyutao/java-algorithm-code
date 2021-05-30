package Acwing41包含min函数的栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see 单调栈 https://www.acwing.com/problem/content/90/
 */
public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> assStk = new ArrayDeque<>();
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (assStk.isEmpty()||assStk.peek()>=x){
            assStk.push(x);
        }
    }

    public void pop() {
        if (assStk.peek().equals(stack.peek())){
            assStk.pop();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return assStk.peek();
    }
}
