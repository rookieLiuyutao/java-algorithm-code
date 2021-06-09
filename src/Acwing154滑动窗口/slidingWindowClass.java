package Acwing154滑动窗口;

import java.io.*;
import java.util.Scanner;

/**
 * @see 滑动窗口 https://www.acwing.com/problem/content/description/156/
 */
public class slidingWindowClass {
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

    static int N = 1000010;

    static int[] arr = new int[N], queue = new int[N];

    public static void main(String[] args)throws Exception {
//        用数组模拟队列的时候，要实现“队列的长度是动态变化的这个特点”，要用另一个存下标的数组来实现
        //也就是说queue中元素的长度，是队列的长度
        //queue中存的是选入队列的元素的下标，通过下标从原数组中获得值
        //这样做还有一个好处；如果存值，不可能通过该值找回该值原来的下标，
        //按这种方式存储，还可以记录该值的下标
        int arrLen = nextInt();
        int queueLen = nextInt();

        for (int i = 0; i < arrLen; i++) {
            arr[i] = nextInt();
        }

        int head = 0, end = -1;
        for (int i = 0; i < arrLen; i++) {
            if (head <= end && queue[head] < i - queueLen + 1) {
                head++;
            }
            while (head <= end && arr[queue[end]] >= arr[i]) {
                end--;
            }
            queue[++end] = i;
            if (i >= queueLen - 1) {
                out.print(arr[queue[head]] + " ");
            }

        }
        out.println();

        head = 0;
        end = -1;
        for (int i = 0; i < arrLen; i++) {
            if (head <= end && queue[head] < i - queueLen + 1) head++;
            while (head <= end && arr[queue[end]] <= arr[i]) end--;
            queue[++end] = i;
            if (i >= queueLen - 1) out.print(arr[queue[head]] + " ");

        }
    out.flush();

    }


}
