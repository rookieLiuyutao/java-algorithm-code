package ccf202009_2风险人群筛查;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/3296/
 */
public class AtRiskPopulationScreening {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args)throws Exception {
        int n = nextInt(),k = nextInt(),t = nextInt(),xl = nextInt(),yd = nextInt(),xr = nextInt(),yu = nextInt();
        int cntS = 0,cntP = 0;
        while (n-->0){
            boolean isPass = false;
            int sTime = 0,maxSt = 0;
            for(int i = 0; i <t; i++) {
                int x = nextInt(),y = nextInt();
                if (x >= xl && x <= xr && y >= yd && y <= yu) {
                    sTime++;
                    isPass = true;
                }else {
                    maxSt = Math.max(sTime,maxSt);
                    sTime = 0;
                }
                maxSt = Math.max(sTime,maxSt);
            }
            if (maxSt>=k){
                cntS++;
            }
            if (isPass) {
                cntP++;
            }
        }
        System.out.println(cntP);
        System.out.println(cntS);
    }


}
