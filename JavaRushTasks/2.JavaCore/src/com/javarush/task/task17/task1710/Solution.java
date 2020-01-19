package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
	public static List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) {
		try {
				switch (args[0]) {
					case "-c":
						create(args[1], args[2].toLowerCase().charAt(0), args[3]);
						break;
					case "-u":
						update(Integer.parseInt(args[1]), args[2], args[3].toLowerCase().charAt(0), args[4]);
						break;
					case "-d":
						delete(Integer.parseInt(args[1]));
						break;
					case "-i":
						information(Integer.parseInt(args[1]));
						break;
					default:
						throw new RuntimeException("Unknown parameter");

				}

		} catch (RuntimeException | ParseException e) {
			if (e.getMessage().equals("Unknown parameter.")) System.err.println(e.getMessage());
			else System.err.println("Error: check parameters.");
		}
	}

	private static void create(String name, char sex, String bd) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		if (sex == 'м') allPeople.add(Person.createMale(name, df.parse(bd)));
		else allPeople.add(Person.createFemale(	name, df.parse(bd)));

		System.out.println(allPeople.size()-1);
	}

	private static void update(int id, String name, char sex, String bd) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Person person = allPeople.get(id);

		person.setSex(transformSex(sex));
		person.setName(name);
		person.setBirthDate(df.parse(bd));


	}

	private static void delete(int id) {
		Person person = allPeople.get(id);
		person.setBirthDate(null);
		person.setName(null);
		person.setSex(null);
	}

	private static void information(int id) {
		Person person = allPeople.get(id);
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		System.out.println(
				String.join(
						" ",
						person.getName(),
						transformSex(person.getSex()),
						df.format(person.getBirthDate())
				)
		);
	}

	    private static Sex transformSex(char sex){
    	return sex=='м' ? Sex.MALE : Sex.FEMALE;
    }
	private static String transformSex(Sex sex) {

		return sex.equals(Sex.MALE) ? "м" : "ж";
	}

}
