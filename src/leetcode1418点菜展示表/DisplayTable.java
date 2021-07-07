package leetcode1418点菜展示表;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class DisplayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        //整张逻辑表 桌号：菜名：个数
        Map<Integer,Map<String,Integer>> map = new TreeMap<>();
        Set<String> ts = new HashSet<>();
        for (List<String> x: orders){
            String hao = x.get(1);
            String cai = x.get(2);
            ts.add(cai);
            Map<String,Integer> temp = map.getOrDefault(Integer.valueOf(hao),new HashMap<>());
            temp.put(cai, temp.getOrDefault(cai,0)+1);
            map.put(Integer.valueOf(hao),temp);
        }
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(ts);
        for (int x: map.keySet()){
            Map<String,Integer> temp = map.get(x);
            List<String> cur = new ArrayList<>();
            cur.add(String.valueOf(x));
            for (String cai:ts){
                cur.add(temp.getOrDefault(cai,0)+"");
            }
            res.add(cur);
        }
        return res;

    }


}
