package leetcode12整数转罗马数字;

/**
 * @see 贪心 https://leetcode-cn.com/problems/integer-to-roman/
 */
public class intToRomanClass {
    public String intToRoman(int num) {
        int [] intNum = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i <13; i++) {
          while (num>=intNum[i]){
              sb.append(roman[i]);
              num-=intNum[i];
          }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new intToRomanClass().intToRoman(28));
    }

}
