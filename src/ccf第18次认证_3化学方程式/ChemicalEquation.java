package ccf第18次认证_3化学方程式;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @see dfs 表达式处理 https://www.acwing.com/problem/content/description/3287/
 */
public class ChemicalEquation {

    static Scanner sc = new Scanner(System.in);
    static int u;
    static Map<String, Integer> map = new HashMap<>();

    static Map<String, Integer> dfs(String formula) {
        Map<String, Integer> res = new HashMap<>();
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


    public static Map<String, Integer> work(String ss) {
        Map<String,Integer> res = new HashMap<>();
        //双指针算法分割出+左右的每个化学式
        for (int i = 0; i < ss.length(); i++) {
            int j = i + 1;
            while (j < ss.length() && ss.charAt(j) != '+') {
                j++;
            }
            String formula = ss.substring(i, j);
            i = j;
            //处理每个化学式前的系数
            int coefficient = 1,k = 0;
            while (k<formula.length()&&Character.isDigit(formula.charAt(k))){
                k++;

            }
            if (k>0){
                coefficient = Integer.parseInt(formula.substring(0,k));
            }
            Map<String ,Integer> sign = dfs(formula.substring(k));
            u = 0;
            for (String key:sign.keySet()){
                res.put(key,res.getOrDefault(key,0)+coefficient*sign.get(key));
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        while (n-- > 0) {
           String equation = sc.next();
            int k = 0;

            for (int i = 0; i < equation.length(); i++) {
                if (equation.charAt(i) == '=') {
                    k = i;
                    break;
                }
            }
            Map<String, Integer> left = work(equation.substring(0, k));
            Map<String, Integer> right = work(equation.substring(k + 1));
            //比较两个Map是否完全相等用Map中重写后的equals方法
            //equals一般可以比较两个对象是否完全相等
            //== 一般比较两个变量是否完全相等
            if (left.equals(right)) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }


}
