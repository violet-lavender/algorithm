package ListNode.Sort;

import ListNode.ListNode;

// 排序链表
// 优先级队列, 很烂的做法, 时间复杂度O(nlogn), 空间复杂度O(n), 数组排序, 显然也是很烂的做法
// 归并排序, 时间复杂度O(nlogn), 自顶向下空间复杂度为O(logn), 自底向上空间复杂度为O(1)
public class SortListPro {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode nP = new ListNode(0, head);
        // 外层循环, 从长度为 1 的子链表开始, 不断倍增
        for (int size = 1; size < len; size = size * 2) {
            ListNode tail = nP;
            ListNode left = nP.next;
            // 内层循环：遍历链表并合并相邻的子链表
            while (left != null) {
                // 将链表从 left 处切割成两部分，前一部分为size长度
                ListNode right = split(left, size);
                // 切割后一部分，返回其后的部分
                ListNode nxt = split(right, size);
                // 合并 left 和 right, tail为合并后链表的最后一个节点
                tail = merge(left, right, tail);
                left = nxt;
            }
        }
        return nP.next;
    }

    // 切割链表, 返回切割后链表的头结点
    private ListNode split(ListNode head, int size) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        for (int i = 1; i < size && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode nxt = cur.next;
        cur.next = null;
        return nxt;
    }

    // 合并两个有序链表, 并将结果链接到 tail 后面
    private ListNode merge(ListNode left, ListNode right, ListNode tail) {
        ListNode cur = tail;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left != null) ? left : right;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
