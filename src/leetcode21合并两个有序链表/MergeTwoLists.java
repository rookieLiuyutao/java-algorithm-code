package leetcode21合并两个有序链表;

/**
 * @see 链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, l1), res = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }
        return dummy.next;
    }

}
