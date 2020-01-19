package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
	public static List<String> getFileTree(String root) throws IOException {
		List<String> list = new ArrayList<>();

	    Queue<File> queue = new ArrayDeque<File>();
	    queue.add(new File(root));

	    while (true){
		    List<File> temp = new ArrayList<>();
		    for (File file1 : queue) {
			    temp.addAll(Arrays.asList(Objects.requireNonNull(file1.listFiles(new FileFilter() {
				    @Override
				    public boolean accept(File pathname) {
				    	if (pathname.isDirectory()){
				    		return !queue.contains(pathname);
					    }
					    else {
					    	String s = pathname.getAbsolutePath();
					    	if (!list.contains(s)) list.add(s);

					    }
					    return false;
				    }
			    }))));
		    }
		    if (temp.isEmpty()) break;
		    queue.addAll(temp);
	    }

		for (String s : list) {
			//System.out.println(s);
		}

		return list;

	}

	public static void main(String[] args) {
//		try {
//			getFileTree("C:\\Users\\dr0sh\\OneDrive\\JavaRushTasks\\4.JavaCollections");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
