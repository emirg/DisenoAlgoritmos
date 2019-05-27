/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapBinomial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emiliano
 */
public class HeapBinomial {

    private Nodo cabeza;

    public HeapBinomial() {
        this.cabeza = null;
    }

    public HeapBinomial(int key) {
        this.cabeza = new Nodo(key);
    }

    public HeapBinomial(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    private void mergeEqualOrderTree(Nodo nodoMenor, Nodo n) {
        //Para mantener la propiedad de heap (se asume que ambos arboles son heap)
        Nodo enlace = nodoMenor.getHijo();
        n.setHermano(enlace);
        nodoMenor.setHijo(n);
        n.setPadre(nodoMenor);
        nodoMenor.incrementarOrden();
    }

    private Nodo merge(HeapBinomial h1, HeapBinomial h2) { // Merge simple
        Nodo cabeza1 = h1.getCabeza();
        Nodo cabeza2 = h2.getCabeza();
        Nodo cabezaNueva;

        if (cabeza1 == null) {
            return cabeza2;
        } else if (cabeza2 == null) {
            return cabeza1;
        } else {
            if (cabeza1.getOrden() <= cabeza2.getOrden()) {
                cabezaNueva = cabeza1;
                cabeza1 = cabeza1.getHermano();
            } else {
                cabezaNueva = cabeza2;
                cabeza2 = cabeza2.getHermano();
            }

            Nodo extremo = cabezaNueva;

            while (cabeza1 != null && cabeza2 != null) {
                if (cabeza1.getOrden() <= cabeza2.getOrden()) {
                    extremo.setHermano(cabeza1);
                    cabeza1 = cabeza1.getHermano();
                } else {
                    extremo.setHermano(cabeza2);
                    cabeza2 = cabeza2.getHermano();
                }

                extremo = extremo.getHermano();
            }

            if (cabeza1 != null) {
                extremo.setHermano(cabeza1);
            } else {
                extremo.setHermano(cabeza2);
            }

        }

        return cabezaNueva;
    }

    public Nodo union(HeapBinomial h) {
        // Merge simple
        Nodo nuevaCabeza = merge(this, h);

        // Punteros auxiliares - prev y sig se usan mas que nada para mantener referencia a los sig/prev. nodos para antes de hacer el merge
        Nodo prev = null;
        Nodo actual = nuevaCabeza;
        Nodo sig = nuevaCabeza.getHermano();

        /*
        After the simple merge, we need to make sure that there is at most one Binomial Tree of any order. 
        To do this, we need to combine Binomial Trees of the same order. 
        We traverse the list of merged roots, we keep track of three-pointers, prev, x and next-x. 
        There can be following 4 cases when we traverse the list of roots.
        
        —–Case 1: Orders of x and next-x are not same, we simply move ahead.
        In following 3 cases orders of x and next-x are same.
        —–Case 2: If the order of next-next-x is also same, move ahead.
        —–Case 3: If the key of x is smaller than or equal to the key of next-x, then make next-x as a child of x by linking it with x.
        —–Case 4: If the key of x is greater, then make x as the child of next.
         */
        while (sig != null) {
            // Caso 1 y 2
            if (actual.getOrden() != sig.getOrden() || (sig.getHermano() != null && sig.getHermano().getOrden() == actual.getOrden())) {
                prev = actual;
                actual = sig;
            } else {
                // Caso 3 
                if (actual.getKey() <= sig.getKey()) {
                    actual.setHermano(sig.getHermano()); // Enlazo el actual con el siguiente-siguiente para no perder el puntero
                    mergeEqualOrderTree(actual, sig); // Uno actual (sera raiz) con siguiente
                } else { // Caso 4
                    if (prev == null) { // Si el previo es nulo entonces voy a poner al siguiente (al que se le agregara) como cabecera nueva
                        nuevaCabeza = sig;
                    } else { // Si no es nulo, tengo que enlazarlo con el hermano del actual para no perder el enlace
                        prev.setHermano(actual.getHermano());
                    }
                    mergeEqualOrderTree(sig, actual); // Uno al siguiente (sera raiz) con el actual
                    actual = sig;
                }
            }
            sig = actual.getHermano();
        }
        return nuevaCabeza;
    }

    public void insertar(int keyNueva) {
        HeapBinomial nuevo = new HeapBinomial(keyNueva); // Genero un nuevo HeapBinomial con la clave/valor enviado
        this.cabeza = union(nuevo);
    }

    public Integer getMin() {
        Integer min = null;
        if (this.cabeza == null) {
            return null;    //Integer.MIN_VALUE; 
        } else {
            Nodo actual = this.cabeza;
            while (actual != null) {
                if (min == null) {
                    min = actual.getKey();
                } else {
                    if (actual.getKey() < min) {
                        min = actual.getKey();
                    }
                }
                actual = actual.getHermano();
            }
        }

        return min;
    }

    public Integer extractMin() {

        if (this.cabeza == null) {
            return null;    //Integer.MIN_VALUE; 
        }

        Nodo min = this.cabeza; //min
        Nodo minPrev = null; //minPrev
        Nodo minSig = min.getHermano(); //next
        Nodo nextPrev = min;


        while (minSig != null) { // Busco el minimo y defino los punteros al nodo previo y posterior a el
            if (minSig.getKey() < min.getKey()) {
                minPrev = nextPrev;
                min = minSig;

            }
            nextPrev = minSig;
            minSig = minSig.getHermano();

        }

        removerRaiz(min, minPrev);
        return min.getKey();

    }

    private void removerRaiz(Nodo raiz, Nodo prev) {
        if (raiz == cabeza) {
            cabeza = raiz.getHermano();
        } else {
            prev.setHermano(raiz.getHermano());
        }

        Nodo newHead = null;
        Nodo child = raiz.getHijo();
        while (child != null) {
            Nodo next = child.getHermano();
            child.setHermano(newHead);
            child.setPadre(null);
            newHead = child;
            child = next;
        }
        HeapBinomial newHeap = new HeapBinomial(newHead);

        cabeza = union(newHeap);
    }

    private void delete(Nodo n) {
        decreaseKey(n, Integer.MIN_VALUE);
        extractMin();
    }

    private void decreaseKey(Nodo n, int nuevaKey) {
        n.setKey(nuevaKey);
        if (n.getPadre() != null && n.getKey() < n.getPadre().getKey()) { // Me ahorro el acceso al metodo en caso que no haya que subirlo
            subirNodo(n);
        }
    }

    private void subirNodo(Nodo n) {
        int aux;
        Nodo menor = n;
        Nodo padre = n.getPadre();
        while (padre != null && menor.getKey() < padre.getKey()) {
            aux = menor.getKey();
            menor.setKey(padre.getKey());
            padre.setKey(aux);
            menor = padre;
            padre = menor.getPadre();
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public void print() {
        System.out.println("Heap Binomial:");
        if (cabeza != null) {
            cabeza.print(0);
        }
    }

    // Este metodo es unicamente para testing/debugging.
    private Nodo search(int key) {
        List<Nodo> nodes = new ArrayList<>();
        nodes.add(cabeza);
        while (!nodes.isEmpty()) {
            Nodo curr = nodes.get(0);
            nodes.remove(0);
            if (curr.getKey() == key) {
                return curr;
            }
            if (curr.getHermano() != null) {
                nodes.add(curr.getHermano());
            }
            if (curr.getHijo() != null) {
                nodes.add(curr.getHijo());
            }
        }
        return null;
    }

}
