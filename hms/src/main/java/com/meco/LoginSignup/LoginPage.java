package com.meco.LoginSignup;

import java.sql.*;
import javax.swing.JOptionPane;

import com.meco.DB.DB;
import com.meco.MainPages.Admin.HomePage.AdminHomePage;

public class LoginPage extends javax.swing.JFrame {
    public LoginPage() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        signupBtn = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(110, 184, 252));
        jPanel1.setForeground(new java.awt.Color(110, 184, 252));

        welcomeLabel.setFont(new java.awt.Font("AppleGothic", 1, 36)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome!");

        signupBtn.setFont(new java.awt.Font("AppleGothic", 1, 14)); // NOI18N
        signupBtn.setText("SIGNUP");
        signupBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(81, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addComponent(signupBtn)
                                                        .addGap(123, 123, 123)))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(signupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        emailLabel.setFont(new java.awt.Font("AppleGothic", 0, 18)); // NOI18N
        emailLabel.setText("Email");

        passwordLabel.setFont(new java.awt.Font("AppleGothic", 0, 18)); // NOI18N
        passwordLabel.setText("Password");

        emailField.setText("Enter username");
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        passwordField.setText("Enter password");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        loginLabel.setFont(new java.awt.Font("AppleGothic", 1, 36)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Login");

        loginBtn.setFont(new java.awt.Font("AppleGothic", 1, 14)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(emailLabel)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(passwordField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 350,
                                                                Short.MAX_VALUE)
                                                        .addComponent(emailField)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void signupBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // open a new window for the user to sign up and creat a new account
        SignupPage signup_page = new SignupPage();
        signup_page.setVisible(true);
        signup_page.pack();
        signup_page.setLocationRelativeTo(null);
        this.dispose();
    }

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Statement stmt;
        ResultSet rs;

        String username = emailField.getText().trim();
        String password = String.valueOf(passwordField.getPassword()).trim();

        String query = "SELECT email, password FROM userdata";
        try {
            stmt = DB.getConnection().createStatement();
            rs = stmt.executeQuery(query);

            String storedUsername;
            String storedPassword;
            while (rs.next()) {
                storedUsername = rs.getString("email").trim();
                storedPassword = rs.getString("password").trim();

                if (username.equals(storedUsername)) {
                    if (password.equals(storedPassword)) {
                        // show new form
                        AdminHomePage admin_page = new AdminHomePage();
                        admin_page.setVisible(true);
                        admin_page.pack();
                        admin_page.setLocationRelativeTo(null);
                        this.dispose();
                        break;
                    } 
                    else {
                        // error message
                        JOptionPane.showMessageDialog(null, "Invalid Password", "Login Failed", 2);
                    }
                    break;
                } else {
                    // errror message
                    JOptionPane.showMessageDialog(null, "Invalid Username", "Login Failed", 2);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {
        // clear the text field on focus if the text is "username"
        if (emailField.getText().trim().equals("Enter username")) {
            emailField.setText("");
        }
    }

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {
        // re-enter the text "Enter username" if focus is lost
        if (emailField.getText().equals("") || emailField.getText().equals("Enter username")) {
            emailField.setText("Enter username");
        }
    }

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {
        // clear the text field on focus if the text is "Enter password"
        if (String.valueOf(passwordField.getPassword()).equals("Enter password")) {
            passwordField.setText("");
        }
    }

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {
        // re-enter the text "Enter username" if focus is lost
        if (String.valueOf(passwordField.getPassword()).equals("")
                || String.valueOf(passwordField.getPassword()).equals("Enter password")) {
            passwordField.setText("Enter password");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signupBtn;
    private javax.swing.JLabel welcomeLabel;
}
