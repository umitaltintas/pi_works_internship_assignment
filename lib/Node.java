/**
 * Node Generic node class for node used DS.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private Node<T> left;
    private Node<T> right;
    private T value;

    Node(T value) {
        this.value = value;
    }

    Node() {

    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasValue() {
        return value != null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        if (left == null) {
            left = new Node<>();
        }

        return left;
    }

    public Node<T> getRight() {
        if (right == null) {
            right = new Node<>();
        }

        return right;
    }

    public void setLeft(Node<T> node) {
        left = node;

    }

    public void setRight(Node<T> node) {

        right = node;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object o) {
        Node<T> other;
        if (o == this) {
            return true;
        }

        if ((o instanceof Node)) {
            other = (Node<T>) o;

        } else {
            return false;
        }
        return this.value.compareTo(other.value) == 0;

    }

    @Override
    public int hashCode() {

        return value.hashCode();
    }

}