/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdtransactionsmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rui Paredes
 */
public class Sql {

    public static void main(String[] args)  {

    }
    
    public Connection conect() throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TBD_TRAB1", "Admin", "123qwe.");

            if (conn != null) {
                System.out.println("Database Successfully connected");
                return conn;
            }

        } catch (SQLException e) {
            e.printStackTrace();   
        }
        return null;
    }
    
    
    
}
