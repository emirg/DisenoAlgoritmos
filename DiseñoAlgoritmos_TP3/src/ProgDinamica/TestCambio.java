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
public class TestCambio {

    public static void main(String[] args) {
        System.out.println("¿Cuántos billetes hacen falta para cambiar un cheque de 41.3?");
        Cambio c = new Cambio(41.3 * 100, new int[]{1, 2, 5, 10, 25, 50, 100, 200});

        System.out.println("Monedas de 0,01: " + c.getVectorSeleccion()[0]);
        System.out.println("Monedas de 0,02: " + c.getVectorSeleccion()[1]);
        System.out.println("Monedas de 0,05: " + c.getVectorSeleccion()[2]);
        System.out.println("Monedas de 0,1: " + c.getVectorSeleccion()[3]);
        System.out.println("Monedas de 0,2: " + c.getVectorSeleccion()[4]);
        System.out.println("Monedas de 0,5: " + c.getVectorSeleccion()[5]);
        System.out.println("Monedas de 1: " + c.getVectorSeleccion()[6]);
        System.out.println("Monedas de 2: " + c.getVectorSeleccion()[7]);
        
        //System.out.println("¿Cuántos billetes hacen falta para cambiar un cheque de 41.3?");
        //Cambio c = new Cambio(41.3 * 100, new int[]{25, 50, 100, 200, 500});

        //System.out.println("Monedas de 0,25: " + c.getVectorSeleccion()[0]);
        //System.out.println("Monedas de 0,5: " + c.getVectorSeleccion()[1]);
        //System.out.println("Monedas de 1: " + c.getVectorSeleccion()[2]);
        //System.out.println("Monedas de 2: " + c.getVectorSeleccion()[3]);
        //System.out.println("Monedas de 5: " + c.getVectorSeleccion()[4]);

    }
}
