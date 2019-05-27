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
public class Main {

    public static void main(String[] args) {
        Conjunto c = new Conjunto(10);

        c.insertar(5, 2);
        c.insertar(2, 2);
        c.insertar(3, 2);

        
        c.insertar(4, 4);
        c.insertar(6, 4);
        c.insertar(1, 4);

        System.out.println(c.buscar(1));
        System.out.println(c.buscar(2));
        c.fusionar(1, 2);
        System.out.println(c.buscar(1));
        System.out.println(c.buscar(2));
    }

}
