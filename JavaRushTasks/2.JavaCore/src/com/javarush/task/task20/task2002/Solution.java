package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
	        for (int i = 0; i < 5; i++) {
		        User user = new User();
		        user.setFirstName("pidor"+i);
		        user.setLastName("lastname"+i);
		        user.setMale(true);
		        user.setBirthDate(new Date());
		        user.setCountry(User.Country.OTHER);
		        javaRush.users.add(user);

	        }
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
	        System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintStream stream = new PrintStream(outputStream);
            if (users.size()!=0) {
	            for (User user : users) {

	            	stream.println(user.getFirstName());
	            	stream.println(user.getLastName());
	            	stream.println(user.isMale());
	            	stream.println(user.getBirthDate().getTime());
	            	stream.println(user.getCountry().name());


	            }
            }
            stream.println("/end");
            stream.flush();
        }


        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
				while (!(str = reader.readLine()).equals("/end")){
					User user = new User();
					user.setFirstName(str);
					user.setLastName(reader.readLine());
					user.setMale(Boolean.parseBoolean(reader.readLine()));
					user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
					user.setCountry(User.Country.valueOf(reader.readLine()));

					users.add(user);
				}
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
