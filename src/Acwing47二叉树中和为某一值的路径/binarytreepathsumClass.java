package Acwing47二叉树中和为某一值的路径;

/**
 * @see 二叉树中和为某一值的路径 https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */

import java.util.LinkedList;
import java.util.List;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


public class binarytreepathsumClass {



     static LinkedList<List<Integer>> ans = new LinkedList<>();
     static LinkedList<Integer> temp = new LinkedList<>();
     public static void dfs(TreeNode root,int sum){
        if (root==null){
            return;
        }
        temp.add(root.val);
        sum-= root.val;
        if (sum==0&&root.left==null&&root.right==null){
            ans.add(new LinkedList<>(temp));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        temp.removeLast();
     }

    public static List<List<Integer>> findPath(TreeNode root, int sum) {
        dfs(root,sum);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(12);
        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(1);
        root.right.left = new TreeNode(13);
        root.right.right.left= new TreeNode(5);
        System.out.println(findPath(root,22));
    }
}
