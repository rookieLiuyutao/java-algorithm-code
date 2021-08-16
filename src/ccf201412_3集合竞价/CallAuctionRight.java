package ccf201412_3集合竞价;

import java.util.ArrayList;
import java.util.Scanner;

public class CallAuctionRight {
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
        double resp = 0;
        long ress = 0;
        for (int i = 1; i < list.size(); i ++ ) {
            if (list.get(i)!=null&&!list.get(i).isRevoked)
            {
                double p = list.get(i).price;
                long s1 = 0, s2 = 0;
                for (int j = 1; j < list.size(); j ++ ) {
                    if (list.get(j)!=null&&!list.get(j).isRevoked) {
                        if (list.get(j).type == 1 && list.get(j).price >= p) {
                            s1 += list.get(j).count;
                        } else if (list.get(j).type == 2 && list.get(j).price <= p) {
                            s2 += list.get(j).count;
                        }
                    }
                }
                long t = Math.min(s1, s2);
                if (t > ress || t == ress && p > resp) {
                    resp = p;
                    ress = t;
                }
            }
        }


        System.out.printf("%.2f %d", resp, ress);
    }
}
