package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		Pattern p = Pattern.compile("[\\w&&\\D]{3}");


		Matcher m = p.matcher("1123.456.abc.def");
StringBuffer sb = new StringBuffer();

	   // System.out.println(m.matches());

while (m.find()){
			System.out.println(m.group());
			System.out.println(m.toString());
			//m.appendReplacement(sb, "$1").appendTail(sb);
			System.out.println(m.toString());
		}

	    System.out.println(sb);

		//m.appendReplacement()


       // int input = Integer.parseInt(reader.readLine());
        reader.close();

        //System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n < 0) return "0";
        if (n == 0 || n == 1) return "1";

        return (new BigInteger(factorial(n-1)).multiply(new BigInteger(Integer.toString(n)))).toString();
    }
}
