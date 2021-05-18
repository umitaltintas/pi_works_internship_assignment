public class Tree<T extends Comparable<T>> {

    private Node<T> rootNode;

    public Tree() {
        rootNode = new Node<>();
    }

    public void insert(T value) {
        Node<T> cursorNode = rootNode;
        while ((cursorNode.hasValue())) {
            if (cursorNode.getValue().compareTo(value) > 0) {
                cursorNode = cursorNode.getLeft();
            } else {
                cursorNode = cursorNode.getRight();
            }
        }
        cursorNode.setValue(value);
    }

    public void delete(T value) {
        Node<T> sNode = new Node<>(value);

        Node<T> parent = null;

        Node<T> curr = rootNode;

        while (curr != null && !curr.equals(sNode)) {

            parent = curr;

            if (0 < curr.compareTo(sNode)) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        if (curr == null) {
            return;
        }

        if (!curr.hasLeft() && !curr.hasRight()) {

            if (curr != rootNode) {
                if (parent.getLeft().equals(curr)) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }

            else {
                rootNode = null;
            }
        }

        else if (curr.hasLeft() && curr.hasRight()) {

            Node<T> successor = getMinimumKey(curr.getRight());

            T val = successor.getValue();

            delete(successor.getValue());

            curr.setValue(val);
        }

        else {

            Node<T> child = (curr.hasLeft()) ? curr.getLeft() : curr.getRight();

            if (curr.equals(rootNode)) {
                if (curr.equals(parent.getLeft())) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
            }

            else {
                rootNode = child;
            }
        }

    }

    public Node<T> getMinimumKey(Node<T> curr) {
        while (curr.hasLeft()) {
            curr = curr.getLeft();
        }
        return curr;
    }
}
