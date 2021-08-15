package leetcode6Z字形变换;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class ConvertClass {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n; j++) {
                if (j % (numRows * 2 - 2) == i||j % (numRows * 2 - 2) == (numRows * 2 - 2-i)) {
                    res.append(s.charAt(j));
                }
            }
        }
        return String.valueOf(res);
    }

}
