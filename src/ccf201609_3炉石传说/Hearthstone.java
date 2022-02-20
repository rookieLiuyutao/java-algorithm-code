package ccf201609_3炉石传说;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3237/
 * 模拟
 */
public class Hearthstone {
    static final int N = 1005;
    static int n;
    static Scanner sc = new Scanner(System.in);

    static class Hero {
        int health, attackPower;

        public Hero(int health, int attackPower) {
            this.health = health;
            this.attackPower = attackPower;
        }

        public Hero() {
        }
    }

    static Hero[][] p = new Hero[2][10];

    static void remove(int k, int a) {
        for (int i = a; i > 0; i--) {
            p[k][i].attackPower = p[k][i + 1].attackPower;
            p[k][i].health = p[k][i + 1].health;
        }
        p[k][7]= new Hero(0,0);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                p[i][j] = new Hero(0, 0);
            }
        }
        p[0][0].health = 30;
        p[1][0].health = 30;
        n = sc.nextInt();
        int who = 0;
        while (n-- > 0) {
            String op = sc.next();
            if ("end".equals(op)) {
                who ^= 1;
            } else if ("summon".equals(op)) {
                int pos = sc.nextInt(), a = sc.nextInt(), h = sc.nextInt();
                System.arraycopy(p[who], 0, p[who], 1, 7);
                p[who][pos] = new Hero(a, h);
            } else {
                int a = sc.nextInt(), d = sc.nextInt();
                p[who][a].health -= p[who ^ 1][d].attackPower;
                p[who^1][d].health -= p[who ^ 1][a].attackPower;
                if (a != 0 && p[who][a].health <= 0) {
                    remove(who, a);
                }
                if (d != 0 && p[who][d].health <= 0) {
                    remove(who ^ 1, d);
                }
            }
        }
        if (p[0][0].health <= 0) {
            System.out.println(-1);
        } else if (p[1][0].health <= 0) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(p[i][0].health);
            int s = 0;
            for (int j = 1; j <= 7; j++) {
                if (p[i][j].health > 0) {
                    s++;
                }
            }
            System.out.println(s);
            for (int j = 1; j <= s; j++) {
                System.out.print(p[i][j].health + " ");
            }
            System.out.println();
        }
    }

}
