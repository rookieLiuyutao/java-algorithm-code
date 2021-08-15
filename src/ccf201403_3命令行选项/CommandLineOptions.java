package ccf201403_3命令行选项;

import java.util.*;

public class CommandLineOptions {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String ss = sc.next();

        HashSet<String> p = new HashSet<>();
        for (int i = 0; i < ss.length(); i++) {
            if (i != ss.length() - 1 && ss.charAt(i + 1) == ':') {
                p.add(ss.substring(i, i + 2));
                i++;
            } else {
                p.add(ss.substring(i, i + 1));
            }
        }
//        System.out.println(p);
        int n = sc.nextInt();
        sc.nextLine();
//        System.out.println(n);
        for (int j = 1; j <= n; j++) {
            String op = sc.nextLine();
//            System.out.println(op);
            Map<String, String> map = new TreeMap<>();
            String[] com = op.split(" ");
//            System.out.println(Arrays.toString(com));
            for (int i = 1; i < com.length; i++) {
                if (com[i].charAt(0) != '-' || com[i].charAt(1) < 'a' || com[i].length() != 2) {
                    break;
                }
                if (i + 1 < com.length && p.contains(com[i].charAt(1) + ":")) {
                    map.put(com[i].substring(0, 2), com[i+1]);
                    i++;
                } else if (p.contains(com[i].charAt(1) + "")) {
                    map.put(com[i], "!");
                } else {
                    break;
                }
            }
            StringBuilder res = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!"!".equals(entry.getValue())) {
                    res.append(entry.getKey()).append(" ").append(entry.getValue()).append(" ");
                } else {
                    res.append(entry.getKey()).append(" ");
                }
            }
            System.out.println("Case " + j + ": " + res);
        }
    }

}
