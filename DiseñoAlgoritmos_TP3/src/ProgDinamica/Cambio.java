/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgDinamica;

/**
 *
 * @author german
 */
public class Cambio {

    private int[][] matrizCambio;
    private int[] vectorMonedas;
    private double vuelto;
    private int[] vectorSeleccion;

    Cambio(double cantidad, int[] monedas) {
        this.vuelto = cantidad;
        this.vectorMonedas = monedas;
        matrizCambio = calcularMonedas(vuelto, monedas);
        vectorSeleccion = seleccionarMonedas(vuelto, monedas, matrizCambio);
    }

    public int[] getVectorSeleccion() {
        return this.vectorSeleccion;
    }

    private int[][] calcularMonedas(double vuelto, int[] monedas) {

        int[][] matrizCambio = new int[monedas.length + 1][(int) vuelto + 1];

        for (int i = 0; i < monedas.length; i++) {
            matrizCambio[i][0] = 0;
        }

        for (int j = 1; j <= vuelto; j++) {
            matrizCambio[0][j] = 99;
        }

        for (int i = 1; i <= monedas.length; i++) {
            for (int j = 1; j <= vuelto; j++) {
                if (j < monedas[i - 1]) {
                    matrizCambio[i][j] = matrizCambio[i - 1][j];
                } else {

                    int minimo = 0;

                    minimo = Math.min(matrizCambio[i - 1][j], matrizCambio[i][j - monedas[i - 1]] + 1);
                    matrizCambio[i][j] = minimo;

                }
            }
        }

        return matrizCambio;
    }

    private int[] seleccionarMonedas(double vuelto, int[] monedas, int[][] tabla) {
        int i, j;
        int[] seleccion = new int[monedas.length];
        
        for (i = 0; i < monedas.length; i++) {
            seleccion[i] = 0;
        }
        
        i = monedas.length;
        j = (int) vuelto;
        while (j > 0) {
            if (i > 1 && tabla[i][j] == tabla[i - 1][j]) {
                i--;
            } else {
                seleccion[i - 1]++;
                j = j - monedas[i - 1];
            }
        }

        return seleccion;
    }

}
