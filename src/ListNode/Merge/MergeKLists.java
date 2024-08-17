package ListNode.Merge;

import ListNode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// 合并K个升序链表
// 借助优先级队列（堆）
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode nP = new ListNode(-1);
        ListNode p = nP;
        // 优先级队列, 只放头结点(后续可以不断移动指针)即可
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt((ListNode a) -> a.val));
        for (ListNode head : lists) {
            if (head!= null) {
                priorityQueue.add(head);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return nP.next;
    }
}
