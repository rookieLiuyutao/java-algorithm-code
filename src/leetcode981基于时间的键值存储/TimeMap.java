package leetcode981基于时间的键值存储;

import java.util.*;

/**
 * 哈希表
 * https://leetcode-cn.com/problems/time-based-key-value-store/
 */
public class TimeMap {
    static class Point{
        String value;
        int time;

        public Point(String value, int t) {
            this.value = value;
            this.time = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return time == point.time && Objects.equals(value, point.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, time);
        }
    }

    Map<String, List<Point>> map;
    public TimeMap() {
         map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Point> temp = map.getOrDefault(key,new ArrayList<Point>());
        temp.add(new Point(value, timestamp));
        map.put(key,temp);
    }

    public String get(String key, int timestamp) {
        List<Point> points = map.getOrDefault(key,new ArrayList<>());
        if (points.isEmpty()){
            return "";
        }
        int n = points.size();
        int l = 0,r = n-1;
        while (l < r) {
            int mid = l+r+1>>1;
            if (points.get(mid).time <=timestamp){
                l = mid;
            }else {
                r = mid-1;
            }
        }
        return points.get(l).time<=timestamp?points.get(l).value:"";
    }
}
