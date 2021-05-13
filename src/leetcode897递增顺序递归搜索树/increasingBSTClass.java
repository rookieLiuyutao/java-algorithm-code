package leetcode897递增顺序递归搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * @see 递增顺序递归搜索树 https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class increasingBSTClass {
    static class TreeNode {
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

    static TreeNode dummy = new TreeNode();
    static TreeNode newTree = dummy;
    List<TreeNode> list = new ArrayList<>();

    static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dummy.right = new TreeNode(root.val);
        dummy = dummy.right;
        dfs(root.right);
    }

    public static TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return newTree.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode();
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(3);
        System.out.println(increasingBST(root));

    }
}
