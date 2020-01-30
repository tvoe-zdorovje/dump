package com.javarush.task.task35.task3507;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

			Set<Animal> set = new HashSet<>();
	    try {

//	    	String url = URLDecoder.decode(pathToAnimals, "UTF-8");
//	    	if (!url.endsWith("\\")) url+="\\";
		    String url = pathToAnimals;
	    	if (!url.endsWith("/")) url+="/";

	    	ClassLoader loader = new MyClassLoader(url, Solution.class.getClassLoader());

		    for (File file : new File(url).listFiles()) {

					try {
			            Class<? extends Animal> clazz = (Class<? extends Animal>) loader.loadClass(file.getName().replaceAll(".class", ""));
			            if (Animal.class.isAssignableFrom(clazz))
						set.add(clazz.getConstructor().newInstance());
					}  catch (NoSuchMethodException e) {

					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

		    }


		    return set;
	    }
//	    catch (UnsupportedEncodingException e) {
//		    e.printStackTrace();
//	    } catch (IOException e) {
//		    e.printStackTrace();
//	    }
	    catch (ClassNotFoundException e) {
		    e.printStackTrace();
	    }

	    return set;
    }
}
