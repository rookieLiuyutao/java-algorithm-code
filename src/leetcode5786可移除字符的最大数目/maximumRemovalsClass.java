package leetcode5786可移除字符的最大数目;

public class maximumRemovalsClass {

    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
        StringBuffer sb = new StringBuffer(s);
        StringBuffer sp = new StringBuffer(p);
        for(int i = 0; i <n; i++) {
          sb.delete(removable[i],removable[i]);



        }


    return 0;
    }

}
