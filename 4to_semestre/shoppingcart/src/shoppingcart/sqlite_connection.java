/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.sql.*;
import java.util.*;
import static shoppingcart.Shoppingcart.category_1;
import static shoppingcart.Shoppingcart.category_2;
import static shoppingcart.Shoppingcart.category_default;

/**
 *
 * @author Juan Ca
 */
public class sqlite_connection {

    /**
     * @param args the command line arguments
     */
  public static void main( String args[] ) {
      select();
  }
  
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

   public static void select() {
   Connection c = null;
   Statement stmt = null;
   ArrayList<String> categories = new ArrayList<>();
   //arreglar esto, solo inserta una categoria 
   Set<String> hs = new HashSet<>();//hash set para insertar las categorias
   hs.addAll(categories);
   categories.clear(); //arreglar codigo para que funcione con bases de datos sqlite, hace el display de los productos pero no logra mostrar la segunda categoria
   categories.addAll(hs);
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
      
      System.out.println(categories.get(0));
      category_1.forEach((item) -> { //se imprime cada elemento de la categoria 1
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
      System.out.println("");
      System.out.println(categories.get(0));
      category_2.forEach((item) -> {//se imprime cada elemento de la categoria 2
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
      
      category_default.forEach((item) -> {//se imprime cada elemento de la categoria 2
            System.out.println(item);
            System.out.println("---------------------------------------------------------------");
        });
      
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Operation done successfully");
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
   /*
   public static void update(){//modificar
          Connection c = null;
   Statement stmt = null;
   
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Products.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
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
   /*
   public static void delete(){//modificar
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
