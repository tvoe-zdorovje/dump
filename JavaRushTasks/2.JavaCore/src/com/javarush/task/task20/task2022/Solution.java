package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeObject(fileName);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
		//fileName = (String) in.readObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
		Solution first = new Solution("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\file.txt");
		first.writeObject("first string");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(first);
		out.close();

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bais);

		Solution second = (Solution) in.readObject();
		in.close();
		second.writeObject("second string");
    }
}
