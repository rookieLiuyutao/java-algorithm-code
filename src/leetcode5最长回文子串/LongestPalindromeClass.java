package leetcode5最长回文子串;

/**
 * @see 回文字符串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromeClass {

    public String longestPalindromeWrong(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int begin = i;
            int j = n-1;
            int end = j--;
            while (i < j && s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            if (i - j >= 0) {
                return s.substring(begin, end + 1);
            }
        }
        return s.substring(0, 1);
    }


    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for(int i = 0; i <n; i++) {
            if (n%2!=0){
                int l = i-1,r = i+1;
                while (l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                }
                if (res.length()<r-l-1){
                    res= s.substring(l+1,r-l-1);
                }
            }else {
                int l = i,r=i+1;
                while (l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                }
                if (res.length()<r-l-1){
                    res= s.substring(l+1,r-l-1);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abb";

        System.out.println(new LongestPalindromeClass().longestPalindrome(s));
        System.out.println(new LongestPalindromeClass().longestPalindromeWrong(s));

    }

}
