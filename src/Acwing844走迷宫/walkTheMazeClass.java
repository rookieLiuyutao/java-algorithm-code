package Acwing844走迷宫;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @see 广搜
 */
public class walkTheMazeClass {
    static final int N = 110;
    //maze存放迷宫的地图，distance表示地图上每个点到起点的距离
    static int[][] maze = new int[N][N],distance  =new int[N][N];
    static int m,n;
    static Queue<AbstractMap.SimpleEntry<Integer,Integer>> queue = new ArrayDeque<>();
    static int bfs(){
        distance[0][0] = 0;
        queue.add(new AbstractMap.SimpleEntry<Integer,Integer>(0,0));
        int[]dx = {1,0,-1,0};
        int[]dy = {1,0,-1,0};
        while (!queue.isEmpty()){
            AbstractMap.SimpleEntry<Integer,Integer> remove = queue.remove();
            for(int i = 0; i <4; i++) {
                int a =dx[i]+remove.getKey();
                int b = dy[i]+remove.getValue();
//              if (a>=0&&a<=)
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                maze[i][j] = sc.nextInt();
                distance[i][j] = -1;
            }
        }

        System.out.println(bfs());
        
    }


}
