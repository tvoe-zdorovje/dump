package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
	    try {
		    Solution savedObject = new Solution(32);
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ObjectOutputStream out = new ObjectOutputStream(baos);
		    out.writeObject(savedObject);
		    out.close();
		    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		    ObjectInputStream in = new ObjectInputStream(bais);
		    Solution loadedObject = (Solution) in.readObject();
		    in.close();
		    System.out.println(savedObject.string);
		    System.out.println(loadedObject.string);
	    } catch (ClassNotFoundException e) {
		    e.printStackTrace();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
