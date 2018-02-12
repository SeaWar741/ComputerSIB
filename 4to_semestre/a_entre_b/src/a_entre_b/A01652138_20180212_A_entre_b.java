/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_entre_b;

import java.util.Scanner;

/******************************************
* MATERIA: INFORMATICA II                 *
* GRUPO: PS-4000-302                      *
* AUTOR: A01652138-JUAN CARLOS GARFIAS    *
* FECHA: 12/02/2018                       *
* DESC: PROGRAMA PARA DIVIDIR DOS NUMEROS *
************************ ******************
 *
 * @author Juan Ca
 */
public class A01652138_20180212_A_entre_b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingresar nombre:");
        String name = reader.nextLine();
        System.out.println("Bienvenido" +name);
        System.out.println("Vamos a acer A/B");
        System.out.println("Ingresar valor de A");
        double A = reader.nextInt();
        System.out.println("Ingresar valor de B");
        double B = reader.nextInt();
        if(B == 0){
            System.out.println("No es posible dividir entre 0");
        }
        else {
            double d = A / B;
            int r = (int) (A%B);
            System.out.printf("%n El resultado de la division es %.2f ",d);
            System.out.println();
            System.out.println("El resiudo de la division es de "+r);
            //System.out.println("El resultado de la division es " +d);
            //System.out.println("El residuo de la division es de " +r);
        }
    }
    
}
