package AcwingAcWing241楼兰图腾_树状数组模板;

import java.io.*;
import java.util.Arrays;

/**
 * @see 树状数组 https://www.acwing.com/problem/content/description/243/
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
    static int[] arr, trArr,dec,lower,greater;
    static int n;

    static void add(int x,int m){
        for(int i = x; i <=n; i+=i&-i) {
          trArr[i]+=m;
        }
    }
    static int query(int x){
        int sum = 0;
        for (int i = x;i>0;i-=i&-i){
            sum+= trArr[i];
        }
        return sum;
    }


    public static void main(String[] args) throws Exception {
         n = nextInt();
        arr = new int[n];
        trArr = new int[n+1];
        dec = new int[n+1];
        lower = new int[n];
        greater = new int[n];


        for(int i = 1; i <=n; i++) {
            arr[i] = nextInt();
            int x = arr[i];
            lower[i] = query(x-1);
            greater[i] = query(n)-query(x);
            add(x,1);
        }
        Arrays.fill(trArr,0);
        long res1 = 0,res2 = 0;
        for (int i = n;i>0;i--){
            int x=  arr[i];
            res1+=(long) lower[i]*(long)query(x-1);
            res2 += (long) greater[i]*(long) (query(n)-query(x));
            add(x,1);

        }
        out.println(res1);
        out.println(res2);
        out.flush();
    }

}
