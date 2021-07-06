package leetcode17电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @see 深搜 dfs 列出所有满足一定条件的情况
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    List<String> res = new ArrayList<>();
    String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    void dfs(int u, String digits, String path) {
        if (u == digits.length()) {
            res.add(path);
        } else {
            for (int i = 0; i < ss[digits.charAt(u) - '0'].length(); i++) {
                dfs(u + 1, digits, path + ss[digits.charAt(u) - '0'].charAt(i));
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        dfs(0, digits, "");
        return res;

    }

    public static void main(String[] args) {

        String input = "23333";
        System.out.println(new LetterCombinations().letterCombinations(input));

    }

}
