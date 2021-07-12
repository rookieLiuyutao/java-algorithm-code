package leetcode988从叶结点开始的最小字符串;

/**
 *
 */
public class SmallestFromLeaf2 {

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

    String ans;
    StringBuilder path = new StringBuilder();
    void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        path.append((char) root.val+'a');
        if (root.left == null && root.right == null) {
            path.reverse();
            String ss = path.toString();
            path.reverse();
            if (ss.compareTo(ans)<0){
                ans = ss;
            }
        }else {
            dfs(root.left);
            dfs(root.right);
        }

        path.deleteCharAt(path.length()-1);

    }
    public String smallestFromLeaf(TreeNode root) {

        dfs(root);
        return ans;
    }
}
