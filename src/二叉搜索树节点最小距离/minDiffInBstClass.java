package 二叉搜索树节点最小距离;

public class minDiffInBstClass {

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


    int res;
    //记录上一个节点的值
    int last;
    boolean isFirstNode;

    /**
     * 二叉搜索树的中序遍历序列是一个有序序列
     * 所以最小差值必然是相邻两数之间的
     * 所以只需要记录上一个节点的值，迭代更新插值
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (isFirstNode) {
            isFirstNode = false;
        } else {
            res = Math.min(res, root.val - last);
            last = root.val;
        }
        last = root.val;
        dfs(root.right);
    }

    public int minDiffInBst(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isFirstNode = true;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }
}
