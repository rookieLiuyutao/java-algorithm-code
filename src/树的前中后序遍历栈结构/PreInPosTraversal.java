package 树的前中后序遍历栈结构;


import java.util.Stack;

public class PreInPosTraversal {
    static class Node {
        public int value;
        public Node lChild;
        public Node rChild;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 用栈实现的先序遍历
     * <p>
     * 先将头节点入栈，弹出栈顶，
     * 再将头节点的左孩子入栈，
     * 再将右孩子入栈，
     * 再将左孩子看做新的头节点，
     * 重复此过程
     *
     * @param head
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("先序遍历序列为：");
        Stack<Node> preOrderStack = new Stack<Node>();

        preOrderStack.push(head);
        while (!preOrderStack.isEmpty()) {
            head = preOrderStack.pop();
            System.out.print(head.value + " ");
            if (head.rChild != null) {
                preOrderStack.push(head.rChild);
            }
            if (head.lChild != null) {
                preOrderStack.push(head.lChild);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历栈结构
     *
     * 先将头节点入栈，
     * 再将它的左节点枝都入栈，
     * 然后弹出栈顶，
     * 再将栈顶的右节点枝入栈，
     * 再弹出栈顶，
     * 重复此过程
     *
     * @param head
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("中序遍历序列为");
        if (head != null) {
            Stack<Node> inOrderStack = new Stack<Node>();
            while (!inOrderStack.isEmpty() || head != null) {
                if (head != null) {
                    inOrderStack.push(head);
                    head = head.lChild;

                } else {
                    head = inOrderStack.pop();
                    System.out.print(head.value + " ");
                    head = head.rChild;
                }

            }

        }
        System.out.println();
    }

    /**
     * 先将头节点入栈，
     * 定义一个指针指向栈顶元素，
     * 将栈顶元素的左子枝入栈，
     * 指针随时指向栈顶元素，
     * 指到叶子节点时，弹出叶子节点
     * 将栈顶元素的右枝入栈，
     * 指到叶子节点时，弹出叶子节点
     * @param head
     */
    public static void posOrderUnRecur(Node head) {
        System.out.println("后序遍历序列为：");
        if (head != null) {
            Stack<Node> posOrderStack = new Stack<>();
            posOrderStack.push(head);
            Node temp = null;
            while (!posOrderStack.isEmpty()) {
                temp = posOrderStack.peek();
                if (temp.lChild != null && head != temp.lChild && head != temp.rChild) {
                    posOrderStack.push(temp.lChild);

                } else if (temp.rChild != null && head != temp.rChild) {
                    posOrderStack.push(temp.rChild);
                }else {
                    System.out.print(posOrderStack.pop().value+" ");
                    head=temp;
                }

            }

        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.lChild = new Node(3);
        head.rChild = new Node(8);
        head.lChild.lChild = new Node(2);
        head.lChild.rChild = new Node(4);
        head.lChild.lChild.lChild = new Node(1);
        head.rChild.lChild = new Node(7);
        head.rChild.lChild.lChild = new Node(6);
        head.rChild.rChild = new Node(10);
        head.rChild.rChild.lChild = new Node(9);
        head.rChild.rChild.rChild = new Node(11);
        posOrderUnRecur(head);


    }
}
