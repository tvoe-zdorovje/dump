package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
    	threads.add(new OneThread());
    	threads.add(new TwoThread());
    	threads.add(new ThreeThread());
    	threads.add(new FourThread());
    	threads.add(new FiveThread());
    }

    public static void main(String[] args) throws InterruptedException {



    }
}