package leetcode5781删除一个字符串中所有出现的给定子字符串;

public class removeOccurrencesClass {

    public  int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }

//    StringBuffer dfs(StringBuffer s,String p,int x,int n){
//        if (x==-1||s.length()<=n&&x+n-1>s.length()){
//            return s;
//        }
//        x = strStr(s.toString(),p);
//        s.delete(x,x+n);
//        dfs(s,p,x,n);
//        return s;
//    }

    public String removeOccurrences(String s, String part) {
        StringBuffer sb = new StringBuffer(s);
        int m = part.length();
        int n = s.length();
//        return dfs(sb,part,0,m).toString();
        int x = strStr(sb.toString(),part);
        while (x!=-1){
            sb.delete(x,x+m);
            x=strStr(sb.toString(),part);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "eemckxmckx"
        ;
        System.out.println(new removeOccurrencesClass().removeOccurrences(s,"emckx"));
    }

}
