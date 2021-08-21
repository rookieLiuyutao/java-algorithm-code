package ccf201609_3炉石传说;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3237/
 * 模拟
 */
public class Hearthstone {
    static Scanner sc = new Scanner(System.in);
    static class Hero{
        int position = 0,health = 30,attackPower = 0;

        public Hero(int position, int health, int attackPower) {
            this.position = position;
            this.health = health;
            this.attackPower = attackPower;
        }

        public static void main(String[] args) {
            int n = sc.nextInt();
            while (n-- > 0) {
                String[]sp = sc.nextLine().split(" ");
                if ("summon".equals(sp[0])){
                    
                }
            }
        }
    }

}
