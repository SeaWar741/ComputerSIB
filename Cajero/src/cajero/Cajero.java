/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;
/**
 *
 * @author Juan Ca
 */
public class Cajero {

    /**
     * @param args the command line arguments
     */
    private static Program Program;
    public static void main(String[] args) throws InterruptedException { //this allows looop inside the code
        int X;
        X = 0;
        System.out.println("INICIALIZANDO CAJERO");
        while(X!= 12){ //animation where x value changes every time, sleeping therefore an animation happens by printing in the same line -=
            System.out.printf("-");
            Thread.sleep(250); //the system waits for 250 ms
            System.out.printf("="); 
            Thread.sleep(250);//the system waits for 250 ms
            X++; //X increases in one
        }
        System.out.println();
        System.out.println();
        Program = new Program(); //object program is initialized
        Program.run(); //Program uses run function
    }
    
}