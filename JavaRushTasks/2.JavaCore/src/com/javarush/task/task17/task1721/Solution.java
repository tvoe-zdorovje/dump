package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

	    try {

		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    BufferedReader readerAll = new BufferedReader(new FileReader(reader.readLine()));
		    BufferedReader readerForRemove = new BufferedReader(new FileReader(reader.readLine()));

		    reader.close();

		    String s;
		    while ((s=readerAll.readLine()) != null) {
			    allLines.add(s);
		    }
		    while ((s=readerForRemove.readLine()) != null) {
			    forRemoveLines.add(s);
		    }
		    readerAll.close();
		    readerForRemove.close();

		    new Solution().joinData();
	    } catch (CorruptedDataException e) {
		    e.printStackTrace();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }

    }

    public void joinData() throws CorruptedDataException, IOException {




	    if (allLines.containsAll(forRemoveLines))    allLines.removeAll(forRemoveLines);

	    else {
	    	allLines.clear();
	    	throw new CorruptedDataException();
	    }



    }
}
