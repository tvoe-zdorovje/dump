package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String filename1 = reader.readLine();
	    String filename2 = reader.readLine();
	    reader.close();

	    FileReader fileReader1 = new FileReader(filename1);
	    FileReader fileReader2 = new FileReader(filename2);
	    BufferedReader reader1 = new BufferedReader(fileReader1);
	    BufferedReader reader2 = new BufferedReader(fileReader2);

	    String a = reader1.readLine();
	    String b = reader2.readLine();

	    while (reader1.ready() && reader2.ready()){

	    	if (a.equals(b)){
	    		lines.add(new LineItem(Type.SAME, a));
			    a = reader1.readLine();
			    b = reader2.readLine();
		    }
	    	else {

				String temp = a;
				if ((a = reader1.readLine()).equals(b)) {
					lines.add(new LineItem(Type.REMOVED, temp));
					lines.add(new LineItem(Type.SAME, a));
					a = reader1.readLine();
					b = reader2.readLine();
				}
				else {
					lines.add(new LineItem(Type.ADDED, b));
					lines.add(new LineItem(Type.SAME, (reader2.readLine())));
					b = reader2.readLine();
				}





		    }


		    if (a == null && b != null) lines.add(new LineItem(Type.ADDED, b));
		    if (a != null && b == null) lines.add(new LineItem(Type.REMOVED, a));
	    }

	    fileReader1.close();
	    fileReader2.close();
	    reader1.close();
	    reader2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
