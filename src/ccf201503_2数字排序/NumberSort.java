package ccf201503_2数字排序;

import java.util.*;

public class NumberSort {

    static Scanner sc = new Scanner(System.in);
    static int[] a = new int[1010];
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<List<Integer>>list =  new ArrayList<>();
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            list.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        list.sort((o1, o2) -> o1.get(0).equals(o2.get(0)) ? o1.get(0)- o2.get(0) : (o2.get(1)-o1.get(1)));
        for(List x:list){
            System.out.println(x.get(0)+" "+x.get(1));
        }
    }

}
