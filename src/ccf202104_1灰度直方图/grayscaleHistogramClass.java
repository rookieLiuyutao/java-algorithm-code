package ccf202104_1灰度直方图;
/**
 * @see 灰度直方图 http://118.190.20.162/view.page?gpid=T128  https://www.acwing.com/problem/content/3414/
 */

import java.util.*;

public class grayscaleHistogramClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int L = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
//---------------------用hashMap对二维数组的每个变量进行个数统计
//                int count = 1;
//                if (map.containsKey(arr[i][j])) {
//                    count += map.get(arr[i][j]);
//                    map.put(arr[i][j], count);
//                } else {
//                    map.put(arr[i][j], count);
//                }
                map.put(arr[i][j], map.getOrDefault(arr[i][j],0)+1);
//-----------------------------------------------
            }
        }

        int []ans = new int[L];
        //将map里面的值拿出来，因为map里都是对象类型，所以要用相应的ArrayList存储
        ArrayList<Integer> keyArr = new ArrayList<Integer>(map.keySet());
        ArrayList<Integer> valueArr = new ArrayList<Integer>(map.values());
        //此处注意循环时i的取值范围，要和hash里面的数据范围对应
        for (int i = 0; i < keyArr.size(); i++) {
            ans[keyArr.get(i)] = valueArr.get(i);
        }
        for (int i = 0; i < L; i++) {
            System.out.print(ans[i]+" ");
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey());
        }
//        System.out.println(map.keySet().toArray()[0]);

    }
}
