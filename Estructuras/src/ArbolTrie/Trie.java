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
public class Trie {

    protected static final int TAMAÑO_ALFABETO = 26; // a - z
    private Nodo raiz;

    public Trie() {
        raiz = new Nodo(' ');
    }

    public void insertar(String palabra) {
        int indice;
        Nodo actual = this.raiz;
        for (int i = 0; i < palabra.length(); i++) {
            indice = palabra.charAt(i) - 'a'; // Utilizar este metodo no permite palabras con tildes ni con 'ñ'

            if (actual.getHijos()[indice] == null) {
                actual.getHijos()[indice] = new Nodo(palabra.charAt(i));

            }

            actual = actual.getHijos()[indice];
        }
        actual.setPalabra(palabra);
        actual.setFinPalabra(true);

    }

    private Nodo buscarNodoFinal(String palabra) {
        int indice;
        Nodo actual = this.raiz;
        for (int i = 0; i < palabra.length(); i++) {
            indice = palabra.charAt(i) - 'a';

            if (actual.getHijos()[indice] == null) {
                return null;
            }

            actual = actual.getHijos()[indice];
        }
        if (actual.isFinPalabra()) {
            return actual;
        } else {
            return null;
        }
    }

    public boolean buscar(String palabra) {
        Nodo n = buscarNodoFinal(palabra);
        return n != null;

    }

    public boolean agregarSinonimo(String palabra, String sinonimo) {
        int indice;
        Nodo actual = buscarNodoFinal(palabra);

        if (actual != null) {
            return actual.agregarSinonimo(sinonimo);
        } else {
            return false;
        }
    }

    public String[] mostrarSinonimos(String palabra) {
        int indice;
        Nodo actual = buscarNodoFinal(palabra);

        if (actual != null) {
            String[] sin = new String[actual.getSinonimos().size()];
            return actual.getSinonimos().toArray(sin);
        } else {
            return null;
        }
    }

    public ArrayList<String> mostrarPalabras() {
        ArrayList<String> diccionario = new ArrayList();
        return mostrarPalabrasAux(this.raiz, diccionario);
    }

    private ArrayList<String> mostrarPalabrasAux(Nodo n, ArrayList<String> diccionario) {

        if (n != null) {
            if (n.getPalabra() != null) {
                diccionario.add(n.getPalabra());
            }
            for (int i = 0; i < TAMAÑO_ALFABETO; i++) {
                if (n.getHijos()[i] != null) {
                    mostrarPalabrasAux(n.getHijos()[i], diccionario);
                }
            }

        }
        return diccionario;
    }

}
