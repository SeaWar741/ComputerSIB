/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbctestexternal;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;



/**
 *
 * @author Juan Ca
 */
public class Jdbctestexternal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try{
          String myDriver = "org.gjt.mm.mysql.Driver";
          String myUrl = "jdbc:mysql://192.168.1.66:3306/jjeventoscore";
          Class.forName(myDriver);
          Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "Tosj680910ux3=");
          String query = "SELECT * FROM client";
          Statement st = (Statement) conn.createStatement();
          ResultSet rs = st.executeQuery(query);
          while (rs.next()){
           String name = rs.getString("name");
                String last = rs.getString("last");
                String h_phone = rs.getString("h_phone");
                String m_phone = rs.getString("m_phone");
                String of_phone = rs.getString("of_phone");
                String ex_phone = rs.getString("ex_phone");
                String email = rs.getString("email");
                String medium = rs.getString("medium");
              System.out.println(name+" "+last);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
}
