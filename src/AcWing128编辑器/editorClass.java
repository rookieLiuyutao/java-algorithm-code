package AcWing128编辑器;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see 栈 https://www.acwing.com/problem/content/130/
 */
public class editorClass {



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
        int m = nextInt();
        Deque<Integer> leftDq = new ArrayDeque<>();
        Deque<Integer> rightDq = new ArrayDeque<>();
        int[] sums = new int[n+1];
        int [] sumsMax = new int[n+1];
        while (n-- > 0) {
            char c = next().charAt(0);
            switch (c){
                case 'I':
            }

        }


    }

}
