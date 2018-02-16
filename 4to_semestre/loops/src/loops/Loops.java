/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Loops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*int A = 0;
        int T = 3;
        while(A<=T){
            System.out.println(A);
            A++;
        }
        System.out.println("");
        A = 0;
        do{
            System.out.println(A);
            A++;
        }while(A<=T);
        */
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        int t = teclado.nextInt();
        System.out.print("");
        int c;
        for (c=1;c<=t; c++){
            int f;
            for(f=1;f<=t;f++){
                System.out.println("* ");
            }
        }
    }
}
