/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N1;
int SER1;
int SER2;
int RES; 
int RESF; 
int I;
int LOOP = 1;
        Scanner Teclado = new Scanner(System.in);
        System.out.println("ingresa el numero");
        N1 = Teclado.nextInt();
        SER1=0;
        SER2=1;
        RESF=0;
         for (I = 0;I <= N1; I=I+1){
        RES=SER1+SER2;
        RESF=SER1;
        SER1=SER2;
        SER2=RES;
    }
        System.out.println(N1+"="+RESF);
}
}
    

