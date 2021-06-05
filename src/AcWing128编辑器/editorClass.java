package AcWing128编辑器;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @see 栈 https://www.acwing.com/problem/content/130/
 */


//编辑器共有五种指令，如下：
//
//        1、I x，在光标处插入数值 x。
//        2、D，将光标前面的第一个元素删除，如果前面没有元素，则忽略此操作。
//        3、L，将光标向左移动，跳过一个元素，如果左边没有元素，则忽略此操作。
//        4、R，将光标向右移动，跳过一个元素，如果右边没有元素，则忽略次操作。
//        5、Q k，假设此刻光标之前的序列为 a1,a2,…,an，输出 max1≤i≤kSi，其中 Si=a1+a2+…+ai。

public class editorClass {

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
        int n = nextInt();
        Deque<Integer> leftDq = new ArrayDeque<>();
        Deque<Integer> rightDq = new ArrayDeque<>();
        int[] sums = new int[n + 1];
        int[] sumsMax = new int[n + 1];

        sumsMax[0] = Integer.MIN_VALUE;
//        System.out.println(Arrays.toString(sums));
        while (n-- > 0) {
            char c = next().charAt(0);
            switch (c) {
                //插入操作：光标处输入一个字符，光标右移
                case 'I':
                    leftDq.push(nextInt());

                    sums[leftDq.size()] = sums[leftDq.size() - 1] + leftDq.peek();
                    sumsMax[leftDq.size()] = Math.max(sumsMax[leftDq.size() - 1], sums[leftDq.size()]);
                    break;
                case 'D':
                    if (!leftDq.isEmpty()){
                        leftDq.pop();
                    }
                    break;
                case 'L':
                    if (!leftDq.isEmpty()){
                        rightDq.push(leftDq.pop());
                    }
                    break;
                case 'R':
                    if (!rightDq.isEmpty()) {
                        leftDq.push(rightDq.pop());
                        sums[leftDq.size()] = sums[leftDq.size() - 1] + leftDq.peek();
                        sumsMax[leftDq.size()] = Math.max(sumsMax[leftDq.size() - 1], sums[leftDq.size()]);
                    }
                    break;
                case 'Q':
                    int k = nextInt();
                    out.println(sumsMax[k]);
                    break;
            }
        }
        out.flush();

    }

}
