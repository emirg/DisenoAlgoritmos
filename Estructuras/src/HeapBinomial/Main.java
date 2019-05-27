/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapBinomial;

/**
 *
 * @author emiliano
 */
public class Main {

    public static void main(String[] args) {
        //Propio
        HeapBinomial b = new HeapBinomial();
        b.insertar(58);
        b.insertar(3);
        b.insertar(100);
        b.insertar(4);
        b.insertar(5);
        b.insertar(6);
        b.insertar(7);

        /*
        BinomialHeap b = new BinomialHeap();
        b.insert(58);
        b.insert(3);
        b.insert(1);
        b.insert(100);
         */
        b.print();
       
        System.out.println("El menor es:"+b.extractMin());
        //System.out.println(b.extractMin());
        b.print();

        /*Nodo n1 = new Nodo(1);
        Nodo n2 = new Nodo(2);
        Nodo n3 = new Nodo(3);
        n1.setHermano(n2);
        n2.setHermano(n3);
        reverse(n1);*/
    }

    public static void reverse(Nodo n) {
        Nodo actual = n;
        Nodo sig = null;
        Nodo prev = null;
        // Nodo nuevaCabeza;
        while (actual != null) {
            sig = actual.getHermano();
            actual.setHermano(prev);
            prev = actual;
            actual = sig;
        }
        n = prev;
    }
}
