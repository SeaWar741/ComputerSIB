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
/*
y = ax^3+bx^2+cx+d
entra a
entra b
entra c
entra d
el usuario puede introducir el valor de x =
funcion para cada valores
funcion para y 
*/
public class Ecuacion_er {
    public static int a,b,c,d,x;
    public static void input(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingresar valor de a");
        System.out.print(">");
        a = keyboard.nextInt();
        System.out.println("Ingresar valor de b");
        System.out.print(">");
        b = keyboard.nextInt();
        System.out.println("Ingresar valor de c");
        System.out.print(">");
        c = keyboard.nextInt();
        System.out.println("Ingresar valor de d");
        System.out.print(">");
        d = keyboard.nextInt();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Ingresar valor de x");
        System.out.print(">");
        x = keyboard.nextInt();
    }
    public static double y_value(int a, int b, int c, int d, int x){
        System.out.println("La ecuación ingresada es Y ="+a+"("+x+"^3) +"+b+"("+x+"^2) +"+c+"("+x+") + "+d);
        return(a*(x*x*x)+(b*(x*x))+c*(x)+d);
    }
    public static void main(String[] args){
        System.out.println("Bienvenido al solucionador de la funcion y=ax^3+bx^2+cx+d");
        input();
        System.out.println("El valor de Y en la ecuación es: "+y_value(a,b,c,d,x));
    }
}
