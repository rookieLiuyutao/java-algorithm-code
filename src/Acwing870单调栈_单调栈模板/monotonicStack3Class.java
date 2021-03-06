package Acwing870单调栈_单调栈模板;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @see 单调栈 https://www.luogu.com.cn/problem/P5788
 */

public class monotonicStack3Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] res = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <=n; i++) {
          arr[i] = sc.nextInt();
        }
        for (int i = n;i>=1;i--){
            while (!deque.isEmpty()&&arr[i]>deque.peek()){
                deque.pop();
            }
            if (deque.isEmpty()){
                res[i] = -1;
            }else {
                res[i] = deque.peek();
            }
            deque.push(arr[i]);
        }
        for(int i = 1; i <=n; i++) {
            System.out.print(res[i]+" ");
        }




    }


}
