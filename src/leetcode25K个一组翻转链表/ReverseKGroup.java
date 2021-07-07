package leetcode25K个一组翻转链表;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {
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


        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);

            for (ListNode p = dummy;;){
                ListNode q = p;
                for (int i = 0; i < k && q != null; i++) {
                    q = q.next;
                }
                if (q==null){
                    break;
                }
                ListNode a= p.next,b = a.next;
                for(int i = 0; i <k-1; i++) {
                  ListNode c = b.next;
                  b.next = a;
                  a = b;
                  b = c;
                }
                ListNode c = p.next;
                p.next = a;
                c.next = b;
                p = c;
            }
            return dummy.next;
        }

}
