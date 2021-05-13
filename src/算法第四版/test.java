package 算法第四版;

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

public class test {
    public static void main(String[] args)
    {
        ArrayList arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);
//        int N = 100;
//        StdDraw.setXscale(0,N);
//        StdDraw.setYscale(0,N*N);
//        StdDraw.setPenRadius(.005);
//        for(double i = 1; i <= N; i=i+0.1)
//        {
//            StdDraw.point(i, i);
//            StdDraw.point(i, i*i);
//            StdDraw.point(i, i*Math.log(i));
//        }
//        // set the scale of the coordinate system
//        StdDraw.setXscale(-1.0, 1.0);
//        StdDraw.setYscale(-1.0, 1.0);
//        StdDraw.enableDoubleBuffering();
//
//        // initial values
//        double rx = 0.480, ry = 0.860;     // position
//        double vx = 0.015, vy = 0.023;     // velocity
//        double radius = 0.05;              // radius
//
//        // main animation loop
//        while (true)  {
//
//            // bounce off wall according to law of elastic collision
//            if (Math.abs(rx + vx) > 1.0 - radius) {
//                vx = -vx;
//            }
//            if (Math.abs(ry + vy) > 1.0 - radius) {
//                vy = -vy;
//            }
//
//            // update position
//            rx = rx + vx;
//            ry = ry + vy;
//
//            // clear the background
//            StdDraw.clear(StdDraw.LIGHT_GRAY);
//
//            // draw ball on the screen
//            StdDraw.setPenColor(StdDraw.BLACK);
//            StdDraw.filledCircle(rx, ry, radius);
//
//            // copy offscreen buffer to onscreen
//            StdDraw.show();
//
//            // pause for 20 ms
//            StdDraw.pause(20);
//
//        }
    }

}
