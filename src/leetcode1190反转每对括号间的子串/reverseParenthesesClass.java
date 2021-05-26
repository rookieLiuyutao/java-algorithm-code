package leetcode1190反转每对括号间的子串;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see 双端队列 https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/gong-shui-san-xie-shi-yong-shuang-duan-d-r35q/
 */
public class reverseParenthesesClass {
    public String reverseParentheses(String s) {
        int n  = s.length();
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i <n; i++) {
          char c = s.charAt(i);
          if (c==')'){
              StringBuilder path = new StringBuilder();
              while (!deque.isEmpty()){
                  if (deque.peekLast()!='('){
                      path.append(deque.pollLast());
                  }else {
                      deque.pollLast();
                      for(int j = 0; j <path.length(); j++) {
                          deque.addLast(path.charAt(j));
                      }
                      break;
                  }
              }
          }else {
              deque.addLast(c);
          }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }


}
