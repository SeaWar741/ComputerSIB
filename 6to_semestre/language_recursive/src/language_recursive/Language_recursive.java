/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package language_recursive;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Language_recursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        ArrayList<String> allowed = new ArrayList<>();
        System.out.println("Cuantas combinaciones deseas añadir?");
        int times = keyboard.nextInt();
        while(allowed.size() < times){
            String combination = keyboard2.nextLine();
            allowed.add(combination);
        }
        allowed.forEach(System.out::print);
    }
    public static void recursive(int n){
        String[] list_strings = {"u","v","w","x","y","z"};
        if(n ==0){
            System.out.println("No se encontraron");
        }
        else{
            
        }
    }
    
}
