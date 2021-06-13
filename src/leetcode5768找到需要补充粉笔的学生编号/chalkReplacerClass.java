package leetcode5768找到需要补充粉笔的学生编号;

/**
 * @see https://leetcode-cn.com/contest/biweekly-contest-54/problems/find-the-student-that-will-replace-the-chalk/
 */
public class chalkReplacerClass {

        public int chalkReplacer(int[] chalk, int k) {
            int n = chalk.length;
            int i=0;
            while (k >= 0) {
                k-=chalk[(i%n)];
                i++;
            }
            return i%n;


        }
}
