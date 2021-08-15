package 之字型打印矩阵;

import java.util.ArrayList;

/**
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11， 8，12
 * 【要求】 额外空间复杂度为O(1)。
 */
public class PrintEdgeTozhi {
    public static ArrayList printMatrixZigZag(int[][] matrix) {
        //设A B两指针

        int arow = 0;
        int acols = 0;
        int brow = 0;
        int bcols = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        //isTurn判断打印方向，
        //为true时就从A位置向右下方打印到B位置
        //为false时就从B位置向左上方打印到A位置
        boolean isTurn = false;
        ArrayList arrayList = new ArrayList<Integer>();
        while (arow != endR + 1) {

            printLevel(arrayList,matrix,arow,acols,brow,bcols,isTurn);
            System.out.println("===========");
            //A向右移动
            //B向下移动
            //当B移动到下边界，就向右移动
            //当A移动到右边界就向下移动
            arow = acols == endC ? arow + 1 : arow;
            acols = acols == endC ? acols : acols + 1;
            bcols = brow == endR ? bcols + 1 : bcols;
            brow = brow == endR ? brow : brow + 1;
            isTurn = !isTurn;
//            System.out.print("A点"+ arow+" ");
//            System.out.print(acols+" ");
//            System.out.println();
//            System.out.print("B点" +brow+" ");
//            System.out.print(bcols+" ");
//            System.out.println();
//            System.out.println("================");
        }
        System.out.println();
        return arrayList;
    }

    public static void printLevel(ArrayList arrayList,int[][] matrix, int arow, int acols, int brow, int bcols, boolean isTurn) {
        if (isTurn) {
            //从A位置向左下方打印到B位置
            while (arow != brow + 1) {
                System.out.println("打印A");
                int a=matrix[arow++][acols--];
                System.out.print(a + " ");
//                arrayList.add(a);
//                System.out.println();
//                System.out.println("=============");
//                System.out.print("A移动到" +arow+" ");
//                System.out.print(acols+" ");
//                System.out.println();

            }
        } else {
            //从B位置向右下方打印到A位置
            while (brow != arow - 1) {
                System.out.println("打印B");
                int b =matrix[brow--][bcols++];
                System.out.print( b+ " ");
//                arrayList.add(b);
//                System.out.println();
//                System.out.println("=============");
//                System.out.print("B移动到" +brow+" ");
//                System.out.print(bcols+ " ");
//                System.out.println();

            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 5,3,9 }, { 3,7,5,6 }, { 9,4,6,4 },{7,3,1,3} };
        System.out.println("原矩阵以之字型输出后为"+ printMatrixZigZag(matrix));


    }
}
