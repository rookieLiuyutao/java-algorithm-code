package Acwing77翻转单词顺序;

/**
 * @see 字符串 双指针 https://www.acwing.com/problem/content/73/
 */
public class reverseWords {
    /**
     * 实现了翻转字符串指定2个位置间的字符
     * @param strArg
     * @param start
     * @param end
     * @return
     */
    public static String strReverse(String strArg,int start,int end){
        //
        String strStart=strArg.substring(0,start);
        String strEnd=strArg.substring(end);
        String strSub=strArg.substring(start, end);
        StringBuffer sb=new StringBuffer(strSub);
        strSub=sb.reverse().toString();
        //System.out.println(strSub);
        /**
         * concat用于链接字符串
         */
        return strStart.concat(strSub).concat(strEnd);

    }

    
    public static String reverseWords(String s) {
        StringBuilder stringBuffer = new StringBuilder(s);
        String res=stringBuffer.reverse().toString();
        String sb = res;
        for (int i = 0; i < res.length(); i++) {
            int j = i + 1;
            while (j < res.length() && res.charAt(j) !=' ') {
                j++;
            }
             sb= strReverse(sb,i,j);
            i=j;
        }
        return sb;
    }


    public static void main(String[] args) {
        String s ="In life's earnest battle they only prevail, who daily march onward and never say fail.";

        System.out.println(reverseWords(s));


    }
}
