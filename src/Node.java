/**
 * Node
 * Generic node class for node used DS.
 */
public class  Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    Node<T> left;
    Node<T> right;
    T value;

    Node(T value){
        this.value= value;
    }
    Node(){

    }
    boolean hasLeft(){
        return left != null;
    }
    boolean hasRight(){
        return right != null;
    }
    boolean hasValue(){
        return value != null;
    }

    void setValue(T value){
        this.value = value;
    }
    T getValue(){
        return value;
    }
    Node<T> getLeft(){
        if(left == null ){
            left=new Node<>();
        }

        return left;
    }
    Node<T> getRight(){
        if(right == null ){
            right=new Node<>();
        }

        return right;
    }
    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.value);
    }
    @Override
    public boolean equals(Object o) {
    
         if (o == this) {
            return true;
        }
  
        
        if (!(o instanceof Node)) {
            return false;
        }
        Node<T> other = (Node<T>) o;
        return this.value.compareTo(other.value)==0;
        
    }
    @Override
    public int hashCode() {
    
        return value.hashCode();
    }
    
}