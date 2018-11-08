/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdtransactionsmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rui Paredes
 */
public class MultiQueries implements Runnable {

    public void run() {
        System.out.println("MyClass running");
        resultadoQuery("Begin Transaction update Factura set Nome = 'JoaoFranchesca' where Factura.FacturaID = 1 WAITFOR DELAY '00:00:10' ROLLBACK;");
    }
    
     public static ResultSet resultadoQuery(String query) {
        Sql sqlconnection = new Sql();
        Connection conne = null;
        Statement stmt = null;
        try {
            conne = sqlconnection.conect();

            if (conne != null) {

                stmt = conne.createStatement();
                String selectQ = query;
                ResultSet rset = stmt.executeQuery(selectQ);
                return rset;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
