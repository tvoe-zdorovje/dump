package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            //setChildren(new ArrayList<>());
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

	    public Person() {
        	//setChildren(new ArrayList<>());
	    }

	    @Override
        public void writeExternal(ObjectOutput out) throws IOException {
		    out.writeObject(firstName);
		    out.writeObject(lastName);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            age = in.readInt();
			children = (List)in.readObject();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person person = new Person("Name", "lastname", 3);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(person);
		out.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bais);
		Person person1
		= (Person) in.readObject();
		in.close();
	    System.out.println(person.toString());
	    System.out.println(person1.toString());
    }
}
