package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
    	labels.put(2.2, "TB");
    	labels.put(2.1, "TB");
    	labels.put(2.3, "B");
    	labels.put(1.9, "TDI");
    	labels.put(1.6, "???");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }


}
