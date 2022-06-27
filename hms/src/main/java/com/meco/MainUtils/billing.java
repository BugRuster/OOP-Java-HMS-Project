package com.meco.MainUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.meco.DB.DB;
import com.meco.MainPages.Admin.RoomsPage.checkOutCustomer;

/**
 * billing
 */
public class billing {
    public static void main(String[] args) {
    }

    public static String generateBillAndSave(int roomNumber) {
        Map<String, String> data = DB.getAllData(roomNumber);
        String name = data.get("name");
        String email = data.get("email");
        String age = data.get("age");
        String phone_no = data.get("phone_no");
        String room_no = data.get("room_no");
        String ac_nonAcRoom = data.get("ac_nonAcRoom");
        String single_doubleBed = data.get("single_doubleBed");
        String meal_noMeal = data.get("meal_noMeal");
        String check_in = data.get("check_in");
        String check_out = checkOutCustomer.checkOutString;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int nights = 0;
        try {
            long duration = sdf.parse(check_out).getTime() - sdf.parse(check_in).getTime();
            nights = (int) TimeUnit.MILLISECONDS.toDays(duration);
        } catch (ParseException e) {System.out.println(e.getMessage());}

        // Rates of the rooms
        int base_price = 1000; // per night
        int ac_nonAcRoomPrice = (ac_nonAcRoom.equals("AC Room")) ? 300 : 0;
        int single_doubleBedPrice = (single_doubleBed.equals("Double-Bed Room")) ? 100 : 0;
        int meal_noMealPrice = (meal_noMeal.equals("Meal Combo")) ? 400 : 0;

        String str = "";
            str = str + " ***************************************************************************************\n";
            str = str + " \t\t\t\t\t\t\t\t\t\tBILL\n";
            str = str + " ***************************************************************************************\n";
            str = str + "\n";
            str = str + " Bill Generated : " + check_out + "\n\n";
            str = str + " Name : " + name;
            str = str + "\n";
            str = str + " Email : " + email;
            str = str + "\n";
            str = str + " Age : " + age;
            str = str + "\t\t\t\t\t\t\t";
            str = str + " Phone No. : " + phone_no;
            str = str + "\n\n";
            str = str + " ***************************************************************************************\n\n\n";
            str = str + " ---------------------------------------------------------------------------------------\n";
            str = str + "  Sno.|\t Room No. \t\t\t| Rate\t\t\t| Total Night Stayed\t\t| Price \t\t| \n";
            str = str + " ---------------------------------------------------------------------------------------\n";
            str = str + "      |\t          \t\t\t|     \t\t\t|                   \t\t|       \t\t| \n";
            str = str + "  " + 0 + "   |\t" + room_no + "\t\t\t\t\t| Rs. " + base_price + "\t\t| \t" + nights + " \t\t\t\t\t\t| Rs. " + base_price * nights + " \t\t| \n";
            str = str + "      |\t          \t\t\t|     \t\t\t|                   \t\t|       \t\t| \n";
            str = str + " ---------------------------------------------------------------------------------------\n";
            str = str + "  Sno.|\t Service\t\t\t\t\t\t\t\t\t\t\t\t\t\t| Price \t\t| \n";


            str = str + " ---------------------------------------------------------------------------------------\n";
            str = str + "  " + 1 + "   |  " + ac_nonAcRoom + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t|" + " Rs. " + ac_nonAcRoomPrice + " \t\t| \n";
            str = str + "  " + 2 + "   |  " + single_doubleBed + "\t\t\t\t\t\t\t\t\t\t\t\t|" + " Rs. " + single_doubleBedPrice + " \t\t| \n";
            str = str + "  " + 3 + "   |  " + meal_noMeal + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t|" + " Rs. " + meal_noMealPrice + " \t\t| \n";
            str = str + " ---------------------------------------------------------------------------------------\n";

            int totalPrice = (base_price * nights) + ac_nonAcRoomPrice + single_doubleBedPrice + meal_noMealPrice;
            str = str + "\n\n";
            str = str + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Total : Rs " + totalPrice + "\n";
            str = str + " ---------------------------------------------------------------------------------------\n";

            str = str + "\n\n\t\t\t\t\t\t\t\t\t\t" + "________________";
            str = str + "\n\t\t\t\t\t\t\t\t\t\t" + "    Signature";

        try {
            mainUtils.generateTxtFile(str, name, check_out);
            JOptionPane.showMessageDialog(null, "Bill generated and PDF is saved to the device storage!", "Bill Generated", 2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error in bill generation process!", 2);
        }
        return str;
    }
}
