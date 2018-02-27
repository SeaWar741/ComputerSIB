/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Materia: Informatica II
 * grupo 302
 * Autor A01652138, Juan Carlos Garfias Tovar
 * Fecha:26/02/2018
 * Desc:Ejercicio de Lokcers(Clase)
 */
public class Lockers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        Scanner key = new Scanner(System.in);
        
        int lockers[] = new int [20];
        lockers[1] = 20;
        lockers[5] = 10;
        for(int i = 0; i<19;i++){
            int number = i;
            System.out.println("Ingresar zapatos en el locker " +i);
            int no_zapatos = keyboard.nextInt();
            lockers[number]= no_zapatos;
            System.out.println("Desea agregar zapatos en otro locker? y/n");
            String locker_add = key.nextLine();
            locker_add.toLowerCase();
            if(locker_add.equals("n")){
                i = 19;
            }
        }
        System.out.println("Existen: " +vacios(lockers)+ " vacios");
        System.out.println("El locker con mas zapatos es " +no_maximo(lockers)+ " y contiene " +maximo(lockers));
        System.out.println("El locker con menos zapatos es " +no_min(lockers)+" y contiene " +minimo(lockers));
        
    }
    
    public static int maximo(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    
    public static int no_maximo(int[] array){
        int maxValue = array[0];
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] == maximo(array)) {
                maxValue = i;
            }
        }
        return maxValue;
    }
    
    public static int minimo(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] < minValue && array[i] != 0) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public static int vacios(int[] array){
        int total = 0;
        for(int i = 0; i< array.length-1; i++){
            if(array[i]== 0){
                total ++;
            }
        }
        return total+1;
    }
    
    public static int no_min(int[] array){
        int no_min = array[0];
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] == minimo(array)) {
                no_min = i;
            }
        }
        return no_min-1;
    }
}
