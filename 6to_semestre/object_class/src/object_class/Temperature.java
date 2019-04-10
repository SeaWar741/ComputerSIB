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
public class Temperature {
   private static double temp;
    
   public static double kelvin(){
       return (temp + 273.15);
   }
   public static double fahrenheit(){
       return (temp* 9/5 + 32);
   }
   public static void imprimir(){
       if(temp >= -273.15){
            System.out.println("La temperatura en Kelvin es : "+ kelvin());
            System.out.println("La temperatura en Fahrenheit es : "+fahrenheit());
       }
       else{
           System.out.println("No es posible hacer operaciones abajo del 0 absoluto");
       }
   }
   
   public static void main(String[] args){
       Temperature Temperature = new Temperature();
       Scanner keyboard = new Scanner (System.in);
       System.out.println("Ingresar temperatura en grados celsius (ingresar con decimales)");
       System.out.print(">");
       Temperature.temp = keyboard.nextDouble();
       Temperature.imprimir();
   }
}

