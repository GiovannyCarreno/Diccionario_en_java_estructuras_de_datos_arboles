package Logic;
/**
 * La clase TreeNode representa un nodo de un árbol binario.
 * @param <T> El tipo de objeto almacenado en el nodo.
 */
public class TreeNode<T>{
    private T info;
    private TreeNode<T> left;
    private TreeNode<T> right;
    /**
     * Construye un nuevo nodo con el objeto dado.
     * @param info El objeto que se va a almacenar en el nodo.
     */
    public TreeNode(T info){
        this.info = info;
        this.left = right = null;
    }
    /**
     * Returns the object stored in the node.
     * @return The object stored in the node.
     */
    public T getInfo() {
        return info;
    }
    /**
     * Devuelve el objeto almacenado en el nodo.
     * @param info El objeto almacenado en el nodo.
     */
    public void setInfo(T info) {
        this.info = info;
    }
    /**
     * Devuelve el hijo izquierdo del nodo.
     * @return El hijo izquierdo del nodo.
     */
    public TreeNode<T> getLeft() {
        return left;
    }
    /**
     * Establece el elemento secundario izquierdo del nodo.
     * @param left El nuevo hijo izquierdo del nodo.
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    /**
     *  Devuelve el elemento secundario derecho del nodo.
     * @return El hijo derecho del nodo.
     */
    public TreeNode<T> getRight() {
        return right;
    }
    /**
     * Establece el elemento secundario derecho del nodo.
     * @param right El nuevo hijo derecho del nodo.
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
