package leetcode5161可以输入的最大单词数;

import java.util.HashSet;

public class Main {

    public int canBeTypedWords(String text, String brokenLetters) {
        int m = brokenLetters.length();
        HashSet<Character>set = new HashSet<>();
        for(int i = 0; i <m; i++) {
          set.add(brokenLetters.charAt(i));

        }
        int res = 0;
        String []st = text.split(" ");
        for(String s:st){
            int x = s.length();
            int cnt = 0;
            for(int i = 0; i <x; i++) {
              if (set.contains(s.charAt(i))){
                  continue;
              }
              cnt++;
            }
            if (cnt == x) {
                res++;
            }
        }
        return res;
    }

}
