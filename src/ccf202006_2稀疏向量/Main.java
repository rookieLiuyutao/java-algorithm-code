package ccf202006_2稀疏向量;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acwing.com/problem/content/3291/
 */
public class Main {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter  out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }
    static HashMap<Integer,Integer> u = new HashMap<>();
    static HashMap<Integer,Integer> v = new HashMap<>();

    public static void main(String[] args)throws Exception {
        int n = nextInt(),a = nextInt(),b = nextInt();
        for(int i = 0; i <a; i++) {
          u.put(nextInt(),nextInt());
        }
        for(int i = 0; i <b; i++) {
          v.put(nextInt(),nextInt());
        }
        long res = 0;
        for (Map.Entry<Integer,Integer> entry: u.entrySet()){
            if (v.containsKey(entry.getKey())){
                res+= (long) entry.getValue() *v.get(entry.getKey());
            }
        }
        System.out.println(res);
    }

}
