package leetcode872叶子相似的树;

import java.util.ArrayList;

/**
 * @see dfs https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class leafSimilarClass {
      public class TreeNode {
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
      void dfs(TreeNode root,ArrayList list){
          if (root.left==null&&root.right==null){
              list.add(root.val);
          }else {
              if (root.right!=null) dfs(root.right,list);
              if (root.left!=null) dfs(root.left,list);
          }



      }

      public boolean leafSimilar(TreeNode root1, TreeNode root2) {
          ArrayList<Integer> list1 = new ArrayList<>();

          if (root1!=null){
            dfs(root1,list1);
          }
          ArrayList<Integer> list2 = new ArrayList<>();
          if (root2!=null){
              dfs(root2,list2);
          }
            return list1.equals(list2);
      }


}
