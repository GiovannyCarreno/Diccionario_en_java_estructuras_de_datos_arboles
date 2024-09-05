package Control;

import Logic.BinaryTree;
import Logic.TreeNode;
import Logic.Word;
import Persistence.Files;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * Clase que representa un diccionario de palabras en varios idiomas.
 * Cada palabra se almacena en una lista de árboles binarios, donde cada árbol
 * binario contiene las palabras que empiezan con la misma letra.
 */
public class Dictionary {
    private ArrayList<BinaryTree<Word>> list;
    Files files = new Files();
    /**
     * Constructor que inicializa una nueva lista de árboles binarios vacía.
     */
    public Dictionary() {
        list = new ArrayList<BinaryTree<Word>>();
    }
    /**
     * Método que agrega una nueva palabra al diccionario.
     * @param word La palabra a agregar.
     * @param meaning El significado de la palabra.
     * @param tranlate La traducción de la palabra.
     * @param letter El índice de la letra inicial de la palabra (de 0 a 25 para las letras del alfabeto, o 26 para palabras que comienzan con números o símbolos).
     * @return true si la palabra se agregó correctamente, false si la palabra ya existe en el diccionario.
     */
    public boolean add(String word, String meaning, String tranlate, int letter){
        try {
            if(list.size() == 0){
                for (int i = 0; i < 27; i++){
                    BinaryTree<Word> nuevoArbol = new BinaryTree<Word>(Comparator.comparing(Word::getWord));
                    list.add(nuevoArbol);
                }
            }
            if (list.get(letter).findNode(new Word(word,null,null)) == null){
                list.get(letter).addNode(new Word(word,meaning,tranlate));
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "La palabra ya existe");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "El primer caracter de la palabra no puede ser diferente a una letra");
        }
        return false;
    }
    /**
     * Método que carga datos de un archivo de texto en el diccionario.
     */
    public void loadData(){
        String[] words = files.ContenidoArchivoString("Data/words.txt").split(";");
        if(words[0].equals("")){
        }else {
            for (int i = 0; i < words.length; i++){
                String[] word = words[i].split("ç");
                String letter = word[0];
                char first1 = letter.toUpperCase().charAt(0);
                int assci1 = (int) first1 == 209 ? (int) first1 - 118 : (int) first1 ;
                add(word[0],word[1],word[2],assci1 - 65);
            }
        }
    }
    /**
     * Método que reescribe los datos del diccionario en un archivo de texto.
     */
    public void rewrite(){
        files.clean("Data/words.txt");
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).listInsort().size(); j++){
                addListData(list.get(i).listInsort().get(j).getWord(),list.get(i).listInsort().get(j).getMeaning(),list.get(i).listInsort().get(j).getTranslation());
            }
        }
    }
    /**
     * El método deleteWord se utiliza para eliminar una palabra del diccionario.
     * @param word la palabra que se desea eliminar
     * @param letter el índice de la letra en el alfabeto donde se encuentra la palabra
     */
    public void deleteWord(String word, int letter){
        try {
            if(list.get(letter).findNode(new Word(word,null,null)) != null){
                list.get(letter).deleteNode(list.get(letter).findNode(new Word(word,null,null)));
                rewrite();
            }else {
                JOptionPane.showMessageDialog(null, "La palabra no existe");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "La palabra no existe");
        }
    }
    /**
     * Agrega una nueva entrada de datos a la lista de palabras.
     *
     * @param word la palabra a agregar.
     * @param meaning el significado de la palabra.
     * @param translate la traducción de la palabra.
     */
    public void addListData(String word, String meaning, String translate){
        String data = word + "ç" + meaning + "ç" + translate;
        files.AgregarInformacionArchivo("Data/words.txt",data);
    }
    /**
     * Busca una palabra en la lista de árboles binarios.
     *
     * @param word la palabra a buscar.
     * @param number el número de árbol binario en el que buscar.
     * @return el nodo que contiene la palabra buscada, o null si no se encuentra.
     */
    public TreeNode<Word> findWord(String word, int number){
        try{
            if(list.get(number).findNode(new Word(word,null,null)) != null){
                return list.get(number).findNode(new Word(word,null,null));
            }else {
                return null;
            }
        }catch (Exception e){}
        return null;
    }
    /**
     * Modifica una palabra existente en la lista de árboles binarios.
     *
     * @param word la palabra a modificar.
     * @param meaning el nuevo significado de la palabra.
     * @param tranlate la nueva traducción de la palabra.
     * @param number el número de árbol binario en el que buscar.
     */
    public void modifyWord(String word, String meaning, String tranlate, int number){
        try{
            if(list.get(number).findNode(new Word(word,null,null)) != null){
                list.get(number).findNode(new Word(word,null,null)).setInfo(new Word(word,meaning,tranlate));
                rewrite();
            }else{
                JOptionPane.showMessageDialog(null, "La palabra no existe");
            }
        }catch (Exception e){}
    }
    /**
     * Obtiene la lista de árboles binarios de la lista de palabras.
     *
     * @return la lista de árboles binarios.
     */
    public ArrayList<BinaryTree<Word>> getList() {
        return list;
    }
    /**
     * Establece la lista de árboles binarios de la lista de palabras.
     *
     * @param list la nueva lista de árboles binarios.
     */
    public void setList(ArrayList<BinaryTree<Word>> list) {
        this.list = list;
    }
}
