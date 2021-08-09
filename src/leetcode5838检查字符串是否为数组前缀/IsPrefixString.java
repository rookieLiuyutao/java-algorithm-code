package leetcode5838检查字符串是否为数组前缀;

public class IsPrefixString {

    public boolean isPrefixString(String s, String[] words) {
        int n = words.length;
        String[]sum = new String[n+1];
        sum[0] = "";
        for(int i = 1; i <=n; i++) {
          sum[i] = sum[i-1]+words[i-1];
        }
        for(int i = 1; i <=n; i++) {
          if (s.equals(sum[i])){
              return true;
          }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String [] words = {"i","love","leetcode","apples"};
        System.out.println(new IsPrefixString().isPrefixString(s,words));
    }

}
