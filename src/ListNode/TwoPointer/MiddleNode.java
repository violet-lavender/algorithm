package ListNode.TwoPointer;

import ListNode.ListNode;

// 链表的中间结点
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!= null) {
            // 慢指针走一步, 快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
