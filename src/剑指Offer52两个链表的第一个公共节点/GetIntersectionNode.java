package 剑指Offer52两个链表的第一个公共节点;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class GetIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode l1,l2;
        l1 = headA;
        l2 = headB;
        while (l1 != null) {
            listNodes.add(l1);
            l1 = l1.next;
        }

        while (l2!=null){
            if (!listNodes.contains(l2)){
                l2 = l2.next;
            }else {
                break;
            }
        }
        return l2;
    }


}
