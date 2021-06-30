package leetcode168Excel表列名称;

import java.util.ArrayList;

/**
 * @see 位运算 https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class ConvertToTitle {



    public String convertToTitle(int columnNumber) {
        StringBuilder ss = new StringBuilder();
        int temp = columnNumber;
        while (temp > 0) {
            int x = (temp-1)%26;
            ss.append((char) (x + 'A'));
            temp/=26;
        }

    return ss.reverse().toString();
    }

}
