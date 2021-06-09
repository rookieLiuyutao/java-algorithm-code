package AcWing131直方图中最大的矩形_单调栈模板题_栈存下标;

import java.util.Scanner;

/**
 * @see 单调栈 https://www.acwing.com/problem/content/133/
 */
public class largestRectangleInTheHistogramClass {
    static final int  N = 100010;
         static    int[] height = new int[N];
         static    int[] left = new int[N];
         static    int[] right = new int[N];
         static    int[] q = new int[N];
    //        用数组模拟栈的时候，要实现“栈的长度是动态变化的这个特点”，要用另一个存下标的数组来实现
    //也就是说栈中元素的长度，是队列的长度
    //栈中存的是选入队列的元素的下标，通过下标从原数组中获得值
    //这样做还有一个好处；如果存值，不可能通过该值找回该值原来的下标，
    //按这种方式存储，还可以记录该值的下标
    //且使用时可以当做存值的栈使用
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
//            int[] height = new int[n + 2];
//            int[] left = new int[n + 2];
//            int[] right = new int[n + 2];
//            int[] q = new int[n + 2];
            height[0]=height[n+1] =-1;
            for (int i = 1; i <= n; i++) {
                height[i] = sc.nextInt();
            }
            int tt = 0;
            q[0] = 0;
            for(int i = 1; i <=n; i++) {
              while (height[i]<=height[q[tt]]){
                  tt--;
              }
              left[i] = q[tt];
              q[++tt] = i;
            }
            tt=0;
            q[0] = n+1;
            for (int i =n;i>0;i--){
                while (height[i]<height[q[tt]]){
                    tt--;
                }
                right[i] = q[tt];
                q[++tt] = i;

            }
            long res = 0;
            for(int i = 1; i <=n; i++) {
              res = Math.max(res,(long) height[i]*(right[i]-left[i]-1));
            }
            System.out.println(res);
        }
    }


}
