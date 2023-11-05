package HashMap;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[10];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> kvNode = new Node<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = kvNode;
            size++;
        } else {
            kvNode.setNext(buckets[index]);
            buckets[index] = kvNode;
        }
    }

    public void remove(K key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return;
        }

        if (checkEquals(buckets[index], key) != null) {
            buckets[index] = buckets[index].getNext();
            size--;
        } else {
            Node<K, V> currentNode = buckets[index];
            Node<K, V> nextNode = currentNode.getNext();
            while (nextNode != null) {
                if (checkEquals(nextNode, key) != null) {
                    currentNode.setNext(nextNode.getNext());
                    size--;
                    return;
                }
                currentNode = nextNode;
                nextNode = nextNode.getNext();
            }
        }
    }

    public void clear() {
        buckets = new Node[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> currentNode = buckets[index];
        while (currentNode.getNext() != null) {
            V v = checkEquals(currentNode, key);
            if (v != null)
                return v;

            currentNode = currentNode.getNext();
        }
        return checkEquals(currentNode, key);

    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % buckets.length;
    }

    private V checkEquals(Node<K, V> node, K key) {
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
        return null;
    }
}


