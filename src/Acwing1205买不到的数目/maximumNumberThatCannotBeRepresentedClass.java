package Acwing1205买不到的数目;

/**
 * @see 数学问题 https://www.acwing.com/problem/content/1207/
 * @see 数论：px+py 不能表示的最大数为pq-p-q的证明 https://www.cnblogs.com/Yuzao/p/7074465.html
 */
import java.util.*;
public class maximumNumberThatCannotBeRepresentedClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println((p-1)*(q-1)-1);
    }
}
