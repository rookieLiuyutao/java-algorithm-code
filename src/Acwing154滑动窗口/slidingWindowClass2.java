package Acwing154滑动窗口;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see 滑动窗口 单调队列 https://loj.ac/p/10175
 */
public class slidingWindowClass2 {
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

    public static void main(String[] args)throws Exception {
        Deque<Integer> deque =  new ArrayDeque<>();
        int n = nextInt();
        int windowsLen = nextInt();
        int[]arr = new int[n];
        for(int i = 0; i <n; i++) {
          arr[i] = nextInt();

        }
        //用i来判断元素是否装满窗口，和做窗口内的指针
        //用j来做窗口所滑动的数组的指针
        for (int j = 0,i = 1-windowsLen;j<n;i++,j++){
            //i>0,窗口已经完全进来
            //求最大值时，窗口内的元素单调递减
            //deque.getFirst()==arr[i-1]判断窗口内元素个数是否溢出
            // 弹出队头
            if (i>0&&deque.getFirst()==arr[i-1]){
                deque.removeFirst();
            }
            while (!deque.isEmpty()&&arr[j]<deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(arr[j]);
            if (i >= 0) {
                out.print(deque.peekFirst()+" ");
            }
        }
        deque.clear();
        out.println();
        for (int j = 0,i = 1-windowsLen;j<n;i++,j++){
            if (i>0&&deque.getFirst()==arr[i-1]){
                deque.removeFirst();
            }
            while (!deque.isEmpty()&&arr[j]>deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(arr[j]);
            if (i >= 0) {
                out.print(deque.peekFirst()+" ");
            }
        }

    out.flush();
    out.close();
    }
}
