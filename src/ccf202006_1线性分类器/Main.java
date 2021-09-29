package ccf202006_1线性分类器;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3290/
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int x, y, c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int c = sc.next().charAt(0) - 'A';
            arr[i] = new Node(x, y, c);
        }
        int up = -1, down = -1;
        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int i = 0;
            for (; i < n; i++) {
                long val = a + (long) b * arr[i].x + (long) c * arr[i].y;
                int type = arr[i].c;
                if (val > 0) {
                    if (up == -1) {
                        up = type;
                    } else {
                        if (up != type) {
                            break;
                        }
                    }
                } else {
                    if (down == -1) {
                        down = type;
                    } else {
                        if (down != type) {
                            break;
                        }
                    }
                }
            }
            if (i == n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
