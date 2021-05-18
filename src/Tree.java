public class Tree <T extends Comparable<T>> {
    
    Node<T> rootNode;

    public Tree() {
        rootNode = new Node<>();
    }

    public void  insert (T value) {
        Node<T> cursorNode = rootNode;
        while ((cursorNode.hasValue())) {
            if(cursorNode.getValue().compareTo(value)>0)
            {
                cursorNode=cursorNode.getLeft();
            }
        }
    }
}
