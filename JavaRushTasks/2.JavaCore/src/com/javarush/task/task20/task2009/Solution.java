package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

	    public void writeExternal(ObjectOutput out) throws IOException {
		    out.write(i);
		    out.write(j);
		    out.writeObject(staticString);
	    }

	    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
				i = in.readInt();
				j= in.readInt();
				staticString = (String) in.readObject();
	    }
    }

    public static void main(String[] args) {

    }
}
