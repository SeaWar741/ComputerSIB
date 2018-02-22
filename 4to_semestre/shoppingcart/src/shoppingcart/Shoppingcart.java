/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import java.util.*;

public class Shoppingcart {
    //class constants
    public static Set<String> category_1 = new TreeSet<>();
    public static Set<String> category_2 = new TreeSet<>();
    public static ArrayList<String> shopping_kart_items = new ArrayList<String>();
    public static ArrayList<Integer> shopping_kart_money_original = new ArrayList<Integer>();
    public static ArrayList<Integer> shopping_kart_money = new ArrayList<Integer>();
    public static String promt = ">";
    //end class constants
    public static void main(String[] args) throws InterruptedException {
        //(UTILIZAR LOOP Y CORRERLO PARA METODO DE RECURSION)boolean play = true;
        Scanner keyboard = new Scanner(System.in);
        //Solucion temporal, pasar a un archivo .txt encriptado(contraseñas y usuarios) con la api de dropbox
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
        //Inicio proceso de login --> pasar a funcion generica con opcion para recuperacion de contraseña
        int counter = 0;
        boolean allowed = false;
        while(counter < 3 && allowed == false){
            System.out.println("Ingresar usuario");
            System.out.print(promt);
            String user = keyboard.nextLine();
            System.out.println("Ingresar Contraseña");
            System.out.print(promt);
            String password = keyboard.nextLine();
            if(password.equals(hmap.get(user))){
                allowed = true;
            }
            else{
                counter ++;
            }
        }
        System.out.println();
        if(allowed == true){
            System.out.println("Procced");
            loading_animation();
            //insert the rest of the code
            selection_menu_display();
            selection_menu(elements);
            //System.out.println(Arrays.deepToStrijuanng(elements).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
        else{
            System.out.println("Invalid, terminating process");
            System.exit(0);
        }
        /*fin proceso de login*/
        System.out.println("");
        /*fin codigo*/
    }
    
    public static void selection_menu_display(){
        System.out.println(" _______________________________________________ ");
        System.out.println("|               Menu de opciones                |");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| [1] Desplegar productos                       |");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| [2] Insertar productos al carrito             |");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| [3] Eliminar productos del carrito            |");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| [4] Ver productos seleccionados y subtotal    |");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| [5] Proceder al pago                          |");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| [6] Forzar salida                             |");
        System.out.println(" ----------------------------------------------- ");;
        System.out.println();
    }
    
    public static void selection_menu(String[][] elements){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Selecionar una opcion del menu");
        System.out.print(promt);
        Integer selection = keyboard.nextInt();
        boolean loop_continue = true;
        while(loop_continue = true){
            switch (selection) {
                case 1:
                    Sorting_Array(elements);//<--- Imprimir la lista de productos categorizados y por orden alfabetico
                    break;
                case 2:
                    adding_to(elements);
                    break;
                case 3:
                    deleting_from(shopping_kart_items);
                    break;
                case 4:
                    display_kart();
                    break;
                case 5:
                    checkout(); //aun no se ha realizado la funcion
                    break;
                case 6:
                    System.out.println("");
                    break;
                default:
                    break;
            }
        }
        
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
        boolean repetition = false;
        System.out.println("Desea agregar algun producto?");
        while(repetition == false){
            System.out.println("y/n");
            String selection = keyboard.nextLine();
            int counter = 0;
            int count = 0;
            int x = 0;
            switch (selection.toLowerCase()) {
                case "y":
                    System.out.println("Ingresar ID del producto a añadir");
                    String product = keyboard.nextLine();
                    //insertar hacer la comparacion indice del producto, insertar solo el nombre, se debe de hacer con un for
                    while(count<9){
                        if(array[x][0].equals(product)){
                            shopping_kart_items.add(array[x][1]);
                        }
                        x++;
                        count++;
                    }
                    x = 0;
                    while(counter < 9){
                        if(array[x][0].equals(product)){
                            String price = array[x][3];
                            String discount = array[x][4];
                            int price_int = parseInt(price);
                            shopping_kart_money_original.add(price_int);
                            price_discount(shopping_kart_money, price, discount);
                        }
                        x ++;
                        counter ++;
                    }
                    System.out.println(shopping_kart_money);
                    System.out.println(shopping_kart_items);
                    break;
                case "n":
                    repetition = true;
                    //function selection menu
                    break;
                default:
                    error_execute_exit();
                    break;
            }
        }
    }
    
    public static void deleting_from(ArrayList arry){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingresar producto a borrar");
        System.out.println(promt);
        String delete_in_product = keyboard.nextLine();
        String delete_product = capitalize(delete_in_product);
        System.out.println(delete_product);
        int count = 0;
        int x = 0;
        int delete_product_index = arry.indexOf(delete_product);     
        shopping_kart_items.remove(delete_product);
        shopping_kart_money.remove(delete_product);
        
    }
    
    public static void price_discount(ArrayList<Integer> shopping_kart,String price, String discount){
        int intprice = Integer.parseInt(price);
        int intdisc = Integer.parseInt(discount);
        int part1 = 100 - intdisc;
        int part2 = intprice * part1;
        int total = part2/100;
        System.out.println(total);
        shopping_kart.add(total);
    }
    
    public static void display_kart(){
        double sum = 0;
        double sum_or = 0;
        for(int i = 1; i < shopping_kart_money.size(); i++){
            sum += shopping_kart_money.get(i);
        }
        for(int i = 1; i < shopping_kart_money_original.size(); i++){
            sum += shopping_kart_money_original.get(i);
        }
        ArrayList<String> items = new ArrayList<>();
        for(int i = 1; i < shopping_kart_money.size(); i++){
            
        }
        Set<String> printed = new HashSet<>();
        shopping_kart_items.stream().filter((s) -> (printed.add(s)) // Set.add() also tells if the element was in the Set!
        ).forEachOrdered((s) -> {
            System.out.println("Producto: " + s
                    + ", cantidad: " + Collections.frequency(shopping_kart_items, s));
        });
        System.out.println("El Subtotal de la cuenta es de $+"+sum_or );
        System.out.println("Total de la cuenta es de $"+sum);
        //System.out.println(shopping_kart_items);
        //System.out.println(shopping_kart_money);
    }
    
    public static void checkout(){
        //code
        System.out.println();
    }
    
    //funciones complementarias
    public static String capitalize(String text){
    String c = (text != null)? text.trim() : "";
    String[] words = c.split(" ");
    String result = "";
    for(String w : words){
        result += (w.length() > 1? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase(Locale.US) : w) + " ";
    }
    return result.trim();
    }
    
    public static void exit(){
        System.out.println(" --------------------------------------------------- ");
        System.out.println("|           Muchas gracias por tu visita            |");
        System.out.println("|              Te esperamos pronto!                 |");
        System.out.println(" --------------------------------------------------- ");
        System.out.println();
        System.exit(0);
    }
    
    public static void error_execute_exit(){
        System.out.println("Error, cerrando programa");
        System.exit(0);
    }
    
    public static void loading_animation() throws InterruptedException{
        for(int i=0; i<9;i++){
            System.out.print("*");
            //sleep(250);<< añadir al final del codigo
        }
        System.out.println();
    }
}