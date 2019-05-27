/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdenamientoConteo;

/**
 *
 * @author emiliano
 */
public class Main {

    public static void main(String[] args) {

        /*int [] arreglo = {62,31,84,96,31,47};
        arreglo = ordenarPorConteo(arreglo);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }*/
        char[] arregloCaracteres = {'b', 'c', 'A', 'a', 'C', 'B', 'a', 'B'};
        arregloCaracteres = ordenarPorConteoCaracteres(arregloCaracteres);
        for (int i = 0; i < arregloCaracteres.length; i++) {
            System.out.println(arregloCaracteres[i]);
        }

    }

    public static int[] ordenarPorConteo(int[] arreglo) {
        int[] contador = new int[arreglo.length];
        int[] arregloOrdenado = new int[arreglo.length];
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] < arreglo[j]) {
                    contador[j]++;
                } else {
                    contador[i]++;
                }
            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            arregloOrdenado[contador[i]] = arreglo[i];
        }

        return arregloOrdenado;

    }

    public static char[] ordenarPorConteoCaracteres(char[] arreglo) {
        int[] contador = new int[arreglo.length];
        char[] arregloOrdenado = new char[arreglo.length];
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {

                char aux1 = arreglo[i], aux2 = arreglo[j];
                if (esMayuscula(aux1)) {
                    aux1 = (char) (aux1 + 32);
                }

                if (esMayuscula(aux2)) {
                    aux2 = (char) (aux2 + 32);
                }

                if (aux1 < aux2) {
                    contador[j]++;
                } else {
                    contador[i]++;
                }

            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            arregloOrdenado[contador[i]] = arreglo[i];
        }

        return arregloOrdenado;

    }

    public static boolean esMayuscula(char c) {
        return c > 64 && c < 91;
    }
}
