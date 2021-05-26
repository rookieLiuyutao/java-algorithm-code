package leetcode1190反转每对括号间的子串;

/**
 * @see 深搜 https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/java-di-gui-jie-fa-jie-jin-shuang-bai-by-djks/
 */
public class reverseParentheses2Class {
    int idx = 0;

    public StringBuffer dfs(String s) {
        StringBuffer sb = new StringBuffer();
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                idx++;
                sb.append(dfs(s).reverse());
            } else if (s.charAt(idx) == ')') {
                idx++;
                return sb;
            } else {
                sb.append(s.charAt(idx));
                idx++;
            }
        }
        return sb;
    }

    public String reverseParentheses(String s) {
        return dfs(s).toString();
    }


}
