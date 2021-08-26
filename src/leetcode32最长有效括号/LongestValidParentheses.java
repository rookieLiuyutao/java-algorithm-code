package leetcode32最长有效括号;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0, start = -1; i < n; i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else {
                if (!deque.isEmpty()) {
                    deque.pop();
                    if (!deque.isEmpty()) {
                        res = Math.max(res, deque.peek());
                    } else {
                        res = Math.max(i - start, res);
                    }
                } else {
                    start = i;
                }
            }
        }
        return res;
    }

}
