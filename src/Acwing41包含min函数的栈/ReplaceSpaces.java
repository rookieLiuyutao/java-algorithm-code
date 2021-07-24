package Acwing41包含min函数的栈;

public class ReplaceSpaces {

    public String replaceSpaces(StringBuffer str) {
        int n = str.length();
        StringBuilder res = new StringBuilder();
        int i = 0,j = 0;
        for( ;i <n; i++) {
            if (str.charAt(i)==' '){
                res.append(str.substring(j,i)).append("%20");
                j = i+1;
            }
        }
        res.append(str.substring(j,n));
        return res.toString();
    }


}
