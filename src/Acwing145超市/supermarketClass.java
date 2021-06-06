package Acwing145超市;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @see 堆 优先级队列 https://www.acwing.com/problem/content/147/
 */
public class supermarketClass {
    static class Good{
        private int profit ;
        private int expireDate;

        public Good(int profit, int expireDate) {
            this.profit = profit;
            this.expireDate = expireDate;
        }
    }


    public static void main(String[] args) throws Exception {
        PriorityQueue<Good> goods = new PriorityQueue<>((o1, o2) -> o1.profit==o2.profit? (o1.expireDate- o2.profit):-(o1.profit-o2.profit));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int temp = n;
            int maxProfit = 0;
            int globalDay = 0;
            while (temp-- > 0) {
                int pr = sc.nextInt();
                int date = sc.nextInt();
               goods.add(new Good(pr,date));
            }
            for (Good x:goods){
                System.out.print("["+x.profit+" "+x.expireDate+"]");
            }
            while (n-- > 0) {
                int day = goods.peek().expireDate;
                if (day>=globalDay) {
                    int y = goods.poll().profit;
                    System.out.println(y);
                    maxProfit+= y;
                }
                globalDay++;
            }


            System.out.println(maxProfit);
        }


    }

}
