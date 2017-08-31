package uesocc.edu.sv.ingenieria.prn335.guia03;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Jonathan Hdz
 */
@LocalBean
@Dependent
public class Utilities implements Serializable {
    
    /**
     * El metodo es capaz de devolver 30 caracteres de una cadena que se es introducida
     * @param cadena Es una variable de tipo String en la cual se introduce la cadena de texto que se desea evaluar
     * @return Este metodo regresa las primeras 20 letras o caracteres que recibio de la variable texto
     */
    public static String getResume(String texto) {
        char caracter = ' ';
        String frase = "";

        if (texto == null) {
            return null;
        }
        if (texto == " ") {
            frase = " ";
        }
        if (texto.length() < 20) {
            frase = texto;
        } else {
            for (int i = 0; i < 20; i++) {
                caracter = texto.charAt(i);
                frase += caracter;
            }
        } 
        return frase;
    }

    /**
     * Este metodo es capaz de obtener una cadena de texto y cambiar despues de un espacio letras minusculas a mayuscalas y tambien eliminar dobles espacios
     * @param cadena
     * @return 
     */
    public static String capitalizar(String texto) {
        
        
       String frase = "";
        if (texto == null) {
            return null;
        } else {
            int cont = 0;

            char[] caracteres = texto.toCharArray();

            for (int i = 0; i < texto.length(); i++) {
                caracteres[i] = Character.toLowerCase(caracteres[i]);
                if (caracteres[i] == ' ') {
                    caracteres[i + 1] = Character.toLowerCase(caracteres[i + 1]);
                }
            }

            for (int i = 0; i < texto.length(); i++) {
                caracteres[0] = Character.toUpperCase(caracteres[0]);
                if (caracteres[i] == ' ') {
                    int p = i;
                    cont = 0;
                    while (caracteres[(p)] == ' ') {
                        p++;
                        cont += 1;
                    }
                    if (cont >= 2) {
                        continue;
                    } else {
                        caracteres[i + cont] = Character.toUpperCase(caracteres[i + cont]);
                    }
                }
                frase += caracteres[i];
            }
        }
        return frase;
        
        
    }

    /**
     * Este metodo es capaz de evaluar una cadena de texto y extraer el numero de veces que se repite una palabra
     * @param palabra es una variable de tipo string que toma la palabra que se va a buscar en el parrafo introducido
     * @param cadena es la cadena de caracteres de la 
     * @return 
     */
    public static int contarCoincidencias(String cadena, String frase) { 
        
        
       int i = 0, contador = 0;
        if(frase==null){
           return contador;
        } 
        while (i != -1) {
            i = cadena.indexOf(frase, i);
            if (i != -1) {
                i++;
                contador++;
            }
        }
        return contador;
        
        
    }
}
