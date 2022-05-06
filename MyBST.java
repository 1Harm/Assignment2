import java.util.Iterator;
public class MyBST<K extends Comparable<K>,V> implements Iterable<K>{
    private class Node <K extends Comparable <K>, V>{
    K key;
    V value;
    Node <K,V> left, right;
    int length=1;
    public Node(K key,V value){
        this.key = key;
        this.value =value;
    }
}
private Node<K,V> root;
public void put(K key, V value){
    Node<K,V> newNode=new Node<>(key,value);
    root=put(root,newNode);
}
private Node<K,V> put(Node<K,V> current, Node<K,V> node){
    if(current==null){
        return node;
    }
    int cmp=node.key.compareTo(current.key);
    if (cmp>0) {
        current.right = put(current.right, node);
    }
    else if (cmp<0) {
        current.left = put(current.left, node);
    }
    else {
    current.value=node.value;
    }
    current.length=size(current.left)+size(current.right)+1;
    return current;
}
    public int size(Node<K,V> node){
        return node== null ?0:node.length;
    }
public int size(){
return size(root);
}
    private Node<K,V> delete(Node<K,V> current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            else if (current.right == null) {
                return current.left;
            }

           else if (current.left == null) {
                return current.right;
            }
        }
        if (value < current.value) {
            current.left = delete(current.left, value);
            return current;
        }
        current.right = delete(current.right, value);
        return current;
    }
    @Override
    public Iterator<K> iterator() {
        return null;
    }
    void postOrder(Node node)  {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }
    void inOrder(Node node)  {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }
    void preOrder(Node node)  {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    void postOrder_traversal()  {
        postOrder(root);  }
    void inOrder_traversal() {
        inOrder(root);   }
    void preOrder_traversal() {
        preOrder(root);  }
}
