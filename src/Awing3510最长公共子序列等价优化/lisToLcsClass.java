package Awing3510最长公共子序列等价优化;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @see 二分 https://www.acwing.com/problem/content/3513/
 */
public class lisToLcsClass {
    static int N = 100010;
    static int[] id = new int[N];
    static int[] queue = new int[N];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] u = br.readLine().split(" ");
        String[] v = br.readLine().split(" ");
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(u[i]);
        }
        for(int i = 0; i < n; i++) b[i] = Integer.parseInt(v[i]);

        Arrays.fill(id, -1);
        for (int i = 0; i < n; i++) {
            id[a[i]] = i;
        }
        int qHead = 0;
        queue[0] = -1;
        for (int i = 0; i < n; i++) {
            int k = id[b[i]];
            if (k == -1) continue;
            int l = 0, r = qHead;
            while (r > l) {

                int mid = l + r +1 >> 1;
                if (queue[mid] < k) {
                   l=mid;
                }else {
                    r=mid-1;
                }
            }
            queue[r+1] =k;
            qHead = Math.max(qHead,r+1);

        }

        System.out.println(qHead);
    }


}
