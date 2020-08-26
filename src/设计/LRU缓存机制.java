package 设计;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存机制 {
}

class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode previous;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    /**
     * size:当前大小
     */
    private int size;
    /**
     * capacity:容量
     */
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        int size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // 判断是否存在
        if (node == null) {
            return -1;
        }
        // 如果存在，则将节点移除再添加到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 移除尾结点，并返回结点
     * @return
     */
    private DLinkedNode removeTail() {
        DLinkedNode tail = this.tail.previous;
        removeNode(tail);
        return tail;
    }

    /**
     * 将尾结点移动到头结点位置
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 添加结点至头
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;

    }

    private void removeNode(DLinkedNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}