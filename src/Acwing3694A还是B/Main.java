package Acwing3694A还是B;


import java.io.*;


/**
 * @see 打卡题 https://www.acwing.com/problem/content/3697/
 */
public class Main {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        char[] s ;
        String ss = next();
        s = ss.toCharArray();
        int countA = 0,countB = 0;
        for(int i = 0; i <n; i++) {
          if (s[i]=='A'){
              countA++;
          }else {
              countB++;
          }
        }

        if (countA==countB){
            out.println('T');
        }else if (countA<countB){
            out.println('B');
        }else {
            out.println('A');
        }


        out.flush();
        out.close();
    }


}
