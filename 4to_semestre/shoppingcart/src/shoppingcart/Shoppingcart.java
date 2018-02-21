/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.util.*;

public class Shoppingcart {
    //class constants
    public int valid_login = 0;
    public static Set<String> category_1 = new TreeSet<>();
    public static Set<String> category_2 = new TreeSet<>();
    public static Set<Integer> shopping_kart = new TreeSet<>();
    //end class constants
    public static void main(String[] args) {
        //(UTILIZAR LOOP Y CORRERLO PARA METODO DE RECURSION)boolean play = true;
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
        String[][] elements = { {"0","Shampoo","limpieza","50","10","5"}, 
            {"1","Deshodorante","limpieza","50","10","5"},{"2","Pasta dental","limpieza","50","10","5"},
            {"3","Gel","limpieza","50","10","5"},{"4","Jabon","limpieza","50","10","5"},
            {"5","Chocolate","comida","50","10","5"},{"6","Refesco","comida","50","10","5"},
            {"7","Sabritones","comida","50","10","5"},{"8","Chicles clorent","comida","50","10","5"},
            {"9","Gummy","comida","50","10","5"}
        };
        /**/
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
            System.out.println("");
            //insert the rest of the code
            Sorting_Array(elements);//<--- Imprimir la lista de productos categorizados y por orden alfabetico
            //System.out.println(Arrays.deepToString(elements).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            boolean add_loop = false;
            while(add_loop == false){
                adding_to(elements);
                System.out.println();
                String repeat = keyboard.nextLine();
                if(repeat.toLowerCase().equals("y")){
                    add_loop = false;
                }
                else if(repeat.toLowerCase().equals("n")){
                    add_loop = true;
                }
                else{
                    System.out.println("error");
                }
            }
        }
        else{
            System.out.println("Invalid, terminating process");
            System.exit(0);
        }
        /*fin proceso de login*/
        System.out.println("");
        /*fin codigo*/
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
        int count = 0;
        int x=0;
        System.out.println();
        System.out.println(category.get(0));
        System.out.println("---------------------------------------------------------------");
        while(count <9){
            if(array[x][2].equals(category.get(0))){
                category_1.add("|"+array[x][1]+ ":  $" +array[x][3]+ "   |Descuento del " +array[x][4]+ "% |Rating: " +array[x][5]+ "| ID: " +array[x][0]+"|");
            }
            x++;
            count ++;
        }
        category_1.forEach((item) -> {
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
        x = 0;
        count = 0;
        System.out.println();
        System.out.println(category.get(1));
        System.out.println("---------------------------------------------------------------");
        while(count<9){
            if(array[x][2].equals(category.get(1))){
                category_2.add("|"+array[x][1]+ ":  $" +array[x][3]+ "   |Descuento del " +array[x][4]+ "% |Rating: " +array[x][5]+ "| ID: " +array[x][0]+"|");
                
            }
            x++;
            count++;
        }
        category_2.forEach((item) -> {
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
    }
    
    public static void adding_to(String[][] array){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Desea agregar algun producto?");
        System.out.println("y/n");
        String selection = keyboard.nextLine();
        int counter = 0;
        int x = 0;
        switch (selection.toLowerCase()) {
            case "y":
                System.out.println("Ingresar ID del producto a añadir");
                String product = keyboard.nextLine();
                while(counter < 9){
                    if(array[x][0].equals(product)){
                        String price = array[x][3];
                        String discount = array[x][4];
                        price_discount(shopping_kart, price, discount);
                    }
                    x ++;
                    counter ++;
                }
                System.out.println(shopping_kart);
                break;
            case "n":
                System.out.println("Checkout iitializing");
                //funcion checkout
                break;
            default:
                error_execute_exit();
                break;
        }
    }
    
    public static void price_discount(Set elements,String price, String discount){
        int intprice = Integer.parseInt(price);
        int intdisc = Integer.parseInt(discount);
        int part1 = 100 - intdisc;
        int part2 = intprice * part1;
        int total = part2/100;
        System.out.println(total);
        elements.add(total);
    }
    
    public static void error_execute_exit(){
        System.out.println("Error, cerrando programa");
        System.exit(0);
    }
}