
import java.util.HashMap;

public class LRUCache {


    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;


    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be positive"
            );
        }

        this.capacity = capacity;
        this.map = new HashMap<>();


        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }


    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }


    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        moveToFront(node);
        return node.value;
    }


    public void put(int key, int value) {
        Node existing = map.get(key);

        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        addToFront(node);

        if (map.size() > capacity) {
            // The node before tail is least recently used.
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }
}
