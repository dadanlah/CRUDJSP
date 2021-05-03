package com.connection;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Maconnection {
    
    public static Connection Connect() throws SQLException{
    
        
               Connection conn = null;
               String pilote = "oracle.jdbc.driver.OracleDriver";
               
           try {
               Class.forName(pilote);
               conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BIGA","biga*ranx");
              
               
           } catch (ClassNotFoundException ex) {
               
               Logger.getLogger(Maconnection.class.getName()).log(Level.SEVERE, null, ex);
               return null;
           }
      return conn;
    }
    
}
