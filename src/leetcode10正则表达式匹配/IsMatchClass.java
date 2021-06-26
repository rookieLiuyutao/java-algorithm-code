package leetcode10正则表达式匹配;

/**
 * @see 动态规划 https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class IsMatchClass {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        s = ' ' + s;
        p = ' ' + p;
        char[] ns = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (j + 1 <= m && cp[j + 1] == '*') {
                    continue;
                }
                if (i > 0 && cp[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (ns[i] == cp[j] || cp[j] == '.');
                } else if (cp[j] == '*') {
                    dp[i][j] = dp[i][j - 2] || i > 0 && dp[i - 1][j] && (ns[i] == cp[j - 1] || cp[j - 1] == '.');
                }

            }
        }
        return dp[n][m];
    }


}
