/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import static java.lang.Integer.parseInt;
import java.util.*;

public class Shoppingcart {
    //class constants
    public static Set<String> category_1 = new TreeSet<>();
    public static Set<String> category_2 = new TreeSet<>();
    public static ArrayList<String> shopping_kart_items = new ArrayList<String>();
    public static ArrayList<Integer> shopping_kart_money_original = new ArrayList<Integer>();
    public static ArrayList<Integer> shopping_kart_money = new ArrayList<Integer>();
    public static String security_question = "¿Cúal el nombre de tu primer mascota?";
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
            hmap.put("matheo@pinzon.com.mx","matheo123");
        /**/
        /*database for users & security answer*/
        HashMap<String,String> security = new HashMap<>();
            security.put("Theyought47@einrot.com","pepe");
            security.put("wcena201@ndfbmail.ga","thor");
            security.put("0syed.sab@pokeett.site","gabriel");
            security.put("oali.qasem@miur.ml","kala");
            security.put("idigao.pga@888z5.ml","choli");
            security.put("juanca741@gmail.com","olita");
            security.put("matheo@pinzon.com.mx","charlott");
        /**/
        String[][] elements = { {"0","Shampoo","limpieza","50","10","5"}, 
            {"1","Deshodorante","limpieza","50","10","5"},{"2","Pasta dental","limpieza","50","10","5"},
            {"3","Gel","limpieza","50","10","5"},{"4","Jabon","limpieza","50","10","5"},
            {"5","Chocolate","comida","50","10","5"},{"6","Refesco","comida","50","10","5"},
            {"7","Sabritones","comida","50","10","5"},{"8","Chicles clorent","comida","50","10","5"},
            {"9","Gummy","comida","50","10","5"}
        };
        ArrayList<String> security_answers = new ArrayList<>();
            security_answers.add("Pepe");
            security_answers.add("Thor");
            security_answers.add("Puki");
            security_answers.add("Robert");
            security_answers.add("Harry");
            security_answers.add("Pan");
            security_answers.add("charlott");
        /**/
        /*inicio código*/
        boolean run = true;
        while(run = true){
            boolean login = login_permission(hmap,security);
            if(login == true){
                loading_animation();
                //insert the rest of the code
                selection_menu_display();
                selection_menu(elements);
            }
            else{
                System.out.println("Invalid login, terminating process");
            }
            System.out.println();
            System.out.println();
        }
        //encryption password = new encryption("hola");
        /*fin del codigo*/
    }
    
    //funciones del código
    public static void welcome_menu_selection(){ //completar funcion
        Scanner keyboard = new Scanner(System.in);
        boolean loop_do = true;
        while(loop_do == true){
            System.out.println(" ----------------------------------------------- ");
            System.out.println("|               Bienvenido a Kukulcan           |");
            System.out.println("|-----------------------------------------------|");
            System.out.println("| [1] Iniciar sesion                            |");
            System.out.println("| [2] Registrarte                               |");
            System.out.println("| [3] Recuperar contraseña                      |");
            System.out.println(" ----------------------------------------------- ");
            System.out.println();
            System.out.print(promt);
            int selection = keyboard.nextInt();
            switch(selection){
                case 1:
                    //hacer login
                    loop_do = false;
                    break;
                case 2:
                    loop_do = false;
                    break;
                case 3:
                    loop_do = false;
                    break;
                default:
                    System.out.println("Entrada no valida, favor de escribir un valor correcto");
                    break;
        }
        }
    }
    
    public static boolean login_permission(HashMap database, HashMap answers) throws InterruptedException{
        Scanner keyboard = new Scanner(System.in);
        int counter = 0;
        boolean allowed = false;
        while(counter < 3 && allowed == false){
            System.out.println("Ingresar usuario");
            System.out.print(promt);
            String user = keyboard.nextLine();
            System.out.println("Ingresar Contraseña");
            System.out.print(promt);
            String password = keyboard.nextLine();
            if(password.equals(database.get(user))){
                return true;
            }
            else{
                counter ++;
            }
        }
        System.out.println();
        System.out.println("Desea recuperar su contraseña? y/n");
        String password_recovery = keyboard.nextLine().toLowerCase();
        switch (password_recovery) {
            case "y":
                System.out.println();
                System.out.println("Ingresar usuario");
                String user = keyboard.nextLine();
                System.out.println("¿Cuál es el nombre de tu mascota?");
                String user_answer = keyboard.nextLine();
                if(user_answer.equals(answers.get(user))){
                    System.out.println();
                    System.out.println("Identidad verificada");
                    System.out.println("Ingresar nueva contraseña");
                    System.out.print(promt);
                    String new_password = keyboard.nextLine();
                    database.put(user,new_password);
                    System.out.println();
                    System.out.println("Contraseña actualizada!");
                }
                else{
                    System.out.println("Acceso denegado");
                }   break;
            case "n":
                System.out.println("Entendido");
                break;
            default:
                System.out.println("Ingresar valor valido");
                break;
        }
        System.out.println();
        if(allowed == true){
            System.out.println("Procced");
            loading_animation();
            return true;
            //System.out.println(Arrays.deepToStrijuanng(elements).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
        else{
            System.out.println("Invalid, terminating process");
            return false;
        }   
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
    
    public static void selection_menu(String[][] elements) throws InterruptedException{
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Selecionar una opcion del menu");
        System.out.print(promt);
        Integer selection = keyboard.nextInt();
        boolean loop_continue = true;
        while(loop_continue == true){
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
                    exit();
                    System.out.println("");
                    loop_continue = false;
                    break;
                default:
                    break;
            }
            if(loop_continue == true){
                System.out.println();
                selection_menu_display();
                System.out.println();
                System.out.println("Selecionar una opcion del menu");
                System.out.print(promt);
                selection = keyboard.nextInt();
            }
            else{
                exit();
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
                            shopping_kart_money_original.add(price_int); //arreglar
                            price_discount(shopping_kart_money, price, discount);
                        }
                        x ++;
                        counter ++;
                    }
                    System.out.println("Productos seleccionados: " +shopping_kart_items);
                    System.out.println("Subtotal de productos seleccionados" + shopping_kart_money_original);
                    System.out.println("Total de los productos seleccionados: "+shopping_kart_money);
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
        shopping_kart_money.remove(delete_product_index);
        
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
        for(int i = 1; i < shopping_kart_money_original.size(); i++){
            sum_or += shopping_kart_money_original.get(i);
        }
        for(int i = 1; i < shopping_kart_money.size(); i++){
            sum += shopping_kart_money.get(i);
        }
        Set<String> printed = new HashSet<>();
        shopping_kart_items.stream().filter((s) -> (printed.add(s)) // Set.add() also tells if the element was in the Set!
        ).forEachOrdered((s) -> {
            System.out.println("Producto: " + s
                    + ", cantidad: " + Collections.frequency(shopping_kart_items, s));
        });
        System.out.println("El Subtotal de la cuenta es de $"+sum_or );
        System.out.println("Total de la cuenta es de $"+sum);
        //System.out.println(shopping_kart_items);
        //System.out.println(shopping_kart_money);
    }
    
    public static void checkout() throws InterruptedException{
        //code
        if(shopping_kart_items == null){
            System.out.println("cuenta en: $0");
            exit();
        }
        else{
            System.out.println("Validando pago");
            loading_animation();
            System.out.println("Pago validado, Gracias Por su compra");
            System.out.println();
            exit();
        }
        
    }
    
    
    //funciones complementarias
    public static String getHash(String txt, String hashType){
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < array.length; ++i){
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
           
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