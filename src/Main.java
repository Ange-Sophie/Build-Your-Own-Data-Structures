
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // PART 1: Linked List
        System.out.println("=== PART 1: LINKED LIST ===");

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.get(0));
        System.out.println("Middle: " + list.findMiddle());

        list.reverse();
        System.out.println("After reverse, first: " + list.get(0));

        System.out.println("Removed: " + list.removeFirst());
        System.out.println("New size: " + list.size());

        // PART 2: Stack
        System.out.println("\n=== PART 2: STACK ===");

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Empty? " + stack.isEmpty());

        // PART 2: Queue
        System.out.println("\n=== PART 2: QUEUE ===");

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Sonia");
        queue.enqueue("Alice");
        queue.enqueue("John");

        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Next: " + queue.peek());

        // Balanced brackets
        System.out.println("\n=== BALANCED BRACKETS ===");
        System.out.println(
                "{[()]}: " +
                        ArrayStringUtils.isBalanced("{[()]}")
        );
        System.out.println(
                "([)]: " +
                        ArrayStringUtils.isBalanced("([)]")
        );

        // PART 3: Arrays and Strings
        System.out.println("\n=== PART 3: ARRAYS & STRINGS ===");

        int[] numbers = {1, 2, 3, 4, 5};
        ArrayStringUtils.rotateRight(numbers, 2);
        System.out.println("Rotated: " + Arrays.toString(numbers));

        System.out.println(
                "Anagram: " +
                        ArrayStringUtils.isAnagram("listen", "silent")
        );

        int[] sorted = {1, 2, 4, 6, 8};
        int[] result = ArrayStringUtils.twoSumSorted(sorted, 10);
        System.out.println("Two Sum: " + Arrays.toString(result));

        // PART 4: LRU Cache
        System.out.println("\n=== PART 4: LRU CACHE ===");

        LRUCache cache = new LRUCache(2);
        cache.put(1, 100);
        cache.put(2, 200);

        System.out.println("Get 1: " + cache.get(1));

        cache.put(3, 300); // Evicts key 2

        System.out.println("Get 2: " + cache.get(2));
        System.out.println("Get 3: " + cache.get(3));

        System.out.println("\nAll demonstrations completed!");
    }
}
