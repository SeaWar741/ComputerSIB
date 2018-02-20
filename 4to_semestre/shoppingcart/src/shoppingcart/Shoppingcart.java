/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.util.*;

public class Shoppingcart {
    
    public int valid_login = 0;
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        /*database for user & passwords*/
      HashMap<String, String> hmap = new HashMap<>();
      hmap.put("Theyought47@einrot.com","a01652138");
      hmap.put("wcena201@ndfbmail.ga","6p4deq2gcl4k8bdc");
      hmap.put("0syed.sab@pokeett.site","7clqdwqnjz7ohj8e");
      hmap.put("oali.qasem@miur.ml","4trm8owbws7au24d");
      hmap.put("idigao.pga@888z5.ml","pqat88120ibwtya0");
      hmap.put("juanca741@gmail.com","juanca741");
      
      /**/
      /*database for products*/
      /*HashMap<Integer, String[]> products = new HashMap<>();
      products.put(0,new String[]{"shampoo","limpieza","50","10","5"});
      products.put(1,new String[]{"deshodorante","limpieza","50","10","5"});
      products.put(2,new String[]{"pasta dental","limpieza","50","10","5"});
      products.put(3,new String[]{"gel","limpieza","50","10","5"});
      products.put(4,new String[]{"jabon","limpieza","50","10","5"});
      products.put(5,new String[]{"chocolate","comida","50","10","5"});
      products.put(6,new String[]{"refesco","comida","50","10","5"});
      products.put(7,new String[]{"sabritones","comida","50","10","5"});
      products.put(8,new String[]{"chicles clorent","comida","50","10","5"});
      products.put(9,new String[]{"gummy","comida","50","10","5"});*/
      String[] sorted = {""};
      String[][] elements = { {"0","Shampoo","limpieza","50","10","5"}, 
          {"1","Deshodorante","limpieza","50","10","5"},{"2","Pasta dental","limpieza","50","10","5"},
          {"3","Gel","limpieza","50","10","5"},{"4","Jabon","limpieza","50","10","5"},
          {"5","Chocolate","comida","50","10","5"},{"6","Refesco","comida","50","10","5"},
          {"7","Sabritones","comida","50","10","5"},{"8","Chicles clorent","comida","50","10","5"},
          {"9","Gummy","comida","50","10","5"}
      };
      /**/
        Sorting_Array(elements);
      /*inicio código*/
      /*Inicio proceso de login*/
      int counter = 0;
      boolean allowed = false;
      while(counter < 3 && allowed == false){
        System.out.println("Ingresar usuario");
        String user = keyboard.nextLine();
        System.out.println("Ingresar Contraseña");
        String password = keyboard.nextLine();
        if(password.equals(hmap.get(user))){
           allowed = true;
        }
        else{
           counter ++;
        }
      }
      if(allowed == true){
          System.out.println("Procced");
          //insert the rest of the code
          System.out.println(Arrays.deepToString(elements).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
      }
      else{
          System.out.println("Invalid, terminating process");
          System.exit(0);
      }
      /*fin proceso de login*/
      
      /*fin codigo*/
    }

    public static boolean contains(String[] arr, String item) {
        return Arrays.stream(arr).anyMatch(item::equals);
    }
    public static void Sorting_Array(String[][] array){
        ArrayList<String> category = new ArrayList<>();
        int size = array.length-1; //aun no es utilizada, se utilizara si es escalable
        for(int i= 0; i < size; i++){
            category.add(array[i][2]);
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(category);
        category.clear();
        category.addAll(hs);
        Set<String> category_1 = new TreeSet<>();
        Set<String> category_2 = new TreeSet<>();
        int count = 0;
        int x=0;
        System.out.println(category.get(0));
        while(count <9){
            if(array[x][2].equals(category.get(0))){
                category_1.add(array[x][1]+ ": $" +array[x][3]+ "   Descuento del % " +array[x][4]+ " Rating: " +array[x][5]+ " ID: " +array[x][0]);
            }
            x++;
            count ++;
        }
        category_1.forEach((item) -> {
            System.out.println(item);
        });
        x = 0;
        count = 0;
        System.out.println("");
        System.out.println(category.get(1));
        while(count<9){
            if(array[x][2].equals(category.get(1))){
                category_2.add(array[x][1]+ ": $" +array[x][3]+ "   Descuento del % " +array[x][4]+ " Rating: " +array[x][5]+ " ID: " +array[x][0]);
            }
            x++;
            count++;
        }
        category_2.forEach((item) -> {
            System.out.println(item);
        });
    }
}