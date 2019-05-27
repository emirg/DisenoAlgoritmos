/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolTrie;

import java.util.LinkedHashSet;

/**
 *
 * @author emiliano
 */
public class Nodo {

    private char letra;
    private boolean finPalabra;
    private Nodo[] hijos;
    private LinkedHashSet<String> sinonimos; // LinkedHashSet no permite elementos repetidos, lo cual es ideal para una lista de sinonimos
    private String palabra;

    public Nodo(char letra) {
        this.letra = letra;
        hijos = new Nodo[ArbolTrie.Trie.TAMAÑO_ALFABETO];
        finPalabra = false;
        sinonimos = new LinkedHashSet();
        palabra = null;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setSinonimos(LinkedHashSet<String> sinonimos) {
        this.sinonimos = sinonimos;
    }

    public LinkedHashSet<String> getSinonimos() {
        return sinonimos;
    }

    public char getLetra() {
        return letra;
    }

    public boolean agregarSinonimo(String s) {
        return sinonimos.add(s);
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isFinPalabra() {
        return finPalabra;
    }

    public Nodo[] getHijos() {
        return hijos;
    }

    public void setFinPalabra(boolean finPalabra) {
        this.finPalabra = finPalabra;
    }

    public void setHijos(Nodo[] hijos) {
        this.hijos = hijos;
    }

}
