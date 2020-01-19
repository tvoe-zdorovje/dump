package com.javarush.task.task17.task1716;

/* 
Синхронизированные методы
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        Double d = method3();
    }               //param

    protected void method1(String param1) {
        Solution solution = new Solution();         //object
        solution.method0();
    }

    public void method2(int param1) {
        param1++;
    }

	synchronized double  method3() {
        double random = Math.random();
        param += 40.7;                                    //param
        return random + param;
    }

    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }       //sb

    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) {
        System.out.println("Thinking....");                 //sb
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {
        return "" + param2;
    }

    public static void main(String[] args)  {
	    BigDecimal bigDecimal = new BigDecimal(500);
	    bigDecimal.subtract(BigDecimal.valueOf(100));
	    System.out.println(bigDecimal);

    }

}
