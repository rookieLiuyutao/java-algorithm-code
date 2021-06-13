package leetcode5786可移除字符的最大数目;

import java.util.Arrays;

public class maximumRemovalsClass {

    static boolean[] st;
    boolean check(int mid, String s, String p, int[] removable) {
        int n = s.length();
        int m = p.length();
        st = new boolean[n];
        Arrays.fill(st,false);
        for(int i = 0; i <mid; i++) {
          st[removable[i]] = true;
        }

        for (int i =0,j = 0;i<n;++i){
            if (s.charAt(i)==p.charAt(j)&&!st[i]){
                if (++j==m){
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, s, p, removable)) {
                l = mid;
            } else {
                r = mid + 1;
            }
        }


        return r;
    }

}
