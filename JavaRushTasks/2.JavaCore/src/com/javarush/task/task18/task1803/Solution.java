package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileInputStream file = new FileInputStream(reader.readLine());
	    reader.close();

	    List<Integer> list = new ArrayList<>(20);

	    int maxFrec = 0;

	    while (file.available() > 0) {
		    list.add(file.read());
	    }


	    file.close();

	    for (Integer integer : list) {
			maxFrec = Math.max(Collections.frequency(list, integer), maxFrec);
	    }

	    String inferred = "";
	    for (Integer integer : list) {
		    if (Collections.frequency(list, integer) == maxFrec && !inferred.contains(Integer.toString(integer))) {

			    inferred =  inferred.isEmpty()? Integer.toString(integer)   : String.join(" ", inferred, Integer.toString(integer));

		    }
	    }

	    System.out.println(inferred);









	    //
	    //
	    // System.out.println(Collections.max(list));
    }

    private static List<Integer> contains(List<List<Integer>> list, Integer integer){
	    for (List<Integer> integerList : list) {
		    if(integerList.contains(integer)) return integerList;
	    }
	    List<Integer> temp = new ArrayList<>();
	    list.add(temp);
	    return temp;
    }
}
