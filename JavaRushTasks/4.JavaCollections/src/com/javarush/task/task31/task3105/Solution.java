package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
	public static void main(String[] args) throws IOException {

//		args = new String[]{"C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\newfile.txt"
//				, "C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\pedor.zip"
//		};
		Map<String, byte[]> map = new HashMap<>();

		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(args[1]));
		ZipEntry tmpZE;

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		while ((tmpZE = inputStream.getNextEntry()) != null) {

			int count;
			byte[] buffer = new byte[8096];
			while ((count = inputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, count);
			}
			map.put(tmpZE.getName(), byteArrayOutputStream.toByteArray());
			inputStream.closeEntry();
			byteArrayOutputStream.reset();
		}
		byteArrayOutputStream.close();
		inputStream.close();

		FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
		ZipOutputStream outputStream = new ZipOutputStream(fileOutputStream);

		Path addedFile = Paths.get(args[0]);


		boolean containFile = false;
//		map.put("new" + File.separator + addedFile.getFileName().toString(), Files.readAllBytes(addedFile));
		for (Map.Entry<String, byte[]> entry : map.entrySet()) {
			outputStream.putNextEntry(new ZipEntry(entry.getKey()));
			if (entry.getKey().endsWith(addedFile.getFileName().toString())) {
				Files.copy(addedFile, outputStream);;
				containFile = true;
			}
			else    outputStream.write(entry.getValue());
			outputStream.closeEntry();
		}
		if (!containFile) {
			outputStream.putNextEntry(new ZipEntry("new" + File.separator + addedFile.getFileName().toString()));
			Files.copy(addedFile, outputStream);
			outputStream.closeEntry();
		}
		outputStream.close();
	}
}
