package leetcode91解码方法;

public class numDecodingsClass {
        public static int numDecodings(String s) {
            int n = s.length();
            int[] dp  = new int[n+1];
            dp[0] = 1;
            s=" "+ s;
            char[] sb = s.toCharArray();
            for (int i = 1; i <= n; i++) {
                if (sb[i] >='1'&&sb[i]<='9'){
                    dp[i]+=dp[i-1];
                }
                if (i>1){
                    int t = (sb[i-1]-'0')*10+(sb[i]-'0');
                    if (t>=10&&t<=26){
                        dp[i] +=dp[i-2];
                    }
                }
            }
            return dp[n];
        }

    public static void main(String[] args) {
        String s = "123450563208";
        System.out.println(numDecodings(s));
    }

}
