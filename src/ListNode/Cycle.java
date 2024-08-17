package ListNode;

// 环形链表问题
public class Cycle {
    // 141. 环形链表
    // 快慢指针, fast 最终能正常走到链表末尾, 说明没有环, 若快慢指针相遇, 则有环
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

    // 142. 环形链表 II
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

