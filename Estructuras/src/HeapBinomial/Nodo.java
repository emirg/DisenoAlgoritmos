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
public class Nodo {

    private int key;
    private int orden;
    private Nodo hermano;
    private Nodo hijo;
    private Nodo padre; 

    public Nodo() {
        this.key = -1;
        orden = 0;
        hermano = null;
        hijo = null;
        padre = null;
    }

    public Nodo(int key) {
        this.key = key;
        orden = 0;
        hermano = null;
        hijo = null;
        padre = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setHermano(Nodo hermano) {
        this.hermano = hermano;
    }

    public void setHijo(Nodo hijo) {
        this.hijo = hijo;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    public int getKey() {
        return key;
    }

    public int getOrden() {
        return orden;
    }

    public Nodo getHermano() {
        return hermano;
    }

    public Nodo getHijo() {
        return hijo;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void incrementarOrden() {
        this.orden++;
    }

    public void decrementarOrden() {
        this.orden--;
    }

    public void print(int level) {
        Nodo curr = this;
        while (curr != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(" ");
            }
            sb.append(curr.getKey());
            System.out.println(sb.toString());
            if (curr.getHijo() != null) {
                curr.getHijo().print(level + 1);
            }
            curr = curr.getHermano();
        }
    }
}
