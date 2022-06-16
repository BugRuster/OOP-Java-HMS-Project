package com.meco;

import java.util.*;

public class Testing2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            map.put("jButton".concat(String.valueOf(i)), 2);
        }



		System.out.println(map);
        System.out.println("GenerateBtn");
    }
}
