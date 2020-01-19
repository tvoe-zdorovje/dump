package com.javarush.task.task20.task2024;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution(int node){
    	this.node = node;
    }

    public void  setEdges(Solution... edges){
	    this.edges.addAll(Arrays.asList(edges));
    }

    public String toString(){
    	StringBuilder builder = new StringBuilder();
    	builder.append(node).append("\t[");
	    for (Solution edge : edges) {
		    builder.append(edge.node).append(", ");
	    }
	    builder.append("]");
	    return builder.toString();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Solution one = new Solution(1);
//		Solution two = new Solution(2);
//		Solution three = new Solution(3);
//		Solution four = new Solution(4);
//		Solution five = new Solution(5);
//		Solution six = new Solution(6);
//
//		List<Solution> nodes = Arrays.asList(one, two, three, four, five, six);
//
//		one.setEdges(two);
//		two.setEdges(two, four, five);
//		four.setEdges(one, five);
//		five.setEdges(four);
//		six.setEdges(three);
//
//	    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2024\\file"));
//	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2024\\file"));
//
//	    long begin = System.currentTimeMillis();
//
//	    out.writeObject(nodes);
//
//	    List<Solution> newnodes = (List) in.readObject();
//
//	    long end = System.currentTimeMillis();
//	    System.out.println(end-begin);
//
//	    out.close();
//	    in.close();
	    //191 008 742 217 378 112
	    BigInteger integer = BigInteger.valueOf(10);
String[] strs = {" 1517841543307505039", "3289582984443187032", "4498128791164624869", "4929273885928088826"};
	    for (String str : strs) {
		    char[] ch = str.toCharArray();
		    Arrays.sort(ch);
		    System.out.println(ch);
	    }
	    System.out.println(999888888765432222L/100000000000000000L);

    }
}
