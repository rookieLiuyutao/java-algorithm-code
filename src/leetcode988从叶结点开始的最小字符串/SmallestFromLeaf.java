package leetcode988从叶结点开始的最小字符串;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
 */
public class SmallestFromLeaf {
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
    String ans,path;

    void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        path+=(char)(root.val+'a');

        if (root.left==null&&root.right==null){
            StringBuilder s = new StringBuilder(path);
            s.reverse();
            if (ans.length()==0||ans.compareTo(String.valueOf(s))>0) {
                ans= String.valueOf(s);
            }
            s.reverse();
        }else {
            dfs(root.left);
            dfs(root.right);
        }
        path = path.substring(0,path.length()-1);
    }

    public String smallestFromLeaf(TreeNode root) {

        dfs(root);
        return ans;
    }

}
