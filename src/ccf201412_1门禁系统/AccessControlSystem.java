package ccf201412_1门禁系统;

import java.util.Scanner;

public class AccessControlSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i = 0; i <n; i++) {
            a[i] = sc.nextInt();
            int count = 1;
            for(int j = 0; j <i; j++) {
                if (a[j]==a[i]){
                    count++;
                }
            }
            System.out.print(count);
        }
    }

}
