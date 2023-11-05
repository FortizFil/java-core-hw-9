package Stack;

public class Node<T> {
    private Node<T> nextNode;
    private T value;

    public Node( Node<T> nextNode, T value) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public T getData() {
        return value;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public void setNext(Node<T> next) {
        this.nextNode = next;
    }
}

