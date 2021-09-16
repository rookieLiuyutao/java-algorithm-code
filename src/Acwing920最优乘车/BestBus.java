package Acwing920最优乘车;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/922/
 */
public class BestBus {

    static Scanner sc = new Scanner(System.in);
    static final int N = 105, INF = 0x3f3f3f3f;
    static int n, m;
    static boolean [][] g = new boolean[N][N];
    static int[] dis = new int[N];

    static void bfs() {
        Arrays.fill(dis, INF);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dis[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = 1; i <= n; i++) {
                if (g[t][i] && dis[i] > dis[t] + 1) {
                    dis[i] = dis[t] + 1;
                    q.add(i);
                }
            }
        }
    }


    public static void main(String[] args) {
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        while (m-- > 0) {
            String s = sc.nextLine();
            String[] road = s.split(" ");
//            System.out.println(Arrays.toString(road));
            int[] line = new int[road.length];
            for (int i = 0; i < road.length; i++) {
                line[i] = Integer.parseInt(road[i]);
            }
//            System.out.println(Arrays.toString(line));
            for (int i = 0; i < road.length; i++) {
                for (int j = i + 1; j < road.length; j++) {
                    g[line[i]][line[j]] = true;
                }
            }
        }
        bfs();
        System.out.println(Arrays.toString(dis));
        if (dis[n] == INF) {
            System.out.println("NO");
        } else {
            System.out.println(dis[n]-1);
        }
    }

}
