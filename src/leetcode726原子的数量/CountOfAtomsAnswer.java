package leetcode726原子的数量;

import java.util.Map;
import java.util.TreeMap;

public class CountOfAtomsAnswer {
    int u;
    public Map<String, Integer> dfs(String formula) {
        Map<String, Integer> ans = new TreeMap<>();
        while (u < formula.length()) {
            if (formula.charAt(u) == '(') {
                u++;
                Map<String, Integer> cur = dfs(formula);
                u++;
                int cnt = 1;
                if (u < formula.length() && Character.isDigit(formula.charAt(u))) {
                    int k = u;
                    while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                    cnt = Integer.parseInt(formula.substring(u, k));
                    u = k;
                }
                for (String key : cur.keySet()) ans.put(key, ans.getOrDefault(key, 0) + cnt * cur.get(key));
            } else if (formula.charAt(u) == ')') {
                break;
            } else {
                int k = u;
                while (k + 1 < formula.length() && formula.charAt(k + 1) >= 'a' && formula.charAt(k + 1) <= 'z') k++;
                String key = formula.substring(u, k + 1);
                u = k + 1;
                int cnt = 1;
                if (u < formula.length() && Character.isDigit(formula.charAt(u))) {
                    k = u;
                    while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                    cnt = Integer.parseInt(formula.substring(u, k));
                    u = k;
                }
                ans.put(key, ans.getOrDefault(key, 0) + cnt);
            }
        }
        return ans;
    }

    public String countOfAtoms(String formula) {
        String ans = "";
        u = 0;
        Map<String, Integer> map = dfs(formula);
        for (String key : map.keySet()) {
            ans += key;
            if (map.get(key) > 1) ans += map.get(key);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "Mg(OH)2";
        System.out.println(new CountOfAtomsAnswer().countOfAtoms(str));
    }

}
