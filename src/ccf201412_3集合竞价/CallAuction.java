package ccf201412_3集合竞价;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3212/
 */
public class CallAuction {

    static class Stock {
        int type;
        double price;
        long count;
        boolean isRevoked;

        public Stock(int type, double price, long count, boolean isRevoked) {
            this.type = type;
            this.price = price;
            this.count = count;
            this.isRevoked = isRevoked;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Stock> list = new ArrayList<>();
    static ArrayList<Stock> listBuy = new ArrayList<>();
    static ArrayList<Stock> listSell = new ArrayList<>();

    public static void main(String[] args) {
        list.add(null);
        while (sc.hasNext()) {
            String type = sc.next();
            if ("end".equals(type)) {
                break;
            }
            if ("buy".equals(type)) {
                list.add(new Stock(1, sc.nextDouble(), sc.nextLong(), false));
            } else if ("sell".equals(type)) {
                list.add(new Stock(2, sc.nextDouble(), sc.nextLong(), false));
            } else if ("cancel".equals(type)) {
                list.add(null);
                int x = sc.nextInt();
                list.get(x).isRevoked = true;
            }
        }

        for (Stock x : list) {
            if (x != null && !x.isRevoked && x.type == 1) {
                listBuy.add(x);
            } else if (x != null && !x.isRevoked && x.type == 2) {
                listSell.add(x);
            }
        }
        listBuy.sort(Comparator.comparingDouble(o -> -o.price));
        listSell.sort(Comparator.comparingDouble(o -> o.price));
        long[] sumB = new long[listBuy.size() + 1];
        long[] sumS = new long[listSell.size() + 1];
        for (int i = 1; i <= listSell.size(); i++) {
            sumS[i] = sumS[i - 1] + listSell.get(i - 1).count;
        }
        for (int i = 1; i < listBuy.size(); i++) {
            sumB[i] = sumB[i - 1] + listBuy.get(i - 1).count;
        }

        long res = 0;
        double sp = 0;
        for (int i = 0; i < listBuy.size(); i++) {
            double p = listBuy.get(i).price;
            long cB = sumB[i + 1] - sumB[0];
            for (int j = listSell.size() - 1; j >= 0; j--) {
                if (listSell.get(j).price <= p) {
                    long cS = sumS[j + 1] - sumS[0];
                    long t = Math.min(cS, cB);
                    if (t > res || t == res && p > sp) {
                        sp = p;
                        res = t;
                    }
                    break;
                }
            }
        }

        System.out.printf("%.2f %d", sp, res);
    }
}
