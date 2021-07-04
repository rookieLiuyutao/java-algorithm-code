package leetcode14最长公共前缀;

/**
 * @see 字符串 https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        int cnt = strs.length;
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder res = new StringBuilder();
        if ( n == 0) {
            return res.toString();
        }

        for(int i = 0;;i++){
            if (i>strs[0].length()){
                return res.toString();
            }
            char c = strs[0].charAt(i);
            for (String ss:strs){
                if (ss.length()<=i||ss.charAt(i)!=c){
                    return res.toString();
                }
            }
            res.append(c);
        }
    }

}


