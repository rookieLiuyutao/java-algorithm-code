package leetcode987二叉树的垂序遍历;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    TreeMap<Integer, List<Point>> map = new TreeMap<>();
    List<List<Integer>> res = new ArrayList<>();

    void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        List<Point> temp = new ArrayList<>();
        temp.add(new Point(x, root.val));
        if (map.containsKey(y)){
            map.get(y).add(new Point(x, root.val));
        }else {
            map.put(y,temp);
        }
        dfs(root.left, x + 1, y - 1);

        dfs(root.right, x + 1, y + 1);

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);
        for (Map.Entry<Integer, List<Point>> entry : map.entrySet()) {
            entry.getValue().sort((o1, o2) -> o1.x- o2.x==0?o1.y-o2.y:o1.x-o2.x);
            List<Integer> col = new ArrayList<>();
            for (Point p : entry.getValue()) {
                col.add(p.y);
            }
            res.add(col);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new VerticalTraversal().verticalTraversal(root));
    }

}
