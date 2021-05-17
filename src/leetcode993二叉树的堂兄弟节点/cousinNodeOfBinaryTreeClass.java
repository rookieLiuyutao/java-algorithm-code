package leetcode993二叉树的堂兄弟节点;

/**
 * @see 二叉树 深搜 https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class cousinNodeOfBinaryTreeClass {

       static class TreeNode {
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
      int treeHeight,father;

    /**
     *
     * @param root dfs 遍历的当前节点
     * @param x 要搜索的值
     * @param height 当前节点的深度
     * @param parent 上一次dfs的节点，即为当前节点的父节点，相当于在root上建立了一个指针节点
     */
    void dfs(TreeNode root,int x,int height,TreeNode parent){
        if (root == null) {
            return;
        }

        if (root.val==x){
            treeHeight = height;
            father = parent.val;
        }
        dfs(root.left,x,height+1,root);
        dfs(root.right,x,height+1,root);

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,0,null);
        int xHeight = treeHeight,xFather = father;
        treeHeight=0;father=0;
        dfs(root,y,0,null);
        int yHeight = treeHeight,yFather = father;
        System.out.println(xFather+" "+xHeight+" "+yFather+" "+yHeight);
        return xFather!=yFather&&xHeight==yHeight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);


        System.out.println(new cousinNodeOfBinaryTreeClass().isCousins(root,4,2));
    }


}
