package com.meco;

import com.meco.DB.Tables;
import com.meco.LoginSignup.LoginPage;

public class App {
    
    public static void main(String arg[]) {
        if (Tables.roomStatusTABLE() && 
        Tables.roomsDataTABLE() && 
        Tables.userDataTABLE() && 
        Tables.staffDetailsTABLE() &&
        Tables.complainsTABLE()
        ) {
            // if all tables are created successfully
            LoginPage page = new LoginPage();
            page.setVisible(true);
            page.pack();
            page.setLocationRelativeTo(null);
        }
    }
}
