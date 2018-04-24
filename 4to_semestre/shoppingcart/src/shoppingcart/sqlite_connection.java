/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.*;
import static shoppingcart.Shoppingcart.capitalize;
import static shoppingcart.Shoppingcart.category_1;
import static shoppingcart.Shoppingcart.category_2;
import static shoppingcart.Shoppingcart.category_default;
import static shoppingcart.Shoppingcart.exit;
import static shoppingcart.Shoppingcart.loading_animation;
import static shoppingcart.Shoppingcart.price_discount;
import static shoppingcart.Shoppingcart.promt;
import static shoppingcart.Shoppingcart.shopping_kart_items;
import static shoppingcart.Shoppingcart.shopping_kart_money;
import static shoppingcart.Shoppingcart.shopping_kart_money_original;
import static shoppingcart.encryption.encryption;
import static shoppingcart.Shoppingcart.us;

/**
 *
 * @author Juan Ca
 */
public class sqlite_connection {

    public static void create() {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Products.db");
         System.out.println("");

         stmt = c.createStatement();
         String sql = "CREATE TABLE PRODUCTOS " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " + 
                        " CATEGORY       TEXT    NOT NULL, " + 
                        " PRICE          TEXT    NOT NULL, " +
                        " DISCOUNT       TEXT    NOT NULL, " +
                        " RATING         TEXT    NOT NULL)";
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
  
    public static void create_users() {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Users.db");
         System.out.println("");

         stmt = c.createStatement();
         String sql = "CREATE TABLE USUARIOS " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " USER           TEXT    NOT NULL, " + 
                        " PASSWORD       TEXT    NOT NULL, " + 
                        " SECURITY          TEXT    NOT NULL)";
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
  
    public static void insert_users_initial(){ 
        Connection c = null;
        Statement stmt = null;
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        Scanner keyboard3 = new Scanner(System.in);
        Scanner keyboard4 = new Scanner(System.in);
        System.out.println("Ingresar Usuario:");
        String user = keyboard.nextLine();
        //checar si existe el usuario en la base de datos
        boolean exists = exists(user);
        if(exists == false){
            System.out.println("Ingresar contraseña");
            System.out.print(promt);
            String password = keyboard2.nextLine();
            System.out.println("Confirmar contraseña");
            System.out.print(promt);
            String password2 = keyboard2.nextLine();
            if(password.equals(password2)){
                System.out.println("Ingresar respuesta de seguridad. Cuál es el nombre de tu mascota? (esta respuesta no es modificable)");
                System.out.print(promt);
                String security = keyboard3.nextLine();
                System.out.println("Confirmar respuesta de seguridad");
                System.out.print(promt);
                String security2 = keyboard4.nextLine();
                if(security.equals(security2)){
                    try {
                        Class.forName("org.sqlite.JDBC");
                        c = DriverManager.getConnection("jdbc:sqlite:Users.db");
                        c.setAutoCommit(false);
                        System.out.println("");
                        int ID = lastID()+1;
                        stmt = c.createStatement();
                        String sql = "INSERT INTO USUARIOS (ID,USER,PASSWORD,SECURITY) " +
                                 "VALUES ("+ID+ ",'"+user+"','"+encryption(password)+"','"+encryption(security)+"');";//arreglar esto
                        stmt.executeUpdate(sql);
                        stmt.close();
                        c.commit();
                        c.close();
                        } catch ( Exception e ) {
                            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                            System.exit(0);
                        }
                        System.out.println("Usuario registrado satisfactoriamente");
                }
            }
            else{
                System.out.println("Registro no exitoso, favor de volver a intentar");
            }
        }
        else{
            System.out.println("El usuario ya existe. Ir a la opcion 3");
        }
    }
  
    public static boolean exists(String user){
        Connection c = null;
        Statement stmt = null;
        int exist = 0;
        int contin = 0;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:Users.db");
                c.setAutoCommit(false);
                System.out.println(""); 
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
                while ( rs.next() && contin == 0) {
                    String User = rs.getString("USER");
                    if(User.equals(user)){
                        exist = 1;
                        contin = 1;
                    }
                }
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
        if(exist == 1){
            return true;
        }
        else{
            return false;
        }
  }
    
    public static boolean exists_ID(Integer numb){
        Connection c = null;
        Statement stmt = null;
        int exist = 0;
        int contin = 0;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:Products.db");
                c.setAutoCommit(false);
                System.out.println("");
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCTOS;" );
                while ( rs.next() && contin == 0) {
                    String ID = rs.getString("ID");
                    if(Integer.parseInt(ID) == numb){
                        exist = 1;
                        contin = 1;
                    }
                }
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
        if(exist == 1){
            return true;
        }
        else{
            return false;
        }
  }
  
    public static boolean login_sql() throws InterruptedException{
        Connection c = null;
        Statement stmt = null;
        Scanner keyboard = new Scanner(System.in);//inicializacion del scanner
        String promt = ">";
        int counter = 0; //variable para contar el numero de intentos
        boolean allowed = false; //variable booleana para saber si se permite el login o no
        boolean p_equals = false;
        while(counter < 3 && allowed == false){ //si el contador es menor a 3 y la variable allowed es igual a falso entonces se ejecuta la accion
            System.out.println("Ingresar usuario");//se imprime ingresar usuario
            System.out.print(promt);//se imprime en la misma linea promt
            String user = keyboard.nextLine();//se pide que el usuario ingrese su usuario
            us = user;
            System.out.println("Ingresar Contraseña"); //se imprime ingresar contraseña
            System.out.print(promt); //se imprime en la misma linea promt
            String password = keyboard.nextLine(); //se pide que el usuario ingrese si contraseña
            String pass = encryption.encryption(password); //el string pass es igual a el valor dado por la funcion encrypt(la cual encripta la contraseña)con el parametro de la variable password(pedida en la linea de arriba)
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:Users.db");
                c.setAutoCommit(false);
                System.out.println("");
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
                while ( rs.next() ) {
                    String User = rs.getString("USER");
                    String Password = rs.getString("PASSWORD");
                    if(User.equals(us) && Password.equals(pass)){
                        return true;
                    }
                }
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            counter ++;
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
                int validity = 0;
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:Users.db");
                    c.setAutoCommit(false);
                    System.out.println("");    
                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
                    while (rs.next()){
                        String User = rs.getString("USER");
                        String Security = rs.getString("SECURITY");
                        if(User.equals(user) && Security.equals(u_a)){
                            System.out.println();
                            System.out.println("Identidad verificada");
                            System.out.println("");
                            validity =1;
                        }
                    }
                    stmt.close();
                    c.close();
                } catch ( Exception e) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.exit(0);  
                }
                if(validity == 1){
                    update_password(user);
                }
                else{
                    System.out.println("Respuesta incorrecta");
                }
                break;
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

    public static void print_products() {
        Connection c = null;
        Statement stmt = null;
        ArrayList<String> categories = new ArrayList<>();
        //arreglar esto, solo inserta una categoria 
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Products.db");
            c.setAutoCommit(false);
            System.out.println("");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCTOS;" );
            while ( rs.next() ) {
                int ID = rs.getInt("ID");
                String  Name = rs.getString("NAME");
                String  Price = rs.getString("PRICE");
                String  Discount = rs.getString("DISCOUNT");
                String  Rating = rs.getString("RATING");
                String  Category = rs.getString("CATEGORY");
                categories.add(Category);
                Set<String> hs = new HashSet<>();
                hs.addAll(categories);
                categories.clear();
                categories.addAll(hs);
                if(Category.equals(categories.get(0))){
                    category_1.add("|"+espacio(Name,15)+":  $" +espacio(Price,3)+ "|Descuento del " +Discount+ "% |Rating: " +espacio(Rating,5)+ "| ID: " +ID+"|");
                }
                else if(Category.equals(categories.get(1))){
                    category_2.add("|"+espacio(Name,15)+":  $" +espacio(Price,3)+ "|Descuento del " +Discount+ "% |Rating: " +espacio(Rating,5)+ "| ID: " +ID+"|");
                }
                else{
                    category_default.add("|"+Name+":  $" +espacio(Price,3)+ "|Descuento del " +Discount+ "% |Rating: " +espacio(Rating,5)+ "| ID: " +ID+"|");
                }
            }
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("|                PRODUCTOS DISPONIBLES EN TIENDA:              |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("| ["+capitalize(categories.get(0))+"]:                          "); //se imprime la categoria 1
            System.out.println(" -------------------------------------------------------------- ");
            category_1.forEach((item) -> { //se imprime cada elemento de la categoria 1
                System.out.println(item);
                System.out.println("|--------------------------------------------------------------|");
            });
            System.out.println("");
            System.out.println("| ["+capitalize(categories.get(1))+"]:"); //se imprime la categoria 1
            System.out.println("|--------------------------------------------------------------|");
            category_2.forEach((item) -> {//se imprime cada elemento de la categoria 2
                System.out.println(item);
                System.out.println("----------------------------------------------------------------");
            });
            if(category_default.size() > 0){
                System.out.println("");
                System.out.println("| [Otros]:"); //se imprime la categoria 1
                System.out.println(" -------------------------------------------------------------- ");
                category_default.forEach((item) -> {//se imprime cada elemento de la categoria 2
                    System.out.println(item);
                    System.out.println("|--------------------------------------------------------------|");
                });
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
    public static String product_info(Integer ID_us){
    Connection c = null;
    Statement stmt = null;
    String product_info = "";
    try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:Products.db");
       c.setAutoCommit(false);
       stmt = c.createStatement();
       ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCTOS;" );
       while ( rs.next() ) {
          int ID = rs.getInt("ID");
          String  Name = rs.getString("NAME");
          String  Price = rs.getString("PRICE");
          String  Discount = rs.getString("DISCOUNT");
          String  Rating = rs.getString("RATING");
         if(ID == ID_us){
             product_info = Integer.toString(ID)+","+Name+","+Price+","+Discount;
         }
       }
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println("error");
    }
    return product_info;
    }
    
    public static void adding_to(){//funcion para añadir productos al carrito
        Scanner keyboard = new Scanner(System.in);//inicializacion del scanner
        Scanner keyboard2 = new Scanner(System.in);
        Scanner key = new Scanner(System.in);
        boolean valid_product = true;
        boolean repetition = false;//variable repeticion establecida en false
        while(repetition == false){
            System.out.println("Desea agregar algun producto? y/n");//se pregunta si se quiere añadir un producto
            System.out.print(promt);
            String selection = keyboard.nextLine();//ingresa valor
            switch (selection.toLowerCase()) {//se hace el switch con lo que el usuario ingreso en minusculas
                case "y": //caso y
                    System.out.println("Ingresar ID del producto a añadir");
                    System.out.print(promt);
                    Integer product = keyboard2.nextInt(); //ingresar el id del producto a añadir
                    System.out.println("Ingresar la cantidad a añadir"); //ingresar cantidad de productos
                    System.out.print(promt);
                    String[] arry = product_info(product).split(",");
                    int times = key.nextInt();
                        if(exists_ID(product)){ //si existe el producto entonces se realiza la operacion
                            for(int i = 0; i < times;i++){//añadir los productos al carrito la cantidad de veces que se ingreso
                                shopping_kart_items.add(arry[1]);
                                String price = arry[2]; //el precio es igual el valor en el array en el indice x subindice 3
                                String discount = arry[3]; //el descuenbto es el valor en el array en el indice x subindice 4
                                int price_int = parseInt(price); //se pasa el precio a int
                                shopping_kart_money_original.add(price_int);//se añade a el costo original del producto
                                price_discount(shopping_kart_money, price, discount);//se añade el precio ya con el descuento
                                valid_product = true;
                            }
                        }
                        else{
                            valid_product = false;
                        }
                    if(valid_product == false){
                        System.out.println("");
                        System.out.println("Producto no valido, ingresar otro ID");
                        System.out.println("");
                    } 
                    break;
                case "n": //en caso de que no se desee agregar, entonces se rompe el loop
                    repetition = true;
                    break;
                default://default
                    System.out.println("Valor invalido");
                    break;
            }
        }    
    }
      
    public static int lastID(){
        Connection c = null;
        Statement stmt = null;
        int exist = 0;
        int ID = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Users.db");
            c.setAutoCommit(false);
            System.out.println("");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
            while ( rs.next() ) {
                ID = rs.getInt("ID");
            }
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return ID;
   }
   
    public static void update_password(String user){//modificar
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);    
        System.out.println("Ingresar nueva contraseña");
        System.out.print(promt);
        String new_password = keyboard.nextLine();//se pide que ingrese la nueva contraseña
        String en_password = encryption(new_password);
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Users.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE USUARIOS set PASSWORD = '"+en_password+"' where USER='"+user+"';";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Contraseña Actualizada!");
        exit();
   }
    
    public static void recover_password(){
        Scanner keyboard = new Scanner(System.in);
        Connection c = null;
        Statement stmt = null;
        System.out.println("Ingresar usuario"); //se pide que ingrese su usuario
        System.out.print(promt);
        String user = keyboard.nextLine();
        System.out.println("¿Cuál es el nombre de tu mascota?");//se pide que ingrese el nombre de su mascota
        System.out.print(promt);
        String user_answer = keyboard.nextLine();
        String u_a = encryption.encryption(user_answer); //el string u_a es igual al resultado de encriptar la respuesta del usuario
        int validity = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Users.db");
            c.setAutoCommit(false);
            System.out.println("");    
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
            while (rs.next()){
                String User = rs.getString("USER");
                String Security = rs.getString("SECURITY");
                if(User.equals(user) && Security.equals(u_a)){
                    System.out.println();
                    System.out.println("Identidad verificada");
                    System.out.println("");
                    validity =1;
                }
            }
            stmt.close();
            c.close();
        } catch ( Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);  
        }
        if(validity == 1){
            update_password(user);
        }
        else{
            System.out.println("Nombre de usuario o respuesta de seguridad incorrectos");
            System.out.println("");
        }
    }
    
    public static String espacio(String PAL, int TAM){
        while(PAL.length()<TAM){
            PAL+=" ";
        }
        return PAL;
    }
    
    
}