package leetcode19删除链表的倒数第N个结点;

/**
 * @see 链表 双指针
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode dummy  = new ListNode(0,head);
        ListNode i = dummy ,j = head;
        for(int k = 0; k <n; k++) {
          j = j.next;
        }
        while (j!=null){
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next  = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next  = new ListNode(5);
        ListNode head2 = new ListNode(1);
        ListNode xx = removeNthFromEnd(head2,1);
    }
}
