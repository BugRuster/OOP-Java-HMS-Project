package com.meco;

import java.util.*;

public class Testing2 {
    public static void roomNums() {
        int roomNums[] = new int[80];
        int part1 = 100;
        int part2 = 1;
        for (int i = 0; i < roomNums.length; i++) {
            int num = part1 + part2;
            if (num % 10 == 0) {
                roomNums[i] = num;
                part2 = 0;
                part1 += 100;
            } else {
                roomNums[i] = num;
            }
            part2++;
        }
    }

    public static Map<String, Integer> btnStates() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put("jButton".concat(String.valueOf(i)), 0);
        }
        return map;
    }
    public static void main(String[] args) {
        
    }
}
