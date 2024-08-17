package ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// 链表合并问题
public class Merge {
    // 21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点 —— 当需要创造一条新链表时, 可以使用虚拟头结点简化边界处理情况的处理, 避免空指针
        ListNode nP = new ListNode(-1);
        ListNode p = nP;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }else{
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if(list1 != null)
            p.next = list1;
        if(list2 != null)
            p.next = list2;
        return nP.next;
    }

    // 23. 合并K个升序链表
    // 借助优先级队列（堆）
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

    // 2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail= null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            if (head == null) {
                // 注意头结点的初始化问题
                head = tail =new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

}
