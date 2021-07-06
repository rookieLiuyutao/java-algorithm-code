package leetcode20有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see 栈
 */
public class IsValid {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                deque.push(c);
            }else {
                if (deque.isEmpty()){
                    return false;
                }
                if (c==')'&&deque.peek()=='('){
                    deque.pop();
                }else if (c==']'&&deque.peek()=='['){
                    deque.pop();
                }else if (c=='}'&&deque.peek()=='{'){
                    deque.pop();
                }else {
                    return false;
                }
            }

        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String ss = "(){}";
        System.out.println(new IsValid().isValid(ss));
    }
}