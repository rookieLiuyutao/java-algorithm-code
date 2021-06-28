package leetcode957N天后的牢房;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see 循环结 https://leetcode-cn.com/problems/prison-cells-after-n-days/
 */
public class PrisonAfterNDaysClass {
    /**
     * 计算当前这一天的下一天的十进制状态
     * @param state
     * @return
     */
    int get(int state){
        int res = 0;
        for (int i=7;i>=0;i--){
            res<<=1;
            if (i > 0 && i < 7) {
                if ((state>>i-1&1)==(state>>i+1&1)){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 把十进制状态转化为二进制数组
     * @param state
     * @return
     */
    int [] outPut(int state){
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 7; i >=0; i--) {
          list.add(state>>i&1);
        }
        int []  res = new int[list.size()];
        for(int i = 0; i <list.size(); i++) {
          res[i] = list.get(i);
        }
        return res;
    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        //先把cells数组中的0，1压缩为一个10进制数
        int state = 0;
        for (int i : cells) {
            state = state*2+i;
        }
        //记录这256天中，哪一天出现了循环节
        int [] isHappened = new int[256];
        //初始化为-1代表没有出现过
        Arrays.fill(isHappened,-1);
        isHappened[state] = 0;
        //模拟每一天
        for(int i = 1; n>0; i++) {
          int next = get(state);
          n--;
            if (isHappened[next] != -1) {
                n%=i-isHappened[next];
            }else {
                isHappened[next] = i;
            }
            state = next;
        }
        return outPut(state);
    }

}
