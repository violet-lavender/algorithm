package ListNode.Reverse;

import ListNode.ListNode;

// 回文链表
public class IsPalindrome {

    // 可以直接翻转链表然后比较, 但是要遍历两次(一次翻转, 一次比较), 还需要建立一个新链表; 还可以转数组, 再左右双指针判断, 复杂度也比较高
    // 只翻转链表的一部分, 然后比较即可, 只遍历一次, O(n) 的时间复杂度和 O(1) 的空间复杂度, 最优解
    public boolean isPalindrome(ListNode head) {
        //先快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 长度为奇数时, 中点本身不参与判断, slow(此时为中点)需后移; 而长度为偶数时, slow本身就是中间两个靠后的那个
        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        // 用 right 比, right 可能短一个(长度为奇数时)
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
