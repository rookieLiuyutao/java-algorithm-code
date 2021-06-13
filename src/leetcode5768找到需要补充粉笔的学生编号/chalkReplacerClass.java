package leetcode5768找到需要补充粉笔的学生编号;

import java.util.Arrays;

/**
 * @see 环形优化模拟 https://leetcode-cn.com/contest/biweekly-contest-54/problems/find-the-student-that-will-replace-the-chalk/
 */
public class chalkReplacerClass {
    /**
     * 优化模拟思路 ：因为只需要知道最后停在环形的哪个位置，所以只需要枚举最后一圈。
     * 可以先求出一圈的数字和，用k取余，就得到了最后一圈
     * @param chalk
     * @param k
     * @return
     */
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        for (int x:chalk){
            sum+=x;
        }
        k %= sum;
        for (int i = 0; i < n; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        System.out.println(sum);
        return -1;
    }
}
