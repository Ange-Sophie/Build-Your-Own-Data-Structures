
import java.util.NoSuchElementException;

public class MyStack<T> {

    private final MyLinkedList<T> list = new MyLinkedList<>();


    public void push(T item) {
        list.addFirst(item);
    }


    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.removeFirst();
    }


    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.get(0);
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }
}
