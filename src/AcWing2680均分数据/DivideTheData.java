package AcWing2680均分数据;

import java.util.Collections;

import java.util.Scanner;

public class DivideTheData {

    static Scanner sc = new Scanner(System.in);
    static int[]w;
    static int n,m;
    static double ans = 1e8;
    static void swap(int a, int b) {
        int t = w[a];
        w[a] = w[b];
        w[b] = t;
    }

    static double calc(){
        int[] s = new int[m];
        for(int i = 0; i <n; i++) {
            int k = 0;
            for(int j = 0; j <m; j++) {
              if (s[j]<s[k]){
                  k = j;
              }
            }
            s[k]+=w[i];
        }
        double avg = 0,res = 0;
        for(int i = 0; i <m; i++) {
          avg+=(double) (s[i]/m);
          res+=(s[i]-avg)*(s[i]-avg);
        }
        res = Math.sqrt(res/m);
        ans = Math.min(ans,res);
        return res;
    }


    static void sa() {
        Collections.shuffle(Collections.singletonList(w));
//        shuffle(w);
        for (double t = 1e6; t > 1e-6; t *= 0.95)
        {
            int a = (int) (Math.random() * n), b = (int) (Math.random() * n);
            double x = calc();
            swap(a, b);
            double y = calc();
            double d = y - x;
            if (Math.pow(Math.E,-d/ t) < Math.random())
                swap(a,b);
        }
    }
//    public static void shuffle(int[] arr) {
//        for (int i = 0, len = arr.length; i < len; i++) {
//            int rand = (int) (Math.random() * len);
//            int temp = arr[i];
//            arr[i] = arr[rand];
//            arr[rand] = temp;
//        }
//    }
    public static void main(String[] args) {
        n = sc.nextInt();m = sc.nextInt();
        w = new int[n];
        for(int i = 0; i <n; i++) {
          w[i] = sc.nextInt();
        }
        for(int i = 0; i <100; i++) {
          sa();
        }
        System.out.printf("%.2f\n",ans);
    }

}
