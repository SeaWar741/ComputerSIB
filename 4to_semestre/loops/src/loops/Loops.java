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
        //int f,c;
        String black="\033[30m"; 
        String red="\033[31m"; 
        String green="\033[32m"; 
        String yellow="\033[33m"; 
        String blue="\033[34m"; 
        String purple="\033[35m"; 
        String cyan="\033[36m"; 
        String white="\033[37m";
        String reset="\u001B[0m";
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
        /*Scanner teclado = new Scanner(System.in);
        System.out.println(purple+"Texto de Color !!!!!"+reset);
        int t = teclado.nextInt();
        System.out.print("");
        for (c=1;c<=t; c++){
                System.out.print("* ");
            }
                System.out.println("");
        */
        int c,f,t;
        //c = columna
        //f = fila
        Scanner teclado = new Scanner(System.in);
        System.out.println(red+"Cuantas veces quieres repetir el circulo?");
        t = teclado.nextInt();
        
        for(c=1;c<=t;c++){
            //for(f=1;f<=t; f++){ //imprimir matriz
            for(f=1;f<=c;f++){ //imrpimir f igualando a c
                System.out.print(c+" * "+f);
            }
            System.out.println("");
        }
        //invertirlo para que salga la piramide al reves con espacio
        
        
        }
}
