/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
// TODO code application logic here
Scanner keyboard = new Scanner(System.in);
int n1=1, n2=1, n3, c;
System.out.println("Ingrese la cantidad de terminos: ");
c= keyboard.nextInt();
System.out.println(n1+" "+n2+" ");
for(int i=1; i<=c-2;i++){
n3 = n1+n2;
n1=n2;
n2=n3;
System.out.print(n3+" ");
}
System.out.println();

}

    
}
