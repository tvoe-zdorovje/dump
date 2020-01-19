package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
	public static void main(String[] args) throws IOException {

//		args = new String[]{
//				"C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\res.wav"
//				, "C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\arch.z02"
//				, "C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\arch.z01"
//				, "C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\arch.z03"
//				, "C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\arch.z04"
//		};
//
//		Set<String> filesSet = new TreeSet<>();
//		for (int i = 1; i < args.length; i++) {
//			filesSet.add(args[i]);
//		}
//
//
//
//	Path zip = Files.createTempFile("zip-", ".zip");
//		Vector<InputStream> inputStreams = new Vector<>();
//
//
//		for (String part : filesSet) {
//		inputStreams.add(new FileInputStream(part));
//		}
//		SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreams.elements());
//
//		Files.write(zip, sequenceInputStream.readAllBytes(), StandardOpenOption.APPEND);
//
//
//		//FileInputStream fis = new FileInputStream(zip.toFile());
//		try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zip.toFile()))){
//try (FileOutputStream resultOutStream = new FileOutputStream(args[0])){
//
//
//	while (zipInputStream.getNextEntry() != null) {
//		byte[] buff = new byte[1024];
//		int count;
//		while ((count = zipInputStream.read(buff)) != -1) {
//			resultOutStream.write(buff, 0, count);
//		}
//		resultOutStream.flush();
//		zipInputStream.closeEntry();
//	}
//
//}
//		catch (IOException ex){
//
//		}
//}

//		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\arch.zip"));
//		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.wav");

//		zipOutputStream.putNextEntry(new ZipEntry("source.wav"));

		byte[] buff = new byte[1024];
//		while (fileInputStream.available()>0){
//			int count = fileInputStream.read(buff);
//			zipOutputStream.write(buff, 0, count);
//			zipOutputStream.flush();
//		}
//
//		zipOutputStream.closeEntry();
//		zipOutputStream.close();
//		fileInputStream.close();

//		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.zip"));
//
//		Path file = Paths.get("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\sound.v2.wav");
//		Files.createFile(file);
//				ZipEntry entry;
//
//		while ((entry = zipInputStream.getNextEntry()) != null){
//				Files.write(file, zipInputStream.readAllBytes(), StandardOpenOption.APPEND);
//			zipInputStream.closeEntry();
//		}
//
//		zipInputStream.close();


		Path file = Paths.get("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\newArch.zip");
		Files.createFile(file);

		FileInputStream partInputStream = new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.zip");
		FileInputStream part1InputStream = new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.z01");
		FileInputStream part2InputStream = new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.z02");
		FileInputStream part3InputStream = new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.z03");
		FileInputStream part4InputStream = new FileInputStream("C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\Рабочий стол\\source.z04");

		Files.write(file, part1InputStream.readAllBytes(), StandardOpenOption.APPEND);
		Files.write(file, part2InputStream.readAllBytes(), StandardOpenOption.APPEND);
		Files.write(file, part3InputStream.readAllBytes(), StandardOpenOption.APPEND);
		Files.write(file, part4InputStream.readAllBytes(), StandardOpenOption.APPEND);
		Files.write(file, partInputStream.readAllBytes(), StandardOpenOption.APPEND);

		partInputStream.close();
		part1InputStream.close();
		part2InputStream.close();
		part3InputStream.close();
		part4InputStream.close();
	}
}
