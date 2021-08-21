package ccf201604_3路径解析;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3232/
 */
public class PathResolution {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String> get(String p) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '/') {
                continue;
            }
            int t = i + 1;
            while (t < p.length() && p.charAt(t) != '/') {
                t++;
            }
            res.add(p.substring(i, t));
            i = t;
        }
        return res;
    }

    static void walk(ArrayList<String> str, ArrayList<String> path) {
        for (String p : path) {
            if (".".equals(p)) {
                continue;
            }
            if ("..".equals(p)) {
                if (!str.isEmpty()) {
                    str.remove(str.size() - 1);
                }
            } else {
                str.add(p);
            }
        }
        if (str.isEmpty()) {
            System.out.println("/");
            return;
        }
        for (String p : str) {
            System.out.print("/" + p);
        }
        System.out.println();
        path.clear();//一定要注意每次调用完清空
        str.clear();
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        String p = sc.nextLine();
        ArrayList<String> ap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ss = sc.nextLine();
            ;

            if (ss.length() != 0 && ss.charAt(0) == '/') {
                walk(ap, get(ss));
            } else {
                walk(get(p), get(ss));
            }
        }
    }

}
