package ListNode.Hash;

import java.util.HashMap;

// LRU缓存
// 哈希表 + 双向链表, 队尾为最近访问的节点, 队头为最久未访问的节点
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    DoubleList cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cache.size() == capacity) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addLast(node);
        map.put(key, node);
    }

    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    // 头尾虚节点
    Node head, tail;
    int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // 尾插, O(1)
    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // 删除, O(1)
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // 头删, 并返回, O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node node = head.next;
        remove(node);
        return node;
    }

    // 长度, O(1)
    public int size() {
        return size;
    }
}
