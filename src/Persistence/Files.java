package Persistence;

import java.io.*;
import java.util.ArrayList;
/**
 * La clase Files proporciona métodos para operaciones de E/S de archivos, como escribir en un archivo, leer un archivo y limpiar un archivo.
 */
public class Files {
    /**
     * Sobrescribe el contenido de un archivo con el texto dado o agrega el texto al final del archivo.
     * @param ruta La ruta al archivo.
     * @param texto El texto que se va a escribir en el archivo.
     * @return Un booleano que indica si el archivo ya existía antes de que se llamara al método.
     */
    public boolean SobreescribirInformacion(String ruta, String texto) {

        File archivo = new File(ruta);
        boolean existe = false;
        BufferedWriter bw;

        try {
            if (archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(texto + ";\n");
                existe = true;
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(texto);
                existe = false;

            }
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return existe;

    }
    /**
     * Borra el contenido de un archivo.
     * @param ruta La ruta al archivo.
     */
    public void clean(String ruta){
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * Añade el texto dado al final de un archivo.
     * @param ruta La ruta al archivo.
     * @param texto El texto que se va a anexar al archivo.
     */
    public void AgregarInformacionArchivo(String ruta, String texto) {


        //String ruta = "Resources/" + nombre + ".txt";
        File archivo = new File(ruta);

        try {

            FileWriter fstream = new FileWriter(archivo, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(texto + ";\n");
            out.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * Lee el contenido de un archivo y lo devuelve como una sola cadena.
     * @param ruta La ruta al archivo.
     * @return El contenido del archivo como una cadena.
     */
    public String ContenidoArchivoString(String ruta) {

        File archivo = new File(ruta);
        String cadena = null;
        String cadenaFinal = "";

        try {

            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);

            while ((cadena = b.readLine()) != null) {
                cadenaFinal += cadena;
            }

            b.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return cadenaFinal;

    }
}
