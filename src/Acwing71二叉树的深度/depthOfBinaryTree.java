package Acwing71二叉树的深度;

/**
 * @see 二叉树的深度 https://www.acwing.com/problem/content/67/
 */

public class depthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
//    int depthLeft;
//    int depthRight;
//    public void dfs(TreeNode root){
//        if (root == null) {
//            return;
//        }
//        dfs(root.left);
//        depthLeft++;
//
//        dfs(root.right);
//        depthRight++;
//    }

        public int treeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(treeDepth(root.right), treeDepth(root.left)) + 1;
        }

    }
