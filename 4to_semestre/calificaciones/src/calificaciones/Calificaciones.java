/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificaciones;

import java.util.Arrays;
import java.util.*;

/**
 *
 * @author Juan Ca
 */
public class Calificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        Scanner key = new Scanner(System.in);
        String[][] cal = new String[][]{
          {"",""},{"",""},{"",""},{"",""},{"",""},
        };
        insert(cal);
        System.out.println("");
        print(cal);
        System.out.println("");
        average(cal);
    }
    
    public static void insert(String[][] array){
        Scanner keyboard = new Scanner(System.in);
        Scanner key = new Scanner(System.in);
        System.out.println("Bienvenido, al programa de calificaciones");
        for(int i = 0; i < array.length; i++){
            System.out.println("Ingresar Nombre del alumno");
            String name = key.nextLine();
            System.out.println("Ingresar calificacion");
            String cal = keyboard.nextLine();
            array[i][0] = name;
            array[i][1] = cal;
        }
    }
    
    public static void print(String[][] array){
        System.out.println("[Alumno, Calificacion]");
        System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
    
    public static void average(String[][] array){
        int[] arry = new int[5];
        for(int i = 0; i< array.length ;i++){
            arry[i]=Integer.parseInt(array[i][1]);
        }
        System.out.println(av(arry));
    }
    
    public static String av(int[] arrNumbers){
        int sum = 0;

        for(int a = 0; a < arrNumbers.length; a++)
        {
           sum = sum + arrNumbers[a];
        }

        double average = sum / arrNumbers.length;

        String av = "Average is: " + average;
        return av;
    }
}
