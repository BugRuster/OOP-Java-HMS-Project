/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.meco.MainPages.Admin.CustomerInfoPage;

import com.meco.DB.DB;
import com.meco.MainPages.Admin.HomePage.AdminHomePage;
import com.meco.MainPages.Admin.RoomsPage.AdminRoomsPage;
import com.meco.MainPages.Admin.SettingsPage.AdminSettingsPage;
import com.meco.MainPages.Admin.StaffPage.AdminStaffPage;

/**
 *
 * @author ashishkumar
 */
public class AdminCustomerInfoPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomePage
     */
    public AdminCustomerInfoPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        userDataTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        adminHomeBtn = new javax.swing.JMenu();
        adminCustomerInfoPage = new javax.swing.JMenu();
        adminRoomsBtn = new javax.swing.JMenu();
        adminStaffBtn = new javax.swing.JMenu();
        adminSettingsBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userDataTable.setFont(new java.awt.Font("AppleGothic", 0, 12)); // NOI18N
        userDataTable.setModel(new javax.swing.table.DefaultTableModel(
            DB.getUserData(DB.getSizeOfTable("roomsData")),
            new String [] {
                "Name", "Phone No.", "Room No.", "Check-In", "Check-Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        userDataTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(userDataTable);

        adminHomeBtn.setText("Home");
        adminHomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminHomeBtnMouseClicked(evt);
            }
        });
        menuBar.add(adminHomeBtn);

        adminCustomerInfoPage.setText("Customer Info");
        adminCustomerInfoPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminCustomerInfoPageMouseClicked(evt);
            }
        });
        menuBar.add(adminCustomerInfoPage);

        adminRoomsBtn.setText("Rooms");
        adminRoomsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminRoomsBtnMouseClicked(evt);
            }
        });
        menuBar.add(adminRoomsBtn);

        adminStaffBtn.setText("Staff");
        adminStaffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminStaffBtnMouseClicked(evt);
            }
        });
        menuBar.add(adminStaffBtn);

        adminSettingsBtn.setText("Settings");
        adminSettingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminSettingsBtnMouseClicked(evt);
            }
        });
        menuBar.add(adminSettingsBtn);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getValues() {
    }

    private void adminHomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminHomeBtnMouseClicked
        AdminHomePage admin_home_page = new AdminHomePage();
        admin_home_page.setVisible(true);
        admin_home_page.pack();
        admin_home_page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_adminHomeBtnMouseClicked

    private void adminCustomerInfoPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminCustomerInfoPageMouseClicked
        AdminCustomerInfoPage admin_customer_info_page = new AdminCustomerInfoPage();
        admin_customer_info_page.setVisible(true);
        admin_customer_info_page.pack();
        admin_customer_info_page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_adminCustomerInfoPageMouseClicked

    private void adminRoomsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRoomsBtnMouseClicked
        AdminRoomsPage admin_rooms_page = new AdminRoomsPage();
        admin_rooms_page.setVisible(true);
        admin_rooms_page.pack();
        admin_rooms_page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_adminRoomsBtnMouseClicked

    private void adminStaffBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminStaffBtnMouseClicked
        AdminStaffPage admin_staff_page = new AdminStaffPage();
        admin_staff_page.setVisible(true);
        admin_staff_page.pack();
        admin_staff_page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_adminStaffBtnMouseClicked

    private void adminSettingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSettingsBtnMouseClicked
        AdminSettingsPage admin_settings_page = new AdminSettingsPage();
        admin_settings_page.setVisible(true);
        admin_settings_page.pack();
        admin_settings_page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_adminSettingsBtnMouseClicked

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
            java.util.logging.Logger.getLogger(AdminCustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminCustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminCustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminCustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminCustomerInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminCustomerInfoPage;
    private javax.swing.JMenu adminHomeBtn;
    private javax.swing.JMenu adminRoomsBtn;
    private javax.swing.JMenu adminSettingsBtn;
    private javax.swing.JMenu adminStaffBtn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable userDataTable;
    // End of variables declaration//GEN-END:variables
}
