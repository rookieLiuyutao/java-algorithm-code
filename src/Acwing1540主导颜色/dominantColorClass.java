package Acwing1540主导颜色;

/**
 * @see 哈希表 https://www.acwing.com/problem/content/description/1542/
 */
import java.util.*;
public class dominantColorClass {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] arr = new int[n][m];
        int maxCount = 0;
        int max = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);
                int x= map.get(arr[i][j]);
                if (x>maxCount){
                    maxCount = x;
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);


    }

}
