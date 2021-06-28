package leetcode958二叉树的完全性检验;

/**
 * @see 完全二叉树的性质 https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */

public class IsCompleteTree {

    public class TreeNode {
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
    int n = 0,p = 0;
    boolean dfs(TreeNode root,int k){
        if (root==null){
            return false;
        }
        if (k>=100){
            return true;
        }
        n++;
        p = Math.max(p,k);
        return dfs(root.left,2*k)&& dfs(root.right,2*k+1);

    }

    public boolean isCompleteTree(TreeNode root) {
        if (!dfs(root,1)){
            return false;
        }
        return n==p;
    }

}
