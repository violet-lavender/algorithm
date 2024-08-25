package ListNode.Other;

import ListNode.ListNode;

// 链表的中间结点
public class MiddleNode {

    // 注意中点有两个时(链表长度为偶数), 返回靠后的那个节点
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
