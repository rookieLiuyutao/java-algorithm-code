package leetcode5840使字符串平衡的最小交换次数;

public class MinSwaps {

    public int minSwaps(String s) {
        int count = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    count = 0;
                    res++;
                }
            }
        }
        return (res + 1) / 2;
    }

}
