/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog_ejercicio_funciones_a01652138;

import java.util.Scanner;
/**
 *
 * @author Juan Ca
 */
public class Prog_ejercicio_funciones_a01652138 {

    public static Lockers Lockers;
    public static ClassMD5 ClassMD5;

    /**
     * @param args the command line arguments
     */
    public static void initialize(String[] args) {
        Lockers = new Lockers();
        ClassMD5 = new ClassMD5();
    }
    
    public static void main(String[] args) {
        fmenu();
    }
    
    public static void fmenu(){
        boolean maintain = true;
        Scanner keyboard = new Scanner(System.in);
        while(maintain == true){
            System.out.println("Seleccionar opcion");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("[1]MD5");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("[2]Lockers");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("[3]Ver menu de nuevo");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("[4]Salir");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            int selection = keyboard.nextInt();
            switch(selection){
                case 1:
                    f_md5();
                    break;
                case 2:
                    f_lockers();
                    break;
                case 3:
                    fmenu();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Hasta luego");
                    System.exit(0);
                    break;
                default:
                    System.out.println("No valido");
                    break;

            }
            System.out.println("");
        }
    }
    
    public static void f_md5(){
        System.out.println();
        ClassMD5.encrypt();
    }
    
    public static void f_lockers(){
        System.out.println();
        Lockers.run();   
    }
    
}
