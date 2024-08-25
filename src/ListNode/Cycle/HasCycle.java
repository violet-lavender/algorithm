package ListNode.Cycle;

import ListNode.ListNode;

// 环形链表
// HashSet 也很简单, 这里给出快慢指针
// 快慢指针, fast 最终能正常走到链表末尾, 说明没有环, 若快慢指针相遇, 则有环
public class HasCycle {

    public boolean hasCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
