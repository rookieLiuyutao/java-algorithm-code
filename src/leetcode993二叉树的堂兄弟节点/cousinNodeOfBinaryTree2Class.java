package leetcode993二叉树的堂兄弟节点;

public class cousinNodeOfBinaryTree2Class {

     public static class TreeNode2 {
        int val;
        cousinNodeOfBinaryTreeClass.TreeNode left;
        cousinNodeOfBinaryTreeClass.TreeNode right;

        TreeNode2() {
        }

        TreeNode2(int val) {
            this.val = val;
        }

        TreeNode2(int val, cousinNodeOfBinaryTreeClass.TreeNode left, cousinNodeOfBinaryTreeClass.TreeNode right) {
            this.val = val;

            this.left = left;

            this.right = right;
        }
    }

    /**
     * 查找 t 的「父节点值」&「所在深度」
     * @param current  当前搜索到的节点
     * @param father    root 的父节点
     * @param depth 当前深度
     * @param val     搜索目标值
     * @return [father.val, depth]
     */

    int[] dfs(TreeNode2 current, TreeNode2 father, int val, int depth) {
        if (current == null) {
            return new int[]{-1,-1};
        }
        if (current.val == val){
            return new int[]{father!=null?father.val:1,depth};
        }
        int [] left = dfs(current.left,current,val,depth+1);
        if (left[0]!=-1) {
            return left;
        }
        return dfs(current.right,current,val,depth+1);

    }

    public boolean isCousins(TreeNode2 root, int x, int y) {
        int[] xSearch = dfs(root,null,x,0);
        int[] ySearch = dfs(root,null,y,0);
        return xSearch[1]==ySearch[1] && xSearch[0]!=ySearch[0];
    }


    public static void main(String[] args) {
        TreeNode2 root = new cousinNodeOfBinaryTree2Class.TreeNode2(1);
        root.left = new cousinNodeOfBinaryTreeClass.TreeNode(2);
        root.right = new cousinNodeOfBinaryTreeClass.TreeNode(3);
        root.left.right = new cousinNodeOfBinaryTreeClass.TreeNode(4);
        root.right.right = new cousinNodeOfBinaryTreeClass.TreeNode(5);


        System.out.println(new cousinNodeOfBinaryTree2Class().isCousins(root, 4, 2));
    }


}
