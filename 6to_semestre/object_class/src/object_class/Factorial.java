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
public class Factorial {
    private static double factorial, numb;
    public static void fact(){
        factorial = 1;
       while(numb!=0){
           factorial = factorial*numb;
           numb--;
       }
    }
    public static void fact_for(){
        int ffactorial =1;
        for (int i = 0; i < factorial; i++) {
            ffactorial = i*ffactorial;
        }
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingresar el numero deseado");
        System.out.print(">");
        Factorial facty = new Factorial();
        facty.numb = keyboard.nextDouble();
        if(facty.numb >= 0){
            facty.fact();
            System.out.println("El factorial del número ingresado es: "+facty.factorial);
        }
        else{
            System.out.println("El número debe de ser mayor o igual a 0");
        }
    }
    
}
