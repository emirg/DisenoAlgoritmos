/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContadorPalabrasHash;

import java.util.HashMap;

/**
 *
 * @author emiliano
 */
public class Main {

    public static void main(String[] args) {
        /*String[] hola = "hola mundo, como estan?".split("[ ,?¿.]+");
        for (int i = 0; i < hola.length; i++) {
            System.out.println(hola[i]);
        }*/
        System.out.println(cantPalabras("hola mundo, como estan? hola hola? como estann!?"));

    }

    public static String cantPalabras(String cadena) {

        HashMap<String, Integer> hash = new HashMap<>();
        String palabra, salida;
        String[] palabras;
        palabras = cadena.split("[ ,?¿!¡;.()]+");
        for (String palabra1 : palabras) {
            palabra = palabra1;
            if (hash.containsKey(palabra)) {
                hash.put(palabra, hash.get(palabra) + 1);
            } else {
                hash.put(palabra, 1);
            }
        }

        salida = hash.toString();
        return salida;

    }
}
