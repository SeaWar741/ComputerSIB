/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_array;

import java.util.*;

/**
 *
 * @author Juan Ca
 */
public class To_array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        int[] arry = new int[10];
        System.out.println("Introduce 10 numeros");
        for(int i=0;i<10;i++){
            int number = keyboard.nextInt();
            arry[i] = number;
        }
        double avg = Arrays.stream(arry).average().getAsDouble();
        System.out.println("Los numeros ingresados son : "+Arrays.toString(arry));       
        System.out.println("La suma de los elementos del array da como resultado : "+sum(arry));
        System.out.println("El promedio del array da como resulado: " +avg);
        System.out.println("El numero maximo del array es: "+maximo(arry));
        System.out.println("El numero minimo del array es: " +minimo(arry));
        System.out.println("La cantidad de numeros positivos del array es: "+positivos(arry));
        System.out.println("la cantidad de numeros negativos del array es: "+negativos(arry));
        
        
        
        
    }
    public static int sum(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length-1; i++)
        {
            sum += arr[i];
        }
        return sum;
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

    public static int minimo(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
    
    public static int positivos(int [] array){
        int positiveCount = 0;
        for(int i = 0; i < array.length-1; i++){
            if(array[i]>0){
                positiveCount ++;
            }
        }
        return positiveCount;
    }

    public static int ceros(int [] array){
        int cerosCount = 0;
        for(int i = 0; i < array.length-1; i++){
            if(array[i]==0){
                cerosCount ++;
            }
        }
        return cerosCount;
    }
    
    public static int negativos(int[] array){
        int negativeCount = 0;
        for (int i = 0; i <= array.length-1; i++){
            if (array[i] < 0){
                negativeCount++;
            }
        }

       return negativeCount;
    }
    
}
