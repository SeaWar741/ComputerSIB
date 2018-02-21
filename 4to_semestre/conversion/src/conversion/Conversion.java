/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Conversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingresar numero Decimal para binario");
        int number = keyboard.nextInt();
        String binario = Integer.toBinaryString(number);
        System.out.println("Method 0: Decimal to binary " +binario); // 1000
        System.out.println("");
        System.out.println("Ingresar numero Decimal para hexadecimal");
        int number2 = keyboard.nextInt();
        String str = Integer.toHexString(number2);
        System.out.println("Method 1: Decimal to hexadecimal: "+str);
    }
    
}
