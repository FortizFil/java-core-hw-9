package Queue;

public class MyQueue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public MyQueue() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>( null, value);
        } else {
            lastNode = new Node<>(firstNode, value);
            firstNode.setNextNode(lastNode);
        }
        size++;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return firstNode.getValue();
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T value = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        size--;
        if (isEmpty()) {
            lastNode = null;
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

