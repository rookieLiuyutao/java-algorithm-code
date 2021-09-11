package Acwing1107魔板;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/1109/
 */
public class MagicBoard {

    static class Pair{
        char c;
        String s;

        public Pair(char c, String s) {
            this.c = c;
            this.s = s;
        }
    }
    static Scanner sc = new Scanner(System.in);
    static HashMap<String,Pair> pr = new HashMap<>();
    static HashMap<String,Integer> dist = new HashMap<>();
    static String start,end;

    static void bfs(){
        ArrayDeque<String>q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()){
            String t = q.poll();
            if (t.equals(end)){
                return;
            }
            StringBuilder u = new StringBuilder(t);
            String[]save = new String[3];
            save[0] = String.valueOf(u.reverse());
            save[1] = t.charAt(3)+t.substring(0,3)+t.substring(5)+t.charAt(4);
            char[]temp = t.toCharArray();
            temp[1] = t.charAt(6);
            temp[2] = t.charAt(1);
            temp[5] = t.charAt(2);
            temp[6] = t.charAt(5);
            save[2] = String.valueOf(temp);
//            System.out.println(Arrays.toString(save));
            for(int i = 0; i <3; i++) {
                if (!dist.containsKey(save[i])||dist.get(save[i]) == 0) {
                    dist.put(save[i], dist.getOrDefault(t,0)+1);
                    pr.put(save[i],new Pair((char) (i+'A'),t));
                    if (save[i].equals(end)){
                        break;
                    }
                    q.add(save[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        start = "12345678";
        char[]p = new char[8];
        for(int i = 0; i <8; i++) {
          p[i] = (char) (sc.nextInt()+'0');
        }
        end = String.valueOf(p);
//        System.out.println(end);
        bfs();
        System.out.println(dist.get(end)==null?0:dist.get(end));
        StringBuilder res = new StringBuilder();
        if (dist.containsKey(end) && dist.get(end) != 0) {
            while (!end.equals(start)){
                res.append(pr.get(end).c);
                end = pr.get(end).s;
            }
        }
        if (res.length()==0){
            System.out.println(res.reverse());
        }
    }
}
