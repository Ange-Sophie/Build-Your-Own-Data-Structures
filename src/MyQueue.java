
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private final MyStack<T> input = new MyStack<>();
    private final MyStack<T> output = new MyStack<>();


    public void enqueue(T item) {
        input.push(item);
    }


    private void transfer() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }


    public T dequeue() {
        transfer();

        if (output.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return output.pop();
    }


    public T peek() {
        transfer();

        if (output.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return output.peek();
    }


    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}
