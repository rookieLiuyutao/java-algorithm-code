package leetcode263丑数;

public class isUglyClass {
    public static boolean isUgly(int n) {
        if (n<=0) {
            return false;
        }
        while (n % 2 == 0 || n % 5 == 0 || n % 3 == 0) {
            if (n%3==0){
                n/=3;
            } else if(n%2==0){
                n/=2;
            }else {
                n/=5;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n=27;
        System.out.println(isUgly(n));
    }
}
