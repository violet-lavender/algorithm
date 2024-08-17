package ListNode.Other;

import java.util.HashMap;

// 随机链表的复制
// 一次哈希 + 两次遍历, 哈希是原节点到克隆节点的映射, 第一次遍历克隆节点, 第二次遍历组装节点
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        for (Node p = head; p != null; p = p.next) {
            map.put(p, new Node(p.val));
        }
        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
        }
        return map.get(head);
    }
}

