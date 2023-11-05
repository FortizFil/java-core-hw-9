package Stack;

public class MyStack<T> {
    private Node<T> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(T value) {
        top = new Node<>(top, value);
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if (index == 0) {
            top = top.getNext();
        } else {
            Node<T> currentNode = top;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }

        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        T value = top.getData();
        top = top.getNext();
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

