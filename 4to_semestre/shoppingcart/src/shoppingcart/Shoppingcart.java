/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.awt.Desktop;
import static java.lang.Integer.parseInt;
import java.util.*;
import static java.util.Objects.hash;
import static javax.script.ScriptEngine.FILENAME;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Shoppingcart {
    //class constants
    public static Set<String> category_1 = new TreeSet<>();
    public static Set<String> category_2 = new TreeSet<>();
    public static ArrayList<String> shopping_kart_items = new ArrayList<String>();
    public static ArrayList<Integer> shopping_kart_money_original = new ArrayList<Integer>();
    public static ArrayList<Integer> shopping_kart_money = new ArrayList<Integer>();
    public static String security_question = "¿Cúal el nombre de tu primer mascota?";
    public static String promt = ">";
    private static HashMap<String, String> hmap = new HashMap<>();
    private static HashMap<String,String> security = new HashMap<>();
    private static final String FILENAME = "users.txt";
    public static String[][] elements = new String[6][10]; 
    public static String total_cost;
    public static String subtotal_cost;
    private static String us;
    //end class constants
    public static void main(String[] args) throws InterruptedException, IOException {
        //(UTILIZAR LOOP Y CORRERLO PARA METODO DE RECURSION)boolean play = true; Metodo necesita perfeccionamiento
        Scanner keyboard = new Scanner(System.in);
        //Solucion temporal, pasar a un archivo .txt encriptado(contraseñas y usuarios) con la api de dropbox
        /*database for user & passwords*/
        //HashMap<String, String> hmap = new HashMap<>();
            /* cuentas con contraseñas reales sin encriptar
            hmap.put("Theyought47@einrot.com","a01652138");
            hmap.put("wcena201@ndfbmail.ga","6p4deq2gcl4k8bdc");
            hmap.put("0syed.sab@pokeett.site","7clqdwqnjz7ohj8e");
            hmap.put("oali.qasem@miur.ml","4trm8owbws7au24d");
            hmap.put("idigao.pga@888z5.ml","pqat88120ibwtya0");
            hmap.put("juanca741@gmail.com","juanca741");
            hmap.put("matheo@pinzon.com.mx","matheo123");
            //encriptado
            hmap.put("Theyought47@einrot.com","efb6aacbde32d26bff954cfed9ffe3372104cf18");
            hmap.put("wcena201@ndfbmail.ga","2e07125d0b7b6ea94cad1723649137215ab09d10");
            hmap.put("0syed.sab@pokeett.site","22fa9a71b6eaf5ad83d6038f33491728982856d7");
            hmap.put("oali.qasem@miur.ml","cf2bb7ec965f090f8e48304860e2f629c0f8a99f");
            hmap.put("idigao.pga@888z5.ml","fa26e6e06ac77d53c3a0e4092af149a711c61b82");
            hmap.put("juanca741@gmail.com","c938af029a1986d6efe956ccd05dd43989b71312");
            hmap.put("matheo@pinzon.com.mx","ca9a6d03683cc471a1ef5817022d6c487e51f558");            
        /**/
        /*database for users & security answer*/
        //Base de datos con preguntas sin encriptar
        /*HashMap<String,String> security = new HashMap<>();
            security.put("Theyought47@einrot.com","pepe");
            security.put("wcena201@ndfbmail.ga","thor");
            security.put("0syed.sab@pokeett.site","gabriel");
            security.put("oali.qasem@miur.ml","kala");
            security.put("idigao.pga@888z5.ml","choli");
            security.put("juanca741@gmail.com","olita");
            security.put("matheo@pinzon.com.mx","charlott");
        /
        HashMap<String,String> security = new HashMap<>();
            security.put("Theyought47@einrot.com","17765ffe166b72d80a602ba7daaf1029c582f531");
            security.put("wcena201@ndfbmail.ga","8fdc441e668daf84f902d1dfc8de089a9579f548");
            security.put("0syed.sab@pokeett.site","0fbda0462c9539b02f0498148e0ab135031cdaa8");
            security.put("oali.qasem@miur.ml","525b752f115f4d0790fff75b07aaa3e0897832a5");
            security.put("idigao.pga@888z5.ml","c50a2b3c108227acaf199be912f963ae88e32a23");
            security.put("juanca741@gmail.com","1e54b98763365a39b9041b49e8b3fce4b5e4dcb2");
            security.put("matheo@pinzon.com.mx","charlott");
        /**/
        
        //Lista de productos sin ordernar, elemento 0(id), elemento 2(nombre), elemento 3(categoria), elemento 4(precio),elemento 5(descuento),elemento 6(rating)
        String[][] elements = { {"0","Shampoo","limpieza","50","10","5"}, 
            {"1","Deshodorante","limpieza","50","10","5"},{"2","Pasta dental","limpieza","50","10","5"},
            {"3","Gel","limpieza","50","10","5"},{"4","Jabon","limpieza","50","10","5"},
            {"5","Chocolate","comida","50","10","5"},{"6","Refesco","comida","50","10","5"},
            {"7","Sabritones","comida","50","10","5"},{"8","Chicles clorent","comida","50","10","5"},
            {"9","Gummy","comida","50","10","5"}
        };
        /**/
        reading();
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
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                System.out.println("Login invalido");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            }
            System.out.println();
            System.out.println();
        }
        //encryption password = new encryption("hola");
        /*fin del codigo*/
    }
    
    //funciones del código
    public static void welcome_menu_selection(){ //funcion de inicio, aun no esta completada, falta hacer el registro, implementar hasta 3er parcial
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
            String pass = encrypt(password); //el string pass es igual a el valor dado por la funcion encrypt(la cual encripta la contraseña)con el parametro de la variable password(pedida en la linea de arriba)
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
                String user = keyboard.nextLine();
                System.out.println("¿Cuál es el nombre de tu mascota?");//se pide que ingrese el nombre de su mascota
                String user_answer = keyboard.nextLine();
                String u_a = encrypt(user_answer); //el string u_a es igual al resultado de encriptar la respuesta del usuario
                if(u_a.equals(answers.get(user))){ //si la respuesta de seguridad es igual a lo que escribio el usuario entonces se cambia la contraseña
                    System.out.println();
                    System.out.println("Identidad verificada");
                    System.out.println("Ingresar nueva contraseña");
                    System.out.print(promt);
                    String new_password = keyboard.nextLine();//se pide que ingrese la nueva contraseña
                    String n_p = encrypt(new_password);//se encripta la nueva contraseña
                    database.put(user,n_p);//se inserta la nueva contraseña en el hash como valor del usuario
                    System.out.println();
                    System.out.println("Contraseña actualizada!");
                }
                else{ //si no es igual, entonces se deniega el acceso
                    System.out.println("Acceso denegado");
                }   break;
            case "n": //si no se quiere cambiar la contraseña entonces se dice que esta entendido
                System.out.println("Entendido");
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
    
    public static void selection_menu(String[][] elements) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException, IOException{ //funcion para la seleccion del usuario
        Scanner keyboard = new Scanner(System.in);//inicializacion del scanner
        System.out.println("Selecionar una opcion del menu");
        System.out.print(promt);
        Integer selection = keyboard.nextInt();//se pide que el usuario ingrese un numero del menu
        boolean loop_continue = true;
        while(loop_continue == true){//este loop se continuara mientras el usuario no haga el pago o haga una salida forzada
            switch (selection) {
                case 1: //caso uno es igual a 
                    Sorting_Array(elements);//<--- Imprimir la lista de productos categorizados y por orden alfabetico
                    break;
                case 2://caso dos es igual a añadir productos al carrito de compras
                    adding_to(elements);//metodo adding_to con elments(carrito)
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
        System.out.println(category.get(0)); //se imprime la categoria 1
        System.out.println("---------------------------------------------------------------");
        while(count <9){//mientras que el contador sea menor a nueve entonces se hara lo siguiente
            if(array[x][2].equals(category.get(0))){//se hace busqueda , iterando por cada indice 2 en la segunda dimension, si es igual a la categoria 1, entonces se añadira el producto a esa categoria
                category_1.add("|"+array[x][1]+ ":  $" +array[x][3]+ "   |Descuento del " +array[x][4]+ "% |Rating: " +array[x][5]+ "| ID: " +array[x][0]+"|");//formato para añadir a la categoria
            }
            x++;//se aumenta el valor de x y de count
            count ++;
        }
        category_1.forEach((item) -> { //se imprime cada elemento de la categoria 1
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
        x = 0; //se reestablece el valor de x y de count a 0
        count = 0;
        System.out.println();
        System.out.println(category.get(1));//se imprime la categoria 2
        System.out.println("---------------------------------------------------------------");
        while(count<9){//mientras que el contador sea menor a nueve entonces se hara lo siguiente
            if(array[x][2].equals(category.get(1))){//se hace busqueda , iterando por cada indice 2 en la segunda dimension, si es igual a la categoria 1, entonces se añadira el producto a esa categoria
                category_2.add("|"+array[x][1]+ ":  $" +array[x][3]+ "   |Descuento del " +array[x][4]+ "% |Rating: " +array[x][5]+ "| ID: " +array[x][0]+"|");//formato para añadir a la categoria
            }
            x++;//se aumenta el valor de x y de count
            count++;
        }
        category_2.forEach((item) -> {//se imprime cada elemento de la categoria 2
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
    }
    
    public static void adding_to(String[][] array){//funcion para añadir productos al carrito
        Scanner keyboard = new Scanner(System.in);//inicializacion del scanner
        Scanner key = new Scanner(System.in);
        boolean repetition = false;//variable repeticion establecida en false
        while(repetition == false){ //mientras que la repeticion este en false entonces se hace el loop
            System.out.println("Desea agregar algun producto?");//se pregunta si se quiere añadir un producto
            System.out.println("y/n");
            String selection = keyboard.nextLine();//ingresa valor
            int counter = 0; //variable pára contador 1
            int count = 0;//variable para contador 2
            int x = 0; //variable para  indice
            switch (selection.toLowerCase()) {//se hace el switch con lo que el usuario ingreso en minusculas
                case "y": //caso y
                    System.out.println("Ingresar ID del producto a añadir");
                    String product = keyboard.nextLine(); //ingresar el id del producto a añadir
                    System.out.println("Ingresar la cantidad a añadir"); //ingresar cantidad de productos
                    int times = key.nextInt();
                    while(count<9){//mientras que el count sea menor a nueve entonces realizar operacion
                        if(array[x][0].equals(product)){ //si i en el indice 0 es igual al producto entonces
                            for(int i = 0; i<times;i++){//añadir los productos al carrito la cantidad de veces que se ingreso
                                shopping_kart_items.add(array[x][1]);
                            }
                        }
                        x++; //aumentar el valor de x y count en 1
                        count++;
                    }
                    x = 0; //reestableceer el valor de x a 0
                    while(counter < 9){ //mientras que le contador sea menor a nueve entonces realizar operacion
                        if(array[x][0].equals(product)){ //si i en el indice 0 es igual al producto entonces
                            String price = array[x][3]; //el precio es igual el valor en el array en el indice x subindice 3
                            String discount = array[x][4]; //el descuenbto es el valor en el array en el indice x subindice 4
                            int price_int = parseInt(price); //se pasa el precio a int
                            for(int i = 0; i<times;i++){ //ingresar el costo de cada producto en el carrito, junto con su descuento
                                shopping_kart_money_original.add(price_int);//se añade a el costo original del producto
                                price_discount(shopping_kart_money, price, discount);//se añade el precio ya con el descuento
                            }
                        }
                        x ++; //se aumenta el valor de x y de counter +1
                        counter ++;
                    }
                    System.out.println("");
                    System.out.println("Productos seleccionados: " +shopping_kart_items);//imprimir lista de productos seleccionados, el subtotal y el total
                    System.out.println("Subtotal de productos seleccionados" + shopping_kart_money_original);
                    System.out.println("Total de los productos seleccionados: "+shopping_kart_money);
                    break;
                case "n": //en caso de que no se desee agregar, entonces se rompe el loop
                    repetition = true;
                    //function selection menu
                    break;
                default://default
                    System.out.println("Valor invalido");
                    break;
            }
        }
    }
    
    public static void deleting_from(ArrayList arry){//elimiar del carrito
        Scanner keyboard = new Scanner(System.in); //inicializar el scanner
        Scanner key = new Scanner(System.in);
        System.out.println("Ingresar nombre del producto a borrar"); //se pide el nombre del producto a borrar
        System.out.print(promt);
        String delete_in_product = keyboard.nextLine(); //ingresar el nombre
        String delete_product = capitalize(delete_in_product); //se le pone la primer letra como mayuscula
        System.out.println("Ingresar la cantidad de producto a eliminar");
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
        //code
        if(shopping_kart_items == null){ //si el carro no tiene nada entonces se imprime que la cuenta esta en 0 y se cierra el programa
            System.out.println("cuenta en: $0");
            exit();
        }
        else{//si no esta vacio entonces se procede al pago
            //falta implementar la verificacion de tarjetas de credito con el agoritmo de encriptacion
            display_kart();
            System.out.println("Validando pago"); 
            loading_animation();
            writting();
            System.out.println("Pago validado, Gracias Por su compra");
            System.out.println();
            Runtime rt=Runtime.getRuntime();
            String file = "Ticket.txt";
            //Process p=rt.exec("notepad " +file);
            //Runtime.getRuntime().exec("cmd /c start print.bat");
            File file2 = new File("print.bat");
            Desktop.getDesktop().open(file2);
            exit();//se cierra el programa
        }
        
    }
    
    
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
            //sleep(250);
        }
        System.out.println();
    }
    
    //encriptado de datos
    public static String encrypt(String txt) { //funcion para encriptar
        String encrypted = getHash(algorithmencrypt(txt),"Sha1"); //se pasa a hash el string, con el metodo de encriptado sha1
        return encrypted; //regresa el string encriptado
    }
    
    public static String algorithmencrypt(String txt){ //se juntan el string con el salt y se hashean
        String password = String.valueOf(hash(txt + "seawar741seawar741"));
        return password;
    }
    
    public static String getHash(String txt, String hashType){ //funcion para pasarlo a hash, con el java.security, esto hace la encriptacion, pasando el string a hash
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
            /*
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");
             */
            // Always close files.
        } //double con suma
    }
    
   public static void reading() throws IOException{
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null && !"".equals(sCurrentLine = br.readLine())) { // se hara una lectura, añadiendo la cdontraseña, usuario y respuesta a pregunta de seguridad dentro de dos hash(security y hmap)
                String[] usp = new String[3];
                usp = sCurrentLine.split(",");
                String user = usp[0];
                String pass = usp[1];
                String ans = usp[2];
                hmap.put(user,pass);
                security.put(user,ans);
            }
        }
    }
    
    public static void user_register(String user, String pass, String sec_a){
        pass = encrypt(pass);
        sec_a = encrypt(pass);
        
    }
}