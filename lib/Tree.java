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
        Node<T> searchNode = new Node<>(value);

        Node<T> parent = null;

        Node<T> cursorNode = rootNode;

        while (cursorNode != null && !cursorNode.equals(searchNode)) {

            parent = cursorNode;

            if (0 < cursorNode.compareTo(searchNode)) {
                cursorNode = cursorNode.getLeft();
            } else {
                cursorNode = cursorNode.getRight();
            }
        }
        if (cursorNode == null) {
            return;
        }

        if (!cursorNode.hasLeft() && !cursorNode.hasRight()) {

            if (cursorNode != rootNode) {
                if (parent.getLeft().equals(cursorNode)) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }

            else {
                rootNode = null;
            }
        }

        else if (cursorNode.hasLeft() && cursorNode.hasRight()) {

            Node<T> successor = getMinimumKey(cursorNode.getRight());

            var val = successor.getValue();

            delete(successor.getValue());

            cursorNode.setValue(val);
        }

        else {

            Node<T> child = (cursorNode.hasLeft()) ? cursorNode.getLeft() : cursorNode.getRight();

            if (cursorNode.equals(rootNode)) {
                if (cursorNode.equals(parent.getLeft())) {
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
