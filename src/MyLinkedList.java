
import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int count = 0;


    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }
        count++;
    }


    public void addLast(T data) {
        Node<T> node = new Node<>(data);

        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
        count++;
    }


    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        T value = head.data;
        head = head.next;
        count--;

        if (head == null) {
            tail = null;
        }

        return value;
    }


    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }


    public int size() {
        return count;
    }


    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;

        tail = head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public T findMiddle() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
