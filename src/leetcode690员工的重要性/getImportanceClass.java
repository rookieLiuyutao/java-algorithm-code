package leetcode690员工的重要性;

/**
 * @see 递归 https://leetcode-cn.com/problems/employee-importance/
 */

import java.util.HashMap;
import java.util.List;

public class getImportanceClass {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    static HashMap<Integer, Employee> map = new HashMap<>();

    /**
     *为什么想到用哈希表：节点中的属性不是指针，要想办法转化成指针
     * 哈希表的value用的是链表和红黑树的结构，正好把id映射为指针
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    /**
     * 为什么想到用dfs：因为Employee类的结构很像树的节点结构，很像
     * @see 938二叉搜索树的范围和 https://leetcode-cn.com/problems/range-sum-of-bst/
     * 都是遍历求和，不同点是该题节点中的属性不是指针，要想办法转化成指针
     * @param id 当前遍历的id
     * @return
     */

    public static int dfs(int id) {
        Employee master = map.get(id);
        int res = master.importance;
        for (int subordinate : master.subordinates) {
            Employee other = map.get(subordinate);
            res += other.importance;
            for (int sub : other.subordinates) {
                res += dfs(sub);
            }
        }
        return res;
    }

}
