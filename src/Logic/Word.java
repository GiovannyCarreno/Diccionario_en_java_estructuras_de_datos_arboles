package Logic;
/**
 * La clase 'Word' representa una palabra con su significado y traducción.
 */
public class Word {
    private String word; // la palabra
    private String meaning; // el significado de la palabra
    private String translation; // la traducción de la palabra
    /**
     * El constructor de la clase Word.
     *
     * @param word la palabra a ser representada.
     * @param meaning el significado de la palabra.
     * @param translation la traducción de la palabra.
     */
    public Word(String word, String meaning, String translation) {
        this.word = word;
        this.meaning = meaning;
        this.translation = translation;
    }
    /**
     * Obtiene la palabra de la instancia actual.
     *
     * @return la palabra de la instancia actual.
     */
    public String getWord() {
        return word;
    }
    /**
     * Establece la palabra de la instancia actual.
     *
     * @param word la palabra a ser establecida.
     */
    public void setWord(String word) {
        this.word = word;
    }
    /**
     * Obtiene el significado de la instancia actual.
     *
     * @return el significado de la instancia actual.
     */
    public String getMeaning() {
        return meaning;
    }
    /**
     * Establece el significado de la instancia actual.
     *
     * @param meaning el significado a ser establecido.
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    /**
     * Obtiene la traducción de la instancia actual.
     *
     * @return la traducción de la instancia actual.
     */
    public String getTranslation() {
        return translation;
    }
    /**
     * Establece la traducción de la instancia actual.
     *
     * @param translation la traducción a ser establecida.
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }
    /**
     * Devuelve una representación en cadena de la instancia actual.
     *
     * @return una representación en cadena de la instancia actual.
     */
    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
