/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolTrie;

import java.util.ArrayList;

/**
 *
 * @author emiliano
 */
public class Main {

    public static void main(String[] args) {
        Trie a = new Trie();
        String[] words = {"a","an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
        for (String word : words) {
            a.insertar(word);

        }
        String searchWord = "ant";
        if (a.buscar(searchWord)) {
            System.out.println("The word was found");
        } else {
            System.out.println("The word was NOT found");
        }

        System.out.println("Agregada: " + a.agregarSinonimo(searchWord, "hormiga"));
        System.out.println("Agregada: " + a.agregarSinonimo(searchWord, "hormigatis"));

        System.out.println("Agregada: " + a.agregarSinonimo(searchWord, "hormiga"));
        String[] sin = a.mostrarSinonimos(searchWord);

        for (int i = 0; i < sin.length; i++) {
            System.out.println(sin[i]);
        }

        ArrayList<String> diccionario = a.mostrarPalabras();

        for (int i = 0; i < diccionario.size(); i++) {
            System.out.println(diccionario.get(i));
        }

    }
}
