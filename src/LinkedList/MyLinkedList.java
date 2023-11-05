package LinkedList;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public MyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> newLastNode = new Node<>(lastNode, null, value);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }

        Node<T> prevNode = currentNode.getPrevNode();
        Node<T> nextNode = currentNode.getNextNode();

        if (prevNode == null) {
            firstNode = nextNode;
        } else {
            prevNode.setNextNode(nextNode);
        }

        if (nextNode == null) {
            lastNode = prevNode;
        } else {
            nextNode.setPrevNode(prevNode);
        }

        currentNode.setValue(null);
        currentNode.setPrevNode(null);
        currentNode.setNextNode(null);
        size--;
    }

    public void clear() {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNextNode();
            currentNode.setValue(null);
            currentNode.setPrevNode(null);
            currentNode.setNextNode(null);
            currentNode = nextNode;
        }
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getValue();
    }
}

