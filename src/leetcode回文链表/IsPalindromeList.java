package leetcode回文链表;

/**
 * @see 链表 https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */

public class IsPalindromeList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        //
        /**
         * 这种逆置方法会把中间的数覆盖掉一个
         *
         */

        ListNode behind = null;
        while (n2 != null) {
            behind = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = behind;
        }
        behind = n1;
        n2 = head;
        //设置此变量解决了链表长度为2的特殊情况
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }


        return res;
    }

    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = null;
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        printLinkedList(head);

        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(1);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        printLinkedList(head);

        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
