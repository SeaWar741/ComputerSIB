/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.io.BufferedInputStream;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import static shoppingcart.sqlite_connection.insert_users_initial;


public class Shoppingcart {
    //class constants
    public static Set<String> category_1 = new TreeSet<>();
    public static Set<String> category_2 = new TreeSet<>();
    public static Set<String> category_default = new TreeSet<>();
    public static ArrayList<String> shopping_kart_items = new ArrayList<String>();
    public static ArrayList<Integer> shopping_kart_money_original = new ArrayList<Integer>();
    public static ArrayList<Integer> shopping_kart_money = new ArrayList<Integer>();
    public static String security_question = "¿Cúal el nombre de tu primer mascota?";
    public static String promt = ">";
    public static String total_cost;
    public static String subtotal_cost;
    public static String us;
    public static String login_allow;
    //end class constants
    
    public static void main(String[] args) throws InterruptedException, IOException {    
        welcome_menu_selection();
    }
    

//funciones del código
    
    public static void welcome_menu_selection() throws InterruptedException, IOException{ //funcion de inicio, aun no esta completada, falta hacer el registro, implementar hasta 3er parcial
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        boolean loop_do = true;
        welcome();
        while(loop_do == true){
            System.out.println("|-----------------------------------------------|");
            System.out.println("| [1] Iniciar sesion                            |");
            System.out.println("| [2] Registrarte                               |");
            System.out.println("| [3] Recuperar contraseña                      |");
            System.out.println("| [4] Salir                                     |");
            System.out.println(" ----------------------------------------------- ");
            System.out.println();
            System.out.print(promt);
            int selection = keyboard.nextInt();
            switch(selection){
                case 1:
                    boolean login = sqlite_connection.login_sql();
                    if(login == true){
                        selection_menu_display();
                        selection_menu();
                    }
                    else{
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                        System.out.println("Login invalido");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    }
                    System.out.println();
                    System.out.println();
                    loop_do = false;
                    break;
                case 2:
                    insert_users_initial();
                    break;
                case 3:
                    System.out.println("");
                    String user = keyboard.nextLine();
                    sqlite_connection.recover_password();
                    break;
                case 4:
                    loop_do = false;
                    break;
                default:
                    System.out.println("Entrada no valida, favor de escribir un valor correcto");
                    break;
            }
        }
        exit();
    }
    
    public static boolean login_permission(HashMap database, HashMap answers) throws InterruptedException{ //funcion para verificar login, tipo de dato a regresar(booleano), si el login es exitoso entonces se regresara un valor true, en el caso contrario sera false
        Scanner keyboard = new Scanner(System.in);//inicializacion del scanner
        int counter = 0; //variable para contar el numero de intentos
        boolean allowed = false; //variable booleana para saber si se permite el login o no
        while(counter < 3 && allowed == false){ //si el contador es menor a 3 y la variable allowed es igual a falso entonces se ejecuta la accion
            System.out.println("Ingresar usuario");//se imprime ingresar usuario
            System.out.print(promt);//se imprime en la misma linea promt
            String user = keyboard.nextLine();//se pide que el usuario ingrese su usuario
            us = user;
            System.out.println("Ingresar Contraseña"); //se imprime ingresar contraseña
            System.out.print(promt); //se imprime en la misma linea promt
            String password = keyboard.nextLine(); //se pide que el usuario ingrese si contraseña
            String pass = encryption.encryption(password); //el string pass es igual a el valor dado por la funcion encrypt(la cual encripta la contraseña)con el parametro de la variable password(pedida en la linea de arriba)
            if(pass.equals(database.get(user))){ //si la password encriptada es igual a el valor del hash de usuarios
                return true; //si es true entonces se le asigna a la variable login_permission true
            }
            else{ //en caso de que no se suma uno al contador hasta que este llegue a 3 en donde el loop se rompera
                counter ++;
            }
        }
        System.out.println();
        System.out.println("Desea recuperar su contraseña? y/n");//se pregunta si se desea recuperar la contraseña
        String password_recovery = keyboard.nextLine().toLowerCase(); //se para lo que el usuario escriba a minisculas
        switch (password_recovery) { //switch para el input del usuario
            case "y": //si escribe y
                System.out.println();
                System.out.println("Ingresar usuario"); //se pide que ingrese su usuario
                System.out.print(promt);
                String user = keyboard.nextLine();
                System.out.println("¿Cuál es el nombre de tu mascota?");//se pide que ingrese el nombre de su mascota
                System.out.print(promt);
                String user_answer = keyboard.nextLine();
                String u_a = encryption.encryption(user_answer); //el string u_a es igual al resultado de encriptar la respuesta del usuario
                if(u_a.equals(answers.get(user))){ //si la respuesta de seguridad es igual a lo que escribio el usuario entonces se cambia la contraseña
                    System.out.println();
                    System.out.println("Identidad verificada");
                    System.out.println("Ingresar nueva contraseña");
                    System.out.print(promt);
                    String new_password = keyboard.nextLine();//se pide que ingrese la nueva contraseña
                    String n_p = encryption.encryption(new_password);//se encripta la nueva contraseña
                    database.put(user,n_p);//se inserta la nueva contraseña en el hash como valor del usuario
                    System.out.println();
                    System.out.println("Contraseña actualizada!");
                }
                else{ //si no es igual, entonces se deniega el acceso
                    System.out.println("Acceso denegado");
                }   break;
            case "n": //si no se quiere cambiar la contraseña entonces se dice que esta entendido
                System.out.println("Entendido");
                exit();
                break;
            default: //en caso de que no escriba y o n se pude que escriba un valor valido
                System.out.println("Ingresar valor valido");
                break;
        }
        System.out.println();
        if(allowed == true){ //si la variable allowed es igual a true entonces se establece el valor de la variable del metodo como true
            System.out.println("Procced");
            loading_animation();
            return true;
        }
        else{//si la variable allowed es igual a false  entonces se establece el valor de la variable del metodo como false
            System.out.println("");
            return false;
        }   
    }
    
    public static void selection_menu_display(){ //funcion para desplegar el menu de acciones
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
    
    public static void selection_menu() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException, IOException{ //funcion para la seleccion del usuario
        Scanner keyboard = new Scanner(System.in);//inicializacion del scanner
        System.out.println("Selecionar una opcion del menu");
        System.out.print(promt);
        Integer selection = keyboard.nextInt();//se pide que el usuario ingrese un numero del menu
        boolean loop_continue = true;
        while(loop_continue == true){//este loop se continuara mientras el usuario no haga el pago o haga una salida forzada
            switch (selection) {
                case 1: //caso uno es igual a 
                    sqlite_connection.print_products();//<--- Imprimir la lista de productos categorizados y por orden alfabetico
                    break;
                case 2://caso dos es igual a añadir productos al carrito de compras
                    sqlite_connection.adding_to();//metodo adding_to con elments(carrito)
                    break;
                case 3://caso tres es igual a eliminar productos del carrito de compras
                    deleting_from(shopping_kart_items);//metodo deliting_from con el shopping_kart_items
                    break;
                case 4://caso cuatro es igual a mostrar el carrito de compras, lo que el usuario a ingresado en el junto con el subtotal(sin el descuento) y el total(con el descuento)
                    display_kart();//metodo display kart
                    break;
                case 5://hacer el pago
                    checkout(); //aun no se ha realizado la funcion
                    break;
                case 6://forzar la salida
                    exit();
                    System.out.println("");
                    loop_continue = false; //se establece el valor false y se rompe el loop
                    break;
                default://valor default
                    System.out.println("Valor invalido");
                    System.out.println("");
                    break;
            }
            if(loop_continue == true){ //si el loop continue es igual a true entonces se imprime lo siguiente 
                System.out.println();
                selection_menu_display(); //se muestra el menu
                System.out.println();
                System.out.println("Selecionar una opcion del menu");
                System.out.print(promt);
                selection = keyboard.nextInt();//se pide que inserte el valor del menu
            }
            else{
                exit(); //si no, entonces se realiza el metodo exit, terminando el carrito de compras
            }
        }
        
    }

    public static void Sorting_Array(String[][] array){ //metodo para dar formato a los productos, agruparlos por categoria y alfabeticamente
        ArrayList<String> category = new ArrayList<>();
        int size = array.length-1; //aun no es utilizada, se utilizara si es escalable
        for(int i= 0; i < size; i++){ //se busca dentro del array multidimensional todas las categorias que existan para despues agrupar los productos por orden
            category.add(array[i][2]);//se añaden las categorias
        }
        Set<String> hs = new HashSet<>();//hash set para insertar las categorias
        hs.addAll(category);
        category.clear();
        category.addAll(hs);
        int count = 0;//variable para contador
        int x=0;//variable para el indice cambiante
        System.out.println();
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("|               PRODUCTOS DISPONIBLES EN TIENDA:              |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println(" ["+capitalize(category.get(0))+"]:"); //se imprime la categoria 1
        System.out.println(" ------------------------------------------------------------- ");
        while(count <9){//mientras que el contador sea menor a nueve entonces se hara lo siguiente
            if(array[x][2].equals(category.get(0))){//se hace busqueda , iterando por cada indice 2 en la segunda dimension, si es igual a la categoria 1, entonces se añadira el producto a esa categoria
                category_1.add("|"+array[x][1]+ ":  $" +array[x][3]+ "   |Descuento del " +array[x][4]+ "% |Rating: " +array[x][5]+ "| ID: " +array[x][0]+"|");//formato para añadir a la categoria
            }
            x++;//se aumenta el valor de x y de count
            count ++;
        }
        category_1.forEach((item) -> { //se imprime cada elemento de la categoria 1
            System.out.println(item);
            System.out.println("|-------------------------------------------------------------|");
        });
        x = 0; //se reestablece el valor de x y de count a 0
        count = 0;
        System.out.println();
        System.out.println(" ["+capitalize(category.get(1))+"]:");//se imprime la categoria 2
        System.out.println(" ------------------------------------------------------------- ");
        while(count<9){//mientras que el contador sea menor a nueve entonces se hara lo siguiente
            if(array[x][2].equals(category.get(1))){//se hace busqueda , iterando por cada indice 2 en la segunda dimension, si es igual a la categoria 1, entonces se añadira el producto a esa categoria
                category_2.add("|"+array[x][1]+ ":  $" +array[x][3]+ "   |Descuento del " +array[x][4]+ "% |Rating: " +array[x][5]+ "| ID: " +array[x][0]+"|");//formato para añadir a la categoria
            }
            x++;//se aumenta el valor de x y de count
            count++;
        }
        category_2.forEach((item) -> {//se imprime cada elemento de la categoria 2
            System.out.println(item);
            System.out.println("|-------------------------------------------------------------|");
        });
    }
    
    public static void deleting_from(ArrayList arry){//elimiar del carrito
        Scanner keyboard = new Scanner(System.in); //inicializar el scanner
        Scanner key = new Scanner(System.in);
        System.out.println("Ingresar nombre del producto a borrar"); //se pide el nombre del producto a borrar
        System.out.print(promt);
        String delete_in_product = keyboard.nextLine(); //ingresar el nombre
        String delete_product = capitalize(delete_in_product); //se le pone la primer letra como mayuscula
        System.out.println("Ingresar la cantidad de producto a eliminar");
        System.out.print(promt);
        int quantity = key.nextInt();
        int count = 0; //counter en o
        int x = 0; //x en 0
        if(arry.contains(delete_product)){//si el array contiene el producto a eliminar entonces se realiza la operacion
            for(int i = 0; i< quantity; i++){ // <----- Arreglar para que no haga tanto display del string
                int delete_product_index = arry.indexOf(delete_product); //conseguir el indice del producto a eliminar
                //falta pedir la cantida de productos, por ahora solo elimina uno a la vez
                    shopping_kart_items.remove(delete_product);//se elimina de los items
                    shopping_kart_money_original.remove(delete_product_index);//se elimina del original
                    shopping_kart_money.remove(delete_product_index);//se elimina del descuento
                    System.out.println("Producto eliminado");
            }
        }
        else{
                System.out.println("");//si no esta entonces se dice que no se encuentra en el carrito
                System.out.println("Este producto no se encuentra en su carrito");
            }
    }
    
    public static void price_discount(ArrayList<Integer> shopping_kart,String price, String discount){//hacer el desucento del product
        int intprice = Integer.parseInt(price); //se pasa a integer el precio del product
        int intdisc = Integer.parseInt(discount);//se pasa a integer el descuento del product
        int part1 = 100 - intdisc; //se hace regla de tres para obtener el precio
        int part2 = intprice * part1;
        int total = part2/100; //se hace el descuento
        shopping_kart.add(total);//se añade al descuento en el carrito de compras
    }
    
    public static void display_kart(){ //funcion para desplegar el carrito de compras, subtotal,total,items con cantidad
        double sum = 0; //double con suma
        double sum_or = 0; //double suma original 
        System.out.println("");
        for(int i = 1; i < shopping_kart_money_original.size(); i++){//para cada elmento del shopping cart se le hace suma, esto para poder conocer el subtotal de todos los elementos en el carrito sin el descuento
            sum_or += shopping_kart_money_original.get(i);
        }
        for(int i = 1; i < shopping_kart_money.size(); i++){//para cada elemento del shopping cart se le hace suma,esto para conocer el total de todos los elementos en el carrito con el descuento
            sum += shopping_kart_money.get(i);
        }
        Set<String> printed = new HashSet<>(); //se crea un hash llamado printed
        shopping_kart_items.stream().filter((s) -> (printed.add(s)) // set.add () te dice si el elemento esta en el set, esto para saber cuantos productos hay por cada uno
        ).forEachOrdered((s) -> {
            System.out.println("Producto: " + s
                    + ", cantidad: " + Collections.frequency(shopping_kart_items, s)); //se imprime el producto, con la cantidad (frecuencia) que aparecen en el set
        });
        subtotal_cost = "El Subtotal de la cuenta es de $"+sum_or;//se imprime el subtotal
        System.out.println(subtotal_cost);
        total_cost = "Total de la cuenta es de $"+sum;
        System.out.println(total_cost);//se imprime el total(con descuento
    }
    
    public static void checkout() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException, IOException{ //funcion para el checkout
        Scanner keyboard = new Scanner(System.in);
        double sum = 0; 
        for(int i = 1; i < shopping_kart_money.size(); i++){//para cada elemento del shopping cart se le hace suma,esto para conocer el total de todos los elementos en el carrito con el descuento
            sum += shopping_kart_money.get(i);
        }
        
        if(shopping_kart_items == null){ //si el carro no tiene nada entonces se imprime que la cuenta esta en 0 y se cierra el programa
            System.out.println("cuenta en: $0");
            exit();
        }
        else{//si no esta vacio entonces se procede al pago
            if(sum == 0){
                System.out.println("");
                System.out.println("Su Cuenta en: $0");
                System.out.println("");
                exit();
            }
            else{
                display_kart();
                System.out.println("");
                System.out.println("Desea proceder al pago? (y/n)");
                System.out.print(promt);
                String selection = keyboard.nextLine();
                switch(selection.toLowerCase()){
                        case("y"):
                            System.out.println("Validando pago"); 
                            loading_animation();
                            writting();
                            System.out.println("Pago validado, Gracias Por su compra");
                            System.out.println();
                            Runtime rt=Runtime.getRuntime();
                            String file = "Ticket.txt";
                            Process p=rt.exec("notepad " +file);
                            //Runtime.getRuntime().exec("cmd /c start print.bat");
                            //File file2 = new File("print.bat");
                            //Desktop.getDesktop().open(file2);
                            exit();//se cierra el programa
                            break;
                        case("n"):
                            System.out.println("");
                            break;
                        default:
                            System.out.println("Entrada no valida");
                            break;
                }
            }            
        }
    }
    
    public static void welcome(){
        System.out.println("");
        System.out.println("                Bienvenido a Kukulkan            ");
    }
    
//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*    
    
//funciones complementarias
    public static String capitalize(String text){ //funcion para hacer la primer letra de un strin a mayuscula
    String c = (text != null)? text.trim() : "";
    String[] words = c.split(" ");
    String result = "";
    for(String w : words){
        result += (w.length() > 1? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase(Locale.US) : w) + " ";
    }
    return result.trim();//regresa el string ya convertido
    }
    
    public static void exit(){ //funcion para el exit
        System.out.println(" --------------------------------------------------- ");
        System.out.println("|           Muchas gracias por tu visita            |");
        System.out.println("|              Te esperamos pronto!                 |");
        System.out.println(" --------------------------------------------------- ");
        System.out.println();
        System.exit(0);//se cierra el programa
    }
    
    public static void error_execute_exit(){ //funcion para error, se cierra el programa
        System.out.println("Error, cerrando programa");
        System.exit(0);
    }
    
    public static void loading_animation() throws InterruptedException{ //funcion para animacion de loading
        for(int i=0; i<9;i++){
            System.out.print("*"); //animacion apagada para las pruebas, eliminar de comentarios para entrega final
            sleep(250);
        }
        System.out.println();
    }
    
    public static String espacio(String PAL, int TAM){
        while(PAL.length()<TAM){
            PAL+=" ";
        }
        return PAL;
    }
    
//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    
//escritura en txt
    
    public static void writting() throws FileNotFoundException, UnsupportedEncodingException{
        try (PrintWriter writer = new PrintWriter("Ticket.txt")) {
            double sum = 0; //double con suma
            double sum_or = 0; //double suma original 
            writer.println("      _  ___      _          _                 ");
            writer.println("     | |/ //_  _ | | ___   _| |  ___ __ _ _ __  ");
            writer.println("     | ' //  | | | |/ /  | | | |// __// _` | '_ \\ ");
            writer.println("     | . \\   |_| |   < | |_| | | (_|   (_| | | | |");
            writer.println("     |_|\\_\\__,_|_|\\_\\__,_|_|\\___\\____|_| |_|");
            writer.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            writer.println("[Usuario]: " +us);
            writer.println();
            writer.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            Date date = new Date();
            writer.println("[Fecha(dd/mm/yr)]: " +date.toString());
            writer.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            writer.println();
            for(int i = 1; i < shopping_kart_money_original.size(); i++){//para cada elmento del shopping cart se le hace suma, esto para poder conocer el subtotal de todos los elementos en el carrito sin el descuento
                sum_or += shopping_kart_money_original.get(i);
            }
            for(int i = 1; i < shopping_kart_money.size(); i++){//para cada elemento del shopping cart se le hace suma,esto para conocer el total de todos los elementos en el carrito con el descuento
                sum += shopping_kart_money.get(i);
            }
            Set<String> printed = new HashSet<>(); //se crea un hash llamado printed
            shopping_kart_items.stream().filter((s) -> (printed.add(s)) // set.add () te dice si el elemento esta en el set, esto para saber cuantos productos hay por cada uno
            ).forEachOrdered((s) -> {
                writer.println("Producto: " + s
                        + ", cantidad: " + Collections.frequency(shopping_kart_items, s)); //se imprime el producto, con la cantidad (frecuencia) que aparecen en el set
            });
            writer.println();
            writer.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            writer.println();
            writer.println(subtotal_cost);
            writer.println(total_cost);
            writer.println();
            writer.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            writer.println("		   Gracias por su compra");
            writer.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            writer.println();
            writer.println("            I.V.A Incluido en todos los productos");
            writer.println();
            writer.println("|||||| ||||||| ||||| ||||||||||| |||||| |||| ||| || ||||");
            writer.println("|||||| ||||||| ||||| ||||||||||| |||||| |||| ||| || ||||");
            writer.println("|||||| ||||||| ||||| ||||||||||| |||||| |||| ||| || ||||");
            writer.println("|||||| ||||||| ||||| ||||||||||| |||||| |||| ||| || ||||");
            writer.println("| 	    2 5 4 5 5 6 4 4 6 2 4 6 8 4  55 5          |");
            writer.close();
        } //double con suma
    }
       
    public static void printGrid(String[][] a, String file) throws IOException{
       for(int i = 0; i < countLines(file); i++)
       {
          for(int j = 0; j < 5; j++)
          {
             System.out.printf(a[i][j]);
          }
          System.out.println();
       }
    }

    public static int countLines(String filename) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        }
    }
    
//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    
}