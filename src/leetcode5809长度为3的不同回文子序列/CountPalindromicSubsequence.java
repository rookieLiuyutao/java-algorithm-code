package leetcode5809长度为3的不同回文子序列;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 */
public class CountPalindromicSubsequence {

    public int countPalindromicSubsequenceWrong(String s) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                String temp = "" + (char) ('a' + i) + (char) ('a' + j) + (char) ('a' + i);
                int l = 0, r = 0;
                while (l < s.length() && r < temp.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        l++;
                        r++;
                    } else {
                        l++;
                    }
                    if (r == 3) {
                        res++;
                    }
                }
            }
        }
        return res;
    }


    public int countPalindromicSubsequence2(String s) {
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < n - 2; i++) {

            if (set.contains(s.charAt(i))) {
                continue;
            }
            HashSet<Character> temp = new HashSet<>();
            int end = map.get(s.charAt(i));
            for (int j = i + 1; j < end; j++) {
                temp.add(s.charAt(j));
            }
            res += temp.size();
            set.add(s.charAt(i));
        }
        return res;
    }


    public int countPalindromicSubsequence(String str) {
        HashSet<Character> set = new HashSet<>();
        int n = str.length();
        int res = 0;
        for (int begin = 0; begin < n - 2; begin++) {
            if (!set.contains(str.charAt(begin))) {
                set.add(str.charAt(begin));
                int end = n - 1;
                while (end > begin + 1 && str.charAt(begin) != str.charAt(end)) {
                    end--;
                }
                if (str.charAt(begin) == str.charAt(end)) {
                    HashSet<Character> temp = new HashSet<>();
                    for (int i = begin + 1; i < end; i++) {
                        if (!temp.contains(str.charAt(i))) {
                            temp.add(str.charAt(i));
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(new CountPalindromicSubsequence().countPalindromicSubsequence(s));
    }
}
