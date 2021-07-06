package leetcode726原子的数量;

import java.util.Map;
import java.util.TreeMap;

/**
 * @see dfs 表达式处理 https://leetcode-cn.com/problems/number-of-atoms/
 */
public class CountOfAtoms {
    int u = 0;
    public Map<String, Integer> dfs(String formula) {
        Map<String, Integer> res = new TreeMap<>();
        while (u < formula.length()) {
            Map<String, Integer> temp;
            if (formula.charAt(u) == '(') {
                u++;
                //把答案填进去
                temp = dfs(formula);
                u++;
                //处理括号后的角标
                int coefficient = 1;
                int k = u;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) {
                    k++;
                }
                if (k > u) {
                    coefficient = Integer.parseInt(formula.substring(u,k));
                    u=k;
                }
                for (String key : temp.keySet()) {
                    res.put(key, res.getOrDefault(key, 0) + coefficient * temp.get(key));
                }
            } else if (formula.charAt(u) == ')') {
                break;
            } else {
                //处理元素
                int k = u+1;
                while (k<formula.length()&&formula.charAt(k) >= 'a' && formula.charAt(k) <= 'z') {
                    k++;
                }
                String element = formula.substring(u,k);
                 u =k;
                //处理括号内的角标
                int angleMark = 1;
                while (k<formula.length()&&Character.isDigit(formula.charAt(k))) {
                    k++;
                }
                if (k > u) {
                    angleMark = Integer.parseInt(formula.substring(u, k));
                    u = k;
                }
                res.put(element, res.getOrDefault(element, 0) + angleMark);
            }
        }
        return res;
    }

    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        Map<String, Integer> res = dfs(formula);
        for (String key : res.keySet()) {
            ans.append(key);
            if (res.get(key) > 1) {
                ans.append(res.get(key));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "Ba3(PO4)2";
        System.out.println(new CountOfAtoms().countOfAtoms(str));
    }
}
