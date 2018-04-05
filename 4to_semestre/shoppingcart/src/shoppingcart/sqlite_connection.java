/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.sql.*;
import java.util.*;
import static shoppingcart.Shoppingcart.capitalize;
import static shoppingcart.Shoppingcart.category_1;
import static shoppingcart.Shoppingcart.category_2;
import static shoppingcart.Shoppingcart.category_default;
import static shoppingcart.Shoppingcart.exit;
import static shoppingcart.Shoppingcart.loading_animation;
import static shoppingcart.Shoppingcart.promt;
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
         System.out.println("Opened database successfully");

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
  
  public static void create_user() {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Users.db");
         System.out.println("Opened database successfully");

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
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Users.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO USUARIOS (ID,USER,PASSWORD,SECURITY) " +
                        "VALUES (1,'juanca741@gmail.com','"+encryption("juanca741")+"','"+encryption("olita")+"');"; 
         stmt.executeUpdate(sql);
         
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
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
        String pass = encryption(password); //el string pass es igual a el valor dado por la funcion encrypt(la cual encripta la contraseña)con el parametro de la variable password(pedida en la linea de arriba)
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
                String u_a = encryption(user_answer); //el string u_a es igual al resultado de encriptar la respuesta del usuario
                int validity = 0;
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:Users.db");
                    c.setAutoCommit(false);
                    System.out.println("Opened database successfully");
                
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
      System.out.println("Opened database successfully");

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
            category_1.add("|"+Name+":  $" +Price+ "   |Descuento del " +Discount+ "% |Rating: " +Rating+ "| ID: " +ID+"|");
         }
         else if(Category.equals(categories.get(1))){
            category_2.add("|"+Name+":  $" +Price+ "   |Descuento del " +Discount+ "% |Rating: " +Rating+ "| ID: " +ID+"|");
         }
         else{
            category_default.add("|"+Name+":  $" +Price+ "   |Descuento del " +Discount+ "% |Rating: " +Rating+ "| ID: " +ID+"|");
         }
      }

      System.out.println("|-------------------------------------------------------------|");
      System.out.println("|               PRODUCTOS DISPONIBLES EN TIENDA:              |");
      System.out.println("|-------------------------------------------------------------|");
      System.out.println("| ["+capitalize(categories.get(0))+"]:                        "); //se imprime la categoria 1
      System.out.println(" ------------------------------------------------------------- ");
      category_1.forEach((item) -> { //se imprime cada elemento de la categoria 1
            System.out.println(item);
            System.out.println("|-------------------------------------------------------------|");
        });
      System.out.println("");
      System.out.println("| ["+capitalize(categories.get(1))+"]:"); //se imprime la categoria 1
      System.out.println("|-------------------------------------------------------------|");
      category_2.forEach((item) -> {//se imprime cada elemento de la categoria 2
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
      if(category_default.size() > 0){
      System.out.println("");
      System.out.println("| [Otros]:"); //se imprime la categoria 1
      System.out.println(" ------------------------------------------------------------- ");
      category_default.forEach((item) -> {//se imprime cada elemento de la categoria 2
            System.out.println(item);
            System.out.println("|-------------------------------------------------------------|");
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
   
   public static void insert(){ 
   Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Products.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (1,'Deshodorante','limpieza','50','10','5');"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (2,'Pasta dental','limpieza','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (3,'Gel','limpieza','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (4,'Jabon','limpieza','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (5,'Chocolate','comida','50','10','5');"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (6,'Refesco','comida','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (7,'Sabritones','comida','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (8,'Chicles clorent','comida','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO PRODUCTOS (ID,NAME,CATEGORY,PRICE,DISCOUNT,RATING) " +
                        "VALUES (9,'Gummy','comida','50','10','5');"; 
         stmt.executeUpdate(sql);
         
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
   
   public static void update_password(String user){//modificar
   /*Connection c = null;
   Statement stmt = null;*/
   Scanner keyboard = new Scanner(System.in);
   Scanner keyboard2 = new Scanner(System.in);
   if(user.equals(null)){
       System.out.println("Ingresar Usuario:");
       user = keyboard.nextLine();
   }
    
    System.out.println("Ingresar nueva contraseña");
    System.out.print(promt);
    String new_password = keyboard.nextLine();//se pide que ingrese la nueva contraseña
    String en_password = encryption(new_password);
    /*
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Users.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "UPDATE USUARIOS set PASSWORD ="+new_password+" where USER ="+user+";";
        stmt.executeUpdate(sql);
        c.commit();
        
        stmt.close();
        c.close();
    } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
    }
        System.out.println("Contraseña actualizada!");
   }
   
   /*
                    
                    String new_password = keyboard.nextLine();//se pide que ingrese la nueva contraseña
                    String n_p = encrypt(new_password);//se encripta la nueva contraseña
                    database.put(user,n_p);//se inserta la nueva contraseña en el hash como valor del usuario
                    System.out.println();
                    System.out.println("Contraseña actualizada!");
                }
                else{ //si no es igual, entonces se deniega el acceso
                    System.out.println("Acceso denegado");
                }   break;
            */
 Connection c = null;
   Statement stmt = null;
   
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Users.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

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
   
   /*public static void delete(){//modificar
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "DELETE from COMPANY where ID=2;";
         stmt.executeUpdate(sql);
         c.commit();

         ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
         
         while ( rs.next() ) {
         int id = rs.getInt("id");
         String  name = rs.getString("name");
         int age  = rs.getInt("age");
         String  address = rs.getString("address");
         float salary = rs.getFloat("salary");
         
         System.out.println( "ID = " + id );
         System.out.println( "NAME = " + name );
         System.out.println( "AGE = " + age );
         System.out.println( "ADDRESS = " + address );
         System.out.println( "SALARY = " + salary );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }

*/
}