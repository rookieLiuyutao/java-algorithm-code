package Acwing72左旋转字符串;

/**
 * @see 字符串 https://www.acwing.com/problem/content/74/
 */
public class reverseLeftWordsClass {
    public static String leftRotateString(String str,int n) {
        return str.substring(n)+str.substring(0,n);
    }
    public static String reserveAB(String str,int begin,int end){
       return str.substring(0,begin)+new StringBuffer(str.substring(begin,end+1)).reverse()+str.substring(end+1);
    }

    public static void main(String[] args) {
        String s = "qwerdfghjk";
        System.out.println(leftRotateString(s,2));
        System.out.println(reserveAB(s,2,4));
        System.out.println(s.substring(2,4));
    }

}
