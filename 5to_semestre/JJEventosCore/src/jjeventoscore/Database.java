/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjeventoscore;

/**
 *
 * @author Juan Ca
 */
import com.mysql.jdbc.AbandonedConnectionCleanupThread.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.util.Calendar;
import java.sql.*;
import java.util.Scanner;

public class Database {
    
    public static void main(String[] args){
        insert_client();
    }
    public static void insert_client(){
        Connection con = null;
        Statement st = null;
        ResultSet rs =null;
        try{
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jjeventos","root","");        
            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into clients ("
                    + "Client_ID,"
                    + "Name,"
                    + "Last,"
                    + "Hour_st,"
                    + "H_phone,"
                    + "M_phone,"
                    + "Email,"
                    + "Event_id,"
                    + "Ex_phone,"
                    + "Location_id,"
                    + "Location_corn."
                    + "Location_reference,"
                    + "Guests,"
                    + "Location_cat,"
                    + "Guests_range,"
                    + "Medium)"
              + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, "Barney");
            preparedStmt.setString (2, "Rubble");
            preparedStmt.setDate   (3, startDate);
            preparedStmt.setBoolean(4, false);
            preparedStmt.setInt    (5, 5000);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public static void inline(){
    System.out.print(">");
    }
}

