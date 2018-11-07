/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdtransactionsmanagement;

import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;

/**
 *
 * @author Rui Paredes
 */
public class BrowserUI extends javax.swing.JFrame {

    private ScheduledFuture<?> futureTask;
    private Runnable refreshRunnable;
    private ScheduledExecutorService scheduledExecutorService;
    public int refreshTime = 1;
    public int faturaSelecionada = -1;

    /**
     * Creates new form BrowserUI
     */
    public BrowserUI() {
        initComponents();
        getFaturasTable();
        
        refreshTime_textField.setHorizontalAlignment(refreshTime_textField.CENTER);
        scheduledExecutorService = Executors.newScheduledThreadPool(5);
        
        refreshRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Tempo refresh:" + refreshTime);
                getFaturasTable();
                getFaturasListaTable(faturaSelecionada);
            }
        };
        changeReadInterval(refreshTime);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Faturas_Table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        FaturaLinhas_Table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        refreshTime_textField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        refresh_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Browser");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Faturas");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Linhas da Fatura");

        Faturas_Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Faturas_Table.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Faturas_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FacturaID", "ClienteID", "Nome", "Morada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Faturas_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Faturas_Table.getTableHeader().setReorderingAllowed(false);
        Faturas_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Faturas_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Faturas_Table);

        FaturaLinhas_Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FaturaLinhas_Table.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        FaturaLinhas_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FacturaID", "ProdutoID", "Designação", "Preço", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FaturaLinhas_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        FaturaLinhas_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(FaturaLinhas_Table);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setText("Browser");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Atualização: ");

        refreshTime_textField.setText("1");
        refreshTime_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTime_textFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("(s)");

        refresh_button.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        refresh_button.setText("Refresh");
        refresh_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh_buttonMouseClicked(evt);
            }
        });
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(refreshTime_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(refresh_button))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(refreshTime_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(refresh_button)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void changeReadInterval(long time) {
        if (refreshTime > 0) {
            if (futureTask != null) {
                futureTask.cancel(true);
            }

            futureTask = scheduledExecutorService.scheduleAtFixedRate(refreshRunnable, 0, time, TimeUnit.SECONDS);
        }
    }
    private void Faturas_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Faturas_TableMouseClicked
        int column = 0;
        int row = Faturas_Table.getSelectedRow();
        int faturaID = (Integer) Faturas_Table.getModel().getValueAt(row, column);
        System.out.println(faturaID);
        faturaSelecionada = faturaID;
        getFaturasListaTable(faturaID);

    }//GEN-LAST:event_Faturas_TableMouseClicked

    private void refreshTime_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTime_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshTime_textFieldActionPerformed

    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void refresh_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_buttonMouseClicked
        refreshTime = Integer.parseInt(refreshTime_textField.getText());
        System.out.println("Tempo Atual de refresh:" + refreshTime);
        changeReadInterval(refreshTime);
    }//GEN-LAST:event_refresh_buttonMouseClicked

    /**
     * @param args the command line arguments
     */
    public void getFaturasTable() {

        String getFaturasQuery = "SELECT * FROM dbo.Factura";
        ResultSet resFaturas = resultadoQuery(getFaturasQuery);
        Faturas_Table.setModel(DbUtils.resultSetToTableModel(resFaturas));
        Faturas_Table.setDefaultEditor(Object.class, null);

    }

    public void getFaturasListaTable(int faturaID) {

        String getFaturaListaQuery = "SELECT * FROM dbo.FactLinha where FacturaID =" + faturaID;
        ResultSet resFaturaLista = resultadoQuery(getFaturaListaQuery);
        FaturaLinhas_Table.setModel(DbUtils.resultSetToTableModel(resFaturaLista));
        FaturaLinhas_Table.setDefaultEditor(Object.class, null);

    }

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
            java.util.logging.Logger.getLogger(BrowserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrowserUI().setVisible(true);

            }
        });
    }

    public static ResultSet resultadoQuery(String query) {
        Sql sqlconnection = new Sql();
        Connection conne = null;
        Statement stmt = null;
        try {
            conne = sqlconnection.conect();

            if (conne != null) {
                System.out.println("Database Successfully connected");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FaturaLinhas_Table;
    private javax.swing.JTable Faturas_Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField refreshTime_textField;
    private javax.swing.JButton refresh_button;
    // End of variables declaration//GEN-END:variables
}
