package leetcode5814新增的最少台阶数;

public class Main {

    public int addRungs(int[] rungs, int dist) {
        int n = rungs.length;
        int res = 0;
        int x = rungs[0];
        if (dist==1){
            res = rungs[n-1]-n;
            return res;
        }
        if (n == 1) {
            if (x > dist) {
                int num = x/dist;
                x-=num*dist;
                res+=num;
                if (x % dist == 0) {
                    res--;
                }
            }
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (x > dist) {
                int num = x/dist;
                x-=num*dist;
                res+=num;
                if (x % dist == 0) {
                    res--;
                }
            }
            if (i > 0 && i < n && rungs[i] - rungs[i - 1] <= dist) {
                continue;
            }
            if (i > 0 && rungs[i] > rungs[i - 1] + dist) {
                res+=(rungs[i]-rungs[i-1])/dist;
                if ((rungs[i]-rungs[i-1])%dist==0){
                    res--;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {12,24};
        System.out.println(new Main().addRungs(a, 4));
    }
}
