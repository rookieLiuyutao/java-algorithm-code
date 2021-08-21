package ccf201509_3模板生成系统;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3222/
 */
public class TemplateGenerationSystem {

    static Scanner sc = new Scanner(System.in);
    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        String[] ss = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            ss[i] = sc.nextLine();
        }
        for (int i = 0; i < m; i++) {
            String change = sc.nextLine();
            String[] cc = change.split(" ", 2);
            cc[1] = cc[1].substring(1, cc[1].length() - 1);
            map.put(cc[0], cc[1]);
        }
        System.out.println(map.keySet());
        for (int r = 0; r < n; r++) {
            for (int i = 0; i < ss[r].length(); ) {
                if (i + 1 < ss[r].length() && ss[r].charAt(i) == '{' && ss[r].charAt(i + 1) == '{') {
                    int j = i+3;
                    StringBuilder key = new StringBuilder();
                    while (ss[r].charAt(j)!=' '||ss[r].charAt(j+1)!='}'||ss[r].charAt(j+2)!='}') {
                        key.append(ss[r].charAt(j++));
                    }
                    System.out.println(map.getOrDefault(key.toString(), ""));
                    i=j+3;

                }else {
                    System.out.print(ss[r].charAt(i++));
                }
            }
            System.out.println();
        }
    }
}
