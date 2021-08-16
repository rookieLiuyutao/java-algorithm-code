package ccf201509_1数列分段;

import java.util.Scanner;

public class SequenceSegmentation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int t = -1;
        int count = 1;
        for(int i = 0; i <n; i++) {
          int x = sc.nextInt();
          if (x!=t){
              count++;
              t = x;
          }
        }
        System.out.println(count);
    }

}
