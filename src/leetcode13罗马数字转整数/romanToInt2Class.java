package leetcode13罗马数字转整数;

import java.util.Arrays;


public class romanToInt2Class {
    class roman{
        char romanNum;
        int intVal;
        roman(char romanNum,int intVal){
            this.intVal = intVal;
            this.romanNum = romanNum;
        }
    }

    public int romanToInt(String s) {
        roman [] roman = new roman[7];
        int [] intNum = {1000,500,100,50,10,5,1};
        char[] romanC = {'M','D','C','M','X','V','I'};
        for(int i = 0; i <7; i++) {
          roman[i] = new roman(romanC[i],intNum[i]);
        }
        int res = 0;
        System.out.println(Arrays.toString(roman));
        int m = s.length();
        char[] sb = s.toCharArray();
        for (int i = 1; i < m; i++) {
            if (sb[i-1] < roman[i].romanNum) {
                res -= roman[i-1].romanNum;
            } else {
                res += roman[i-1].romanNum;
            }
        }
        res += roman[6].romanNum;
        return res;
    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new romanToInt2Class().romanToInt(s));
    }


}
