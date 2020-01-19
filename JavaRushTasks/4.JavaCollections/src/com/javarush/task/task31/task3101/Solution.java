package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
	public static void main(String[] args) {
		//args = new String[]{"C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\JavaRushTasks\\2.JavaCore", "C:\\Users\\dr0sh.DESKTOP-961VI4D\\OneDrive\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101\\file"};
		File path = new File(args[0]);
		File resultFileAbsolutePath = new File(args[1]);
		File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
		FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

		try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)){
		List<File> list = getFilesOnDir(path);
		list.sort(Comparator.comparing(File::getName));
			for (File f : list) {
				FileInputStream is = new FileInputStream(f);

				byte[] buffer = new byte[50];
				int count =
						is.read(buffer);
				fileOutputStream.write(buffer, 0, count);
				fileOutputStream.write(System.lineSeparator().getBytes());
				fileOutputStream.flush();
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<File> getFilesOnDir(File path) {


		List<File> list = new ArrayList<>();
		list.addAll(Arrays.asList(Objects.requireNonNull(path.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt") && pathname.length() <= 50;
			}
		}))));

		for (File file : Objects.requireNonNull(path.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		}))) {
			list.addAll(getFilesOnDir(file));
		}

		return list;
	}

}
