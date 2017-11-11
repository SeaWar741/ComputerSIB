/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
		Scanner teclado = new Scanner (System.in);
		  
  		String NOMBRE;
  		int EDAD;
  		int ANO;
		System.out.println("HOLA!!!!, como te llamas?");
  		NOMBRE = teclado.nextLine();
		System.out.println("Hola " + NOMBRE + ", yo soy Matheo");
		System.out.println("Cuantos años tienes?");
		EDAD = teclado.nextInt();
		ANO = 2017 - EDAD;
		System.out.println("naciste en: ");
		System.out.println(ANO);
}
    
}
