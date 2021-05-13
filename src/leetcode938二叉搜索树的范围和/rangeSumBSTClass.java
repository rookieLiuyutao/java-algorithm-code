package leetcode938二叉搜索树的范围和;

/**
 * @see 938二叉搜索树的范围和 https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class rangeSumBSTClass {
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
    static int sum = 0;
    static void dfs(TreeNode root,int low,int high){

        if (root ==null){
            return ;
        }
        if (root.val>=low&&root.val<=high){
            sum+=root.val;
        }
        dfs(root.left,low,high);
        dfs(root.right,low,high);

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return sum;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        System.out.println(rangeSumBST(root,6,10));
    }

}
