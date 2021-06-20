package leetcode2两数相加;

/**
 * @see 模拟 https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbersClass {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);//哑节点
        ListNode cur = dummy;//遍历结果链表的指针

        int jinWei = 0;
        while (l1!=null||l2!=null||jinWei!=0){
            if (l1!=null){
                jinWei+= l1.val;
                l1 = l1.next;//l1为遍历该链表的指针
            }
            if (l2!=null){
                jinWei+= l2.val;
                l2 = l2.next;//l2为遍历该链表的指针
            }
            cur.next = new ListNode(jinWei%10);
            cur = cur.next;
            jinWei/=10;

        }
        return dummy.next;

    }

}
