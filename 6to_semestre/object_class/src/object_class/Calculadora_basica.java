/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_class;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Calculadora_basica {

    private static int resultado, n_1,n_2;
    private static boolean continues =true;
    
    public static int incremento(int a, int b){
        resultado =a+b;
        return resultado;
    }
    public static double sumar(int n_1, int n_2){
        return n_1+n_2;
    }
    public static double restar(int n_1, int n_2){
        return n_1-n_2;
    }
    public static double multiplicar(int n_1, int n_2){
        return n_1*n_2;
    }
    public static String dividir(int n_1, int n_2){
        if(n_2 == 0){
            System.out.println("No es posible dividir estos valores");
            return "ERROR";
        }
        else{
            double result =n_1/n_2;
            return Double.toString(result);
        }
    }
    public static void number_selection(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingresar dos números");
        n_1 = keyboard.nextInt();
        n_2 = keyboard.nextInt();
    }
    public static void menu(){
        System.out.println("Bienvenido a la calculadora básica");
        do{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Selecciona una opción:");
            System.out.println("a) Sumar");
            System.out.println("b) Restar");
            System.out.println("c) Multiplicación");
            System.out.println("d) Division");
            System.out.println("e) Salida");
            String selection = keyboard.nextLine();
            System.out.println(selection);
            if("a".equals(selection)){
                number_selection();
                System.out.println("El resultado de la suma es "+sumar(n_1,n_2));
            }
            else if("b".equals(selection)){
                number_selection();
                System.out.println("El resultado de la resta es "+restar(n_1,n_2));
            }
            else if("c".equals(selection)){
                number_selection();
                System.out.println("El resultado de la multiplicación es "+multiplicar(n_1,n_2));
            }
            else if("d".equals(selection)){
                number_selection();
                System.out.println("El resultado de la divición es "+dividir(n_1,n_2));   
            }
            else if("e".equals(selection)){
                System.out.println("Hasta luego!");
                continues = false;
            }
            else{
                System.out.println("");
                System.out.println("Ingresar opción válida del menú");
            }
            System.out.println("");
        }while(continues == true);
    }
    public static void main(String[] args) {
        // TODO code application logic here    
        Calculadora_basica cal = new Calculadora_basica();
        cal.menu();  
    }
    
}
