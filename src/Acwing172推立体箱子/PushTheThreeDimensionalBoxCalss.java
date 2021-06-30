package Acwing172推立体箱子;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @see bfs 宽搜 广搜 https://www.acwing.com/problem/content/description/174/ https://www.acwing.com/solution/content/7278/
 */
public class PushTheThreeDimensionalBoxCalss {

    static Scanner sc = new Scanner(System.in);
    static final int N = 510;
    static int n ,m ;
    static char [][] g = new char[N][N];
    //dist存从初始状态到每个State的距离
    //dist的两个功能：1.有Boolean st[][][] 标记有没有被搜过的功能
    //2.有记录最短距离的功能
    static int[][][] dist = new int[N][N][3];

    //d为状态偏移量 d[3][4][3]表示
    // 对于三种状态(0 立着，1 横着躺，2 竖着躺)，
    // 每种状态4个方向(上，右，下，左)，
    // 每种状态有三个值要改变(x,y,line)
    //注意想清楚起点的位置
    static int[][][] d = {
         {{-2,0,2},{0,1,1},{1,0,2},{0,-2,1}},
         {{-1,0,1},{0,2,0},{1,0,1},{0,-1,0}},
         {{-1,0,0},{0,1,2},{2,0,0},{0,-1,2}},
    };

    //(x,y)存箱子的位置坐标，line存箱子当前的状态
    static class State{
      //-------------------------x
      // |(0,0)
      // |  . 立着         用0表示
      // |  -- 横着躺  --  用1表示
      // |  | 竖着躺      用2表示
      // |
      // |
      // |
      // y


        int x,y,line;

        public State() {
        }

        public State(int x) {
            this.x = x;
        }

        public State(int x, int y, int line) {
            this.x = x;
            this.y = y;
            this.line = line;
        }
    }

    /**
     * 检查经过当前操作会不会出界
     * @param x
     * @param y
     * @return 出界返回true 没出界返回false
     */
    static boolean check(int x,int y){
        if (x<0||x>=n||y<0||y>=m){
           return true;
        }
        return g[x][y]=='#';

    }

    static int bfs(State start,State end){
        Deque<State> queue = new ArrayDeque<>();
        //初始化dist数组
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                for(int k = 0; k <3; k++) {
                  dist[i][j][k]  = -1;
                }
            }
        }
        dist[start.x][start.y][start.line] = 0;
        queue.push(start);
        while (!queue.isEmpty()){
            State t = queue.pollLast();
            System.out.println(t.x+" "+t.y+" "+t.line);
            for(int i = 0; i <4; i++) {
              State next = new State(t.x+d[t.line][i][0],t.y+d[t.line][i][1],d[t.line][i][2]);
              int x = next.x;
              int y = next.y;
              if (check(x,y)){
                  continue;
              }
              if (next.line==0){
                  if (g[x][y]=='E'){
                      continue;
                  }
              } else if (next.line == 1) {
                  if (check(x,y+1)){
                      continue;
                  }
              }else {
                  if (check(x+1,y)){
                      continue;
                  }
              }
              if (dist[next.x][next.y][next.line]==-1){
                  dist[next.x][next.y][next.line] = dist[t.x][t.y][t.line]+1;
                  queue.push(next);
              }
            }
        }
        //--------------------
//        for(int i = 0; i <n; i++) {
//            for(int j = 0; j <m; j++) {
//                for(int k = 0; k <3; k++) {
//                    System.out.print(dist[i][j][k]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        //---------------------------
        return dist[end.x][end.y][end.line];
    }

    public static void main(String[] args) {
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            for(int i = 0; i <n; i++) {
                String s = sc.next();
                for(int j = 0; j <m; j++) {
                    g[i][j] = s.charAt(j);
                }
            }
//            for(int i = 0; i <n; i++) {
//                for(int j = 0; j <m; j++) {
//                    System.out.print(g[i][j]+" ");
//                }
//                System.out.println();
//            }
            State start = new State(-1,-1,0);
            State end = new State(-1,-1,0);
            //找起点，起点是'X'
            //以从上到下，从左到右搜到的第一个格子，作为起点
            for(int i = 0; i <n; i++) {
                for(int j = 0; j <m; j++) {
                    if (g[i][j]=='X'&&start.x == -1){
                        if (g[i][j+1]=='X'){
                            start = new State(i,j,1);
                        }else if (g[i+1][j]=='X'){
                            start  = new State(i,j,2);
                        }else {
                            start = new State(i,j,0);
                        }
                    }else if (g[i][j]=='O'){
                        end = new State(i,j,0);
                    }
                }
            }
            System.out.println("起点"+start.x+" "+start.y+" "+start.line);
            System.out.println("终点"+end.x+" "+end.y+" "+end.line);

            System.out.println();
            int res = bfs(start,end);
            if (res==-1){
                System.out.println("Impossible");
            }else {
                System.out.println(res);
            }
        }

    }

}
