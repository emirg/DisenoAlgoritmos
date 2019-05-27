/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjunto;

/**
 *
 * @author emiliano
 */
public class Conjunto {

    private int[] conjunto;
    private int tamaño;

    public Conjunto(int tamaño) {
        conjunto = new int[tamaño];
        this.tamaño = tamaño;
    }

    public int[] getConjunto() {
        return conjunto;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setConjunto(int[] conjunto) {
        this.conjunto = conjunto;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int buscar(int x) { // Dado un elemento 'x', devuelve la etiqueta (o numero de conjunto) al que pertenece
        return this.conjunto[x];
    }

    public void fusionar(int a, int b) {
        int i = a < b ? a : b;
        int j = a + b - i; // Math.max(a, b);
        for (int k = 0; k < tamaño; k++) {
            if (this.conjunto[k] == j) {
                this.conjunto[k] = i;
            }
        }
    }

    public void insertar(int elemento, int conjunto) {
        if (elemento < conjunto) {
            this.conjunto[elemento] = elemento;
            for (int i = 0; i < tamaño; i++) {
                if (this.conjunto[i] == conjunto) {
                    this.conjunto[i] = elemento;
                }
            }
        } else {
            this.conjunto[elemento] = conjunto;
        }
       
    }

}
