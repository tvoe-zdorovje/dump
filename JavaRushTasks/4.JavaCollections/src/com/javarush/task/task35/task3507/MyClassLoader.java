package com.javarush.task.task35.task3507;

import java.io.*;

public class MyClassLoader extends ClassLoader {
	String dir;

	public MyClassLoader(String dir, ClassLoader parentClassLoader) {
		super(parentClassLoader);
		this.dir = dir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] b = fetchClass(dir+name+".class");
			return defineClass(null, b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}

	private byte[] fetchClass(String URL) throws IOException {
		File file = new File(URL);
		InputStream stream = new FileInputStream(file);
		//здесь должна быть проверка на размер файла:)
		byte[] b = new byte[(int) file.length()];
		while (stream.available()>0)
		stream.read(b);

		stream.close();
		return b;
	}
}
