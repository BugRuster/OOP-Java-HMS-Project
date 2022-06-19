package com.meco.MainPages.Admin;

import java.util.*;

import javax.swing.JButton;

public class adminUtils {
    public static int[] getRoomNumbers() {
        int NUMBER_OF_ROOMS = 80;
        int roomNumbers[] = new int[NUMBER_OF_ROOMS];
        int part1 = 100;
        int part2 = 1;
        for (int i = 0; i < 80; i++) {
            int num = part1 + part2;
            if (num % 10 == 0) {
                roomNumbers[i] = num;
                part2 = 0;
                part1 += 100;
            } else {
                roomNumbers[i] = num;
            }
            part2++;
        }
        return roomNumbers;
    }

    public static Map<String, Integer> getBtnStates() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int roomNumbers[] = getRoomNumbers();
        for (int num : roomNumbers) {
            map.put("btn".concat(String.valueOf(num)), 0);
        }
        return map;
    }

    public static void changeColour(JButton btn, int btnState) {
        if (btnState == 0) {
            btn.setBackground(new java.awt.Color(31, 219, 53)); // Green background color
        } else if (btnState == 1) {
            btn.setBackground(new java.awt.Color(219, 35, 31)); // Red background color
        }  else if (btnState == 2) {
            btn.setBackground(new java.awt.Color(34, 31, 219)); // Blue background color
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = getBtnStates();
        Set<String> keys = map.keySet();
        for (String i : keys) {
            int num = Integer.parseInt(i.substring(3));
            System.out.println(num);
        }
    }
}
// keyset
// loop -> .get(keyset[i])


