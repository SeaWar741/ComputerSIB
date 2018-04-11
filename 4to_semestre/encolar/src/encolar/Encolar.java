/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encolar;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Encolar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] array = {null,null,null,null,"a"};
        menu(array);
        
    }
    
    public static void f_encolar(String[] arry){
        Scanner keyboard = new Scanner(System.in);
        int index = 0;
        int nulls = 0;
        int i= 0;
        while(i < arry.length){
            if(arry[i] != null){
                index = i;
                i = arry.length;
            }
            else{
                nulls ++;
            }
             i++;
        }
        System.out.println("Ingresar valor:");
        String option = keyboard.nextLine();
        System.out.println("");
        if(index != 0 ){
            arry[index-1] = option;
            System.out.println("Valor agregado a la fila!");
        }
        else if(nulls == arry.length){
            arry[arry.length-1] = option;
            System.out.println("Valor agregado a la fila!");
        }
        else{
            System.out.println("La pila esta llena");
        }
        

    }
    
    public static void menu(String[] arry){
        Scanner keyboard = new Scanner(System.in);
        boolean continues = true;
        while(continues == true){
            System.out.println(Arrays.toString(arry));
            System.out.println("");
            System.out.println("Opciones");
            System.out.println("1)Encolar");
            System.out.println("2)Desencolar");
            System.out.println("3)Salir");
            System.out.println("");
            System.out.println("Ingresar opcion del menu:");
            int option = keyboard.nextInt();
            switch(option){
                case 1:
                    f_encolar(arry);
                    break;
                case 2:
                    f_desencolar(arry);
                    break;
                case 3:
                    continues = false;
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Ingresar valor valido");
                    break;
            }
        }        
        
    }
    
    public static void f_desencolar(String[] arry){
      int nulls = 0;
        for(int i =0; i< arry.length;i++){
          if(arry[i] == null){
              nulls++;
          }
        }
        if(nulls == arry.length){
            System.out.println("La pila esta vacia");
        }
        else{
       {
        String last = arry[arry.length-1];          // save off first element

        // shift right
        for( int index =arry.length-2; index >= 0 ; index-- )
            arry[index+1] = arry [index];

        // wrap last element into first slot
        arry[0] = null;
       }
    }
    }
    
        public static int t_top(String[] arry){
        int value = 0;
        for (int i = 0; i < arry.length;i++) {
            if (arry[i] != null) {
                value = i;
            }
        }
        return value;
    }
    
}
