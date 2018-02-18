/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.util.HashMap;
import java.util.Scanner;

public class Shoppingcart {
    
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      /* This is how to declare HashMap */
      HashMap<String, String> hmap = new HashMap<>();
      /*Adding elements to HashMap*/
      hmap.put("Theyought47@einrot.com","a01652138");
      hmap.put("wcena201@ndfbmail.ga","6p4deq2gcl4k8bdc");
      hmap.put("0syed.sab@pokeett.site","7clqdwqnjz7ohj8e");
      hmap.put("oali.qasem@miur.ml","4trm8owbws7au24d");
      hmap.put("idigao.pga@888z5.ml","pqat88120ibwtya0");
      
      System.out.println("Ingresar usuario");
      String user = keyboard.nextLine();
      System.out.println("Ingresar Contraseña");
      String password = keyboard.nextLine();
      hmap.verify_user(user,password); //is this possible??
    }
    
    public static void verify_user(String user, String password){
        int counter = 0;
        int times = 0;
        while(counter < 3){
            boolean KeyFlag = HashMap.containsKey(user);//what does this error mean
            if(KeyFlag == true){
                boolean VFlag = HashMap.containsValue(password);
                if(VFlag = true){
                    System.out.println("Acceso permitido, Bienvenido usuario " +user);
                    counter = 3;
                }
                if(VFlag == false && times < 3){
                    times ++;
                    counter ++;
                }
                else{
                    System.out.println("Acceso denagado, Cerrando el sistema");
                    System.exit(0);
                }
            }
        }
    }
}
