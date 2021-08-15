package Acwing3803数组去重;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();
            int n = nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            for(int i = n-1; i >=0; i--) {
                if (!set.contains(a[i])){
                    list.add(a[i]);
                }
                set.add(a[i]);
            }
            out.println(list.size());
            for(int i = list.size()-1; i>=0; i--) {
                out.print(list.get(i)+" ");
            }
        }
        out.flush();
    }

}
