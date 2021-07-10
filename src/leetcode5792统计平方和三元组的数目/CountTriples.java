package leetcode5792统计平方和三元组的数目;

public class CountTriples {

    public int countTriples(int n) {
        int count = 0;
        for(int a = 1; a <=n; a++) {
          for(int b =1 ; b <=n; b++) {
            for(int c = 1; c <=n; c++) {
              int x = a*a+b*b;
              if (x ==c*c){
                  count++;
              }
            }
          }
        }
        return count;
    }
}
