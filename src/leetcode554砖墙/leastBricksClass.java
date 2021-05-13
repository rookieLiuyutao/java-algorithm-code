package leetcode554砖墙;

/**
 * @see 哈希表 https://leetcode-cn.com/problems/brick-wall/
 */

import java.util.*;

public class leastBricksClass {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

//-----------------------用哈希表统计二维集合中元素个数----------------------
        for (List<Integer> width : wall) {
            int sum = 0;
            int n  = width.size();
            for (int i = 0; i < n - 1; i++) {
                sum += width.get(i);
//-----------------------------------------------------------------
                map.put(sum,map.getOrDefault(sum,0)+1);
//-----------------------------------------------------------------
            }
        }
//-----------------------------------------------------------------------

        int maxCount = 0;

//----------------------遍历哈希表---------------------------------
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxCount = Math.max(maxCount,entry.getValue());
        }
//----------------------------------------------------------------
        return wall.size()-maxCount;
    }

}
