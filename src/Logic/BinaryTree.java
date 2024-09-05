package Logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Clase que representa un árbol binario con algunas operaciones básicas.
 *
 * @param <T> El tipo de objeto que almacenará el árbol.
 */
public class BinaryTree<T>{
    /**
     * El comparador utilizado para ordenar los nodos del árbol.
     */
    private Comparator<T> comparator;
    /**
     * El nodo raíz del árbol.
     */
    private TreeNode<T> root;
    /**
     * Lista de elementos del árbol en orden ascendente.
     */
    private List<T> list;
    /**
     * Crea un nuevo árbol binario de búsqueda con el comparador especificado.
     * @param comparator El comparador utilizado para ordenar los nodos del árbol
     */
    public BinaryTree(Comparator<T> comparator){
        this.comparator = comparator;
        root = null;
    }
    /**
     * Comprueba si el árbol está vacío.
     * @return true si el árbol está vacío, false en caso contrario.
     */
    public boolean isEmpty(){
        return root == null;
    }
    /**
     * Agrega un nodo al árbol con la información especificada.
     * @param info La información que se agregará al árbol.
     */
    public void addNode(T info){
        if(isEmpty()){
            root = new TreeNode<>(info);
        }else{
            TreeNode<T> node = new TreeNode<>(info);
            TreeNode<T> act = root;
            TreeNode<T> ant = null;
            while(act != null){
                ant = act;
                act = comparator.compare(info,act.getInfo()) < 0 ? act.getLeft() : act.getRight();
            }
            if(comparator.compare(info,ant.getInfo()) < 0){
                ant.setLeft(node);
            }else{
                ant.setRight(node);
            }
         }
    }
    /**
     * Busca un nodo en el árbol.
     *
     * @param info El objeto que se está buscando.
     * @return El nodo que contiene el objeto buscado, o null si no se encuentra.
     */
    public TreeNode<T> findNode(T info){
        TreeNode<T> node = new TreeNode<>(info);
        TreeNode<T> aux = root;
        if(root == null){
            return null;
        }
        if(comparator.compare(node.getInfo(),root.getInfo()) == 0){
            return root;
        }else{
            while (comparator.compare(node.getInfo(),aux.getInfo()) != 0){
                aux = comparator.compare(node.getInfo(),aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight() ;
                if(aux == null){
                    return null;
                }
            }
        }
        return aux;
    }
    /**
     * Retorna una lista con los elementos del árbol en orden ascendente.
     *
     * @return Una lista con los elementos del árbol en orden ascendente.
     */
    public List<T> listInsort(){
        list = new ArrayList<>();
        insort( root );

        return list;
    }

    private void insort(TreeNode<T> node) {
        if( node != null ){
            insort( node.getLeft());
            list.add( node.getInfo());
            insort( node.getRight());
        }
    }
    /**
     * Retorna una lista con los elementos del árbol en orden de amplitud.
     *
     * @return Una lista con los elementos del árbol en orden de amplitud.
     */
    public List<T> listAmplitudeUp(){
        ArrayDeque<TreeNode> cola = new ArrayDeque<>();
        ArrayList<T> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        cola.add(root);
        while (cola.isEmpty() != true){
            TreeNode<T> aux = cola.poll();
            if(aux.getLeft() != null){
                cola.add(aux.getLeft());
            }
            if (aux.getRight() != null){
                cola.add(aux.getRight());
            }
            list.add(aux.getInfo());
        }
        return list;
    }
    /**
     * Quita el nodo especificado del árbol de búsqueda binario.
     *
     * @param node El nodo que se va a quitar del árbol binario de búsqueda.
     */
    public void deleteNode(TreeNode<T> node) {
        ArrayList<T> list = new ArrayList<>(listAmplitudeUp());
        root = null;
        for (int i = 0; i < list.size(); i++){
            if(node.getInfo() != list.get(i)){
                addNode(list.get(i));
            }
        }
    }
}
