package ListNode.Cycle;

import ListNode.ListNode;


// 环形链表
public class DetectCycle {

    public ListNode detectCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        // 将快慢指针其中一个至回头节点,两指针同步,则将在环起点处相遇
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
