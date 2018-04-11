/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Pilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] array = {"A","B","1","W","9","e","F",null,null};


        menu(array);
        
    }
    
    public static void menu(String[] array){
        System.out.println();
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        boolean keep = true;
        while(keep = true){
            System.out.println(Arrays.toString(array));
            System.out.println("");
            menu_print();
            System.out.println("");
            System.out.println("Ingresar opcion del menu deseada:");
            int value = keyboard.nextInt();
            switch (value){
                case 1:
                    System.out.println("Ingresar valor");
                    String data = keyboard2.nextLine();
                    f_push(array,data);
                    break;
                case 2:
                    System.out.println(t_top(array));
                    break;
                case 3:
                    System.out.println(isEmpty(array));
                    break;
                case 4:
                    System.out.println(size(array));
                    break;
                case 5:
                    System.out.println(maxSize(array));
                    break;
                case 6:
                    System.out.println(isFull(array));
                    break;
                case 7:
                    keep = false;

            }
        }
    }
    
    public static void menu_print(){
            System.out.println("1)Push");
            System.out.println("2) Top");
            System.out.println("3) isEmpty");
            System.out.println("4)size");
            System.out.println("5) maxSize");
            System.out.println("6) isFull");
            System.out.println("7) Exit");
    }
    
    public static boolean isEmpty(String[] arry){
        boolean empty = true;
        for (int i=0; i<arry.length; i++) {
            if (arry[i] != null) {
                empty = false;
                break;
            }
        }
        return empty;
    } //done
    
    public static int size(String[] arry){
        int size = 0;
        for(int i = 0; i< arry.length;i++){
            if(arry[i]!=null){
                size++;
            }
        }
        return size;
    }
    
    public static int maxSize(String[] arry){
        return arry.length;
    }
    
    public static boolean isFull(String[] arry){
        boolean is = Arrays.asList(arry).contains(null);
        if(is == false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void f_push(String[] arry,String value){
        int topindex = 0;
        int lenght = 0;
        for(int i = 0; i<arry.length; i++){
            if(arry[i] != null){
                topindex = i;
            }
        }
    }
    
    public static String t_top(String[] arry){
        String value = "";
        for (String arry1 : arry) {
            if (arry1 != null) {
                value = arry1;
            }
        }
        return value;
    }
    
}
