
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.TecladoIn;

/**
 *
 * @author GastonM
 */
public class TestCriptografia {

    public static void main(String[] args) {

        int opcion, i = 0;

        RSA rsa = new RSA();
        Scanner buffer = new Scanner(System.in);

        while (i < 4) {
            System.out.println("Ingrese la opcion numerica de la operacion");
            System.out.println("1) Generar claves publica/privada");
            System.out.println("2) Cargar mensaje y calcular su representacion en base 26");
            System.out.println("3) Generar mensaje encriptado");
            System.out.println("4) Descifrar mensaje");
            System.out.print("Opcion: ");
            opcion = buffer.nextInt();

            switch (opcion) {

                case 1:
                    if (i == 0) {
                        rsa.generarClaves();
                        i++;
                        System.out.println("\n Claves generadas \n");
                    } else {
                        System.out.println("\n Las claves ya existe \n");
                    }
                    break;
                case 2:
                    if (i == 1) {
                        String texto = "";
                        System.out.println("Ingrese el mensaje a enviar: ");
                        texto = TecladoIn.readLine();

                        try {
                            long msg = rsa.cargarMsj(texto);
                            System.out.println("\n Se cargó el mensaje y su representacion base 27 para el mensaje " + texto + " es: " + msg + "\n");
                            i++;
                        } catch (Exception ex) {
                            //Logger.getLogger(TestCriptografia.class.getName()).log(Level.SEVERE, null, ex);
                            rsa.setMsjNull();
                            System.out.println("\n Generando claves nuevas... Intente cargar su mensaje nuevamente \n");
                            rsa.generarClaves();
                        }

                    } else {
                        System.out.println("\n El mensaje no se puede cargar (falta un paso o ya se hizo) \n");
                    }
                    break;
                case 3:
                    if (i == 2) {
                        String mensajeEncriptado = "";
                        mensajeEncriptado = rsa.encriptar();
                        System.out.println("\n El mensaje fue encriptado, y el texto encriptado es: " + mensajeEncriptado + "\n");
                        i++;
                    } else {
                        System.out.println("\n El mensaje ya no se puede encriptar (falta un paso o ya se hizo) \n");
                    }
                    break;
                case 4:
                    if (i == 3) {
                        String mensajeDesencriptado = "";
                        mensajeDesencriptado = rsa.desencriptar();
                        System.out.println("\n El mensaje fue desencriptado, y el texto es: " + mensajeDesencriptado+ "\n");
                        i++;
                    } else {
                        System.out.println("\n El mensaje no se puede descifrar (falta un paso o ya se hizo) \n");
                    }
                    break;
                default:
                    System.out.println("\n Error en ingreso de opciones \n");
            }
        }
    }

}
