package leetcode5840使字符串平衡的最小交换次数;

import java.util.ArrayDeque;

public class MinSwapsWrong {

    public int minSwaps(String s) {
        int n = s.length();
        int res = 0;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                deque.push(c);
            } else {
                if (deque.isEmpty()&&i==n-1) {
                    return 0;
                }
                if (c == ']' && !deque.isEmpty()) {
                    deque.pop();
                }
            }
        }
        return deque.size()/2;
    }

    public static void main(String[] args) {
        String s = "][][";
        System.out.println(new MinSwapsWrong().minSwaps(s));
    }

}
