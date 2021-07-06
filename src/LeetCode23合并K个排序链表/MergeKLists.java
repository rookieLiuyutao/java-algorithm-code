package LeetCode23合并K个排序链表;

import leetcode21合并两个有序链表.MergeTwoLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see 多路归并 优先级队列 https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        ListNode dummy = new ListNode(-1) ,tail = dummy;

        for (ListNode i:lists){
            if (i!=null){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            ListNode t = queue.poll();
            tail.next = t;
            tail = tail.next;
            if (t.next!=null){
                queue.add(t.next);
            }
        }
        return dummy.next;
    }
}
