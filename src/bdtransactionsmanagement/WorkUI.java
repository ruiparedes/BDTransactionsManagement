/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDTransactionsManagement;


import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Yoann Resende
 */
public class WorkUI extends javax.swing.JFrame {

    /**
     * Creates new form WorkUI
     */
    public WorkUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Número de operações");

        jLabel3.setText("Inserir");

        jLabel4.setText("Delete");

        jLabel5.setText("Update");

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("20%");

        jLabel7.setText("30%");

        jLabel8.setText("50%");

        jLabel9.setText("Work");

        jTextField1.setEditable(false);

        jLabel10.setText("Tempo de execução");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(54, 54, 54)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int n = Integer.parseInt(jTextField2.getText());
        Random aleat = new Random();
        int nbalea;
        //isolationlevel = jComboBox1.getSelectedItem().toString();
        for(int i = 1 ; i <= n ; i++) {
            nbalea = aleat.nextInt(100);
            if(nbalea < 20) {
                    insert();
            }else if(20 <= nbalea && nbalea < 50){
                    delete();
            }else {
                    update();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WorkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
    private Date date = new Date() ; 
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://;databaseName=TBD_TRAB1";
    private String username = "aluno";
    private String password = "aluno";
    private ResultSet rs = null;
    private String ref = "";
    //private String isolationlevel;

   private void update() {
        query("select MAX(FacturaID) from Factura;");
        int maxfact = 0;
        try {
            if (rs.next()) {
                    maxfact = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs = null;
        Random rd = new Random();
        int rand = rd.nextInt(maxfact+1);
        boolean valueIsPresent = false;
        query("select * from Factura where FacturaID = " + rand + ";");
        try {
            if (rs.next()) {
                valueIsPresent = true;
            }
            while(valueIsPresent == false){
               rand = rd.nextInt(maxfact+1); 
               query("select * from Factura where FacturaID = " + rand + ";"); 
               if (rs.next()) {
                    valueIsPresent = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        date = new Date() ;
        ref = dateFormat.format(date).toString();
        
        try {
            query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('U','Begin Transaction', " + rand + "," +ref + ");");
            query_uid("UPDATE Factura SET nome = 'ABC' where FacturaID = " + rand + ";");// set transaction isolation level " + isolationlevel + " select Nome from Factura where FacturaID = " + rand + ";");
            query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('U','COMMIT', " + rand + "," + ref + ");");
        } catch (ClassNotFoundException | SQLException ex) {
            query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('U','ROLLBACK'," + rand + "," + ref + ");");
        }        
   }

	private void delete() {
            query("select MAX(FacturaID) from Factura;");
            int maxfact = 0;
            try {
                if (rs.next()) {
                    maxfact = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Random rd = new Random();
            int rand = rd.nextInt(maxfact+1); 
            boolean valueIsPresent = false;
            query("select * from Factura where FacturaID = " + rand + ";");
            try {
                if (rs.next()) {
                    valueIsPresent = true;
                }
                while(valueIsPresent == false){
                   rand = rd.nextInt(maxfact+1); 
                   query("select * from Factura where FacturaID = " + rand + ";"); 
                   if (rs.next()) {
                        valueIsPresent = true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            date = new Date() ;
            ref = dateFormat.format(date).toString();
            
            try {
                query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('D','Begin Transaction'," + rand + "," + ref + ");");
                query_uid("Delete from FactLinha where FactLinha.FacturaID = " + rand + " Delete from Factura where Factura.FacturaID = " + rand + ";");//set transaction isolation level " + isolationlevel + " select * from  FactLinha,Fatura where Factura.FacturaID = FactLinha.FacturaID and Factura.FacturaID = " + rand + ";");
                query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('D','COMMIT', " + rand + "," + ref + ");");
            } catch (ClassNotFoundException | SQLException ex) {
                query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('D','ROLLBACK'," + rand + "," + ref + ");");
            }
	}

	private void insert() {
            query("select MAX(FacturaID) from Factura;");
            int maxfact = 0;
            try {
                if (rs.next()) {
                    maxfact = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int newfactid = maxfact +1;
            int cliente = 5;
            int produto1 = 10;
            int produto2 = 11;
            double preco1 = 10;
            double preco2 = 153.99;
            int qtd1 = 1;
            int qtd2 = 2;
            date = new Date() ;
            ref = dateFormat.format(date).toString();
            try {
                query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('I','Begin Transaction', " + newfactid + "," + ref + ");");
                query_uid("INSERT INTO Factura(FacturaID,ClienteID,Nome) VALUES (" + newfactid  +"," + cliente + ",'Insert Nome') INSERT INTO FactLinha(FacturaID,ProdutoID,Designacao,Preco,Qtd) VALUES (" + newfactid  +"," + produto1+",'Insert Produto'," + preco1 +","+ qtd1 +") INSERT INTO FactLinha(FacturaID,ProdutoID,Designacao,Preco,Qtd) VALUES (" + newfactid  +"," + produto2+",'Insert Produto'," + preco2 +","+ qtd2 +");");// set transaction isolation level " + isolationlevel + " select Factura.FacturaID,ClienteID,Nome,FactLinha.FacturaID,Designacao,Preco,Qtd from Factura,FactLinha where Factura.FacturaID = FactLinha.FacturaID and Factura.FacturaID = " + newfactid + ";");
                query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('I','COMMIT', " + newfactid + "," + ref + ");");
            } catch (ClassNotFoundException | SQLException ex) {
                query("Insert into LogOperations(EventType,Objecto,Valor,Referencia) Values ('I','ROLLBACK'," + newfactid + "," + ref + ");");
            }
            	
	}

   private void query(String sql){
      rs = null;
      try{
          Class.forName(driver).newInstance();
          Connection con = DriverManager.getConnection(url, username, password);
          Statement stat = con.createStatement();
          rs = stat.executeQuery(sql);
      }catch (Exception e){
          //JOptionPane.showMessageDialog(this, e.getMessage());
      }
  }
   
  private void query_uid(String sql)throws ClassNotFoundException, SQLException{ //Update/Insert/Delete
        long tinicial = System.currentTimeMillis();
        Class.forName(driver);  
        Connection con = DriverManager.getConnection(url, username, password);
        try{
          con.setAutoCommit(false);
          PreparedStatement pst = con.prepareStatement(sql);
          /*switch(jComboBox1.getSelectedIndex()){
            case 1:
                con.setTransactionIsolation(con.TRANSACTION_READ_UNCOMMITTED);
                break;
            case 2:
                con.setTransactionIsolation(con.TRANSACTION_READ_COMMITTED);
                break;
            case 3:
                con.setTransactionIsolation(con.TRANSACTION_REPEATABLE_READ);
                break;
            case 4:
                con.setTransactionIsolation(con.TRANSACTION_SERIALIZABLE);
                break;

        }*/
          pst.executeUpdate();
          long tfinal = System.currentTimeMillis() - tinicial;
          jTextField1.setText(String.valueOf((tfinal) / 1000.0));
          System.out.println("Tempo de Pesquisa = " + (tfinal) / 1000.0 + " segundos\n");
          //Statement stat = con.createStatement();
          //stat.executeQuery(sql);
          con.commit();
        }catch (SQLException e){
           //JOptionPane.showMessageDialog(this, e.getMessage());
           con.rollback();
        }
 }
}
