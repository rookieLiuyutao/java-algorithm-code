package leetcode9回文数;

import java.util.ArrayList;

/**
 * @see https://leetcode-cn.com/problems/palindrome-number/
 */
public class IsPalindromeClass {

    public boolean isPalindrome(int x) {
        ArrayList<Integer> list = new ArrayList<>();
        while (x > 0) {
            int y = x%10;
            list.add(y);
            x/=10;
        }
        System.out.println(list);
        int n = list.size();
        for(int i = 0,j=n-1; i<j; i++,j--) {
          if (list.get(i).equals(list.get(j))){
              continue;
          }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new IsPalindromeClass().isPalindrome(x));
    }
}
