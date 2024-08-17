package ListNode;

import java.util.HashMap;

// 链表分隔问题
public class Partition {
    // 86. 分隔链表
    // 把原链表分成两个子链表, 第一个子链表包含所有小于 x 的节点, 第二个子链表包含所有大于等于 x 的节点, 再把这两个子链表连接起来即可。
    public ListNode partition(ListNode head, int x) {
        ListNode nP1 = new ListNode(-1);
        ListNode nP2 = new ListNode(-1);
        ListNode p1 = nP1;
        ListNode p2 = nP2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 不能直接让 p 指针前进, p = p.next; 这样结果链中会包含一个环, 要断开原链表中每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = nP2.next;
        return nP1.next;
    }

    // 1836. 从未排序的链表中移除重复元素
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode nP = new ListNode(-1);
        nP.next = head;
        // p 用来记录当前不重复链表的尾结点
        p = nP;
        while (p != null) {
            ListNode temp = p.next;
            while (temp != null && map.get(temp.val) > 1) {
                // 跳过重复节点, 直到找到不重复的节点
                temp = temp.next;
            }
            // 接入不重复的节点或尾部空指针, 注意尾部指针也在这里接入, 上面 temp 会多跳一次, 最后到 null
            p.next = temp;
            p = p.next;
        }
        return nP.next;
    }

}
