package leecode5773插入后的最大值;

public class maxValueClass {
    public String maxValue(String n, int x) {
        StringBuffer sb = new StringBuffer(n);
        int m = n.length();
        if (n.charAt(0)=='-'){
            int i = 1;
            while (i<m&&x>=Integer.parseInt(String.valueOf(n.charAt(i)))){
                i++;
            }
            sb.insert(i,x);
        }else {
            int j=0;
            while (j<m&&x<=Integer.parseInt(String.valueOf(n.charAt(j)))){
                j++;
            }
            sb.insert(j,x);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "99";
        System.out.println(new maxValueClass().maxValue(s,9));
    }
}
