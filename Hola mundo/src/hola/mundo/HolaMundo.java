/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola.mundo;
import java.util.*;

/**
 *
 * @author Juan Ca
 */
public class HolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        /*System.out.println("Hello World");
        String name = keyboard.nextLine();
        */
        
        //declaracion de variables a sumar
        /*System.out.println("Ingresa dos numeros a sumar");
        int n1,n2;
        
        n1 = keyboard.nextInt();
        n2 = keyboard.nextInt();
        
        System.out.println("The sum of those numbers is:");
        System.out.println(n1+n2);
        */
        //sacar area del circulo
        
        /*float radius;
        double pi,area;
        String name;
        pi = 3.141592;
        System.out.println("Ingresa tu nombre");
        name = keyboard.nextLine();
        System.out.println("Ingresar radio del circulo");
        radius = keyboard.nextFloat();
        area = (radius * radius) * pi;
        System.out.println(name + " El area del circulo es:");
        System.out.println(area);
        */
        int type;
        double tempc,tempf,temp;
        System.out.println("Ingresa 1 para convertir de C a F o 2 para F a C");
        type = keyboard.nextInt();
        if(type == 1){
            System.out.println("Ingresar la temperatura");
            tempc = keyboard.nextDouble();
            temp = ((tempc)*(9.0/5.0)+32);
            System.out.println("La temperatura de " +tempc+ "°C a fahrenheit es " +temp+ "°F" );
        }
        else if (type == 2){
            System.out.println("Ingresar la temperatura");
            tempf = keyboard.nextDouble();
            temp = ((tempf - 32) * (5 / 9.0));
            System.out.println("La temperatura de " +tempf+ "°F a Celsius es " +temp+ "°C" );
        }
        
    }    
}