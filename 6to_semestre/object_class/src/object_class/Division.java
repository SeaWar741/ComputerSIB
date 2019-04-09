/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_class;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
/*
y = ax^3+bx^2+cx+d
entra a
entra b
entra c
entra d

el usuario puede introducir el valor de x =

funcion para cada valores
funcion para y 

*/
public class Ecuacion_3er {
    int 
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingresar primer número");
        int n_1 = keyboard.nextInt();
        System.out.println("Ingresar segundo número");
        int n_2 = keyboard.nextInt();
        Division opera = new Division();
        
        n_1 = 10;
        n_2 = 0;
        if(n_2==0){
            mostrar_error();
        }
        else{
            opera.dividir(n_1,n_2);
            opera.mostrarres();
        }
    }

    private static void mostrar_error() {
        System.out.println("Error, no se puede dividir entre 0");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void dividir(int n_1, int n_2) {
        System.out.println(n_1/n_2);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarres() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
