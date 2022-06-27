package com.meco.MainUtils;

import java.io.File;
import java.io.FileWriter;

public class mainUtils {
    public static void generateTxtFile(String bill, String name, String date) {
        String title = date + "(" + name + ")";
        try {
            File txtFile = new File(title + ".txt");
            if (txtFile.exists()) {
                FileWriter fw = new FileWriter(txtFile);
                fw.write(bill);
                fw.close();
            } else {
                txtFile.createNewFile();
                System.out.println("File created: " + txtFile.getName());
                FileWriter fw = new FileWriter(txtFile);
                fw.write(bill);
                fw.close();
            }
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    public static void main(String[] args) {
    }
}
