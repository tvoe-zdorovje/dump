package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
	static long  filesCount = 0, dirsCount = -1, dirSize = 0;
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    Path dir = Paths.get(reader.readLine());
	    reader.close();

	    if (!Files.isDirectory(dir)) {
		    System.out.println(dir.toAbsolutePath() + " - не папка");
		    return;
	    }




	    Files.walkFileTree(dir, new FileVisitor<Path>() {
		    @Override
		    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			    dirsCount++;
			    return FileVisitResult.CONTINUE;
		    }

		    @Override
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			    filesCount++;
			    dirSize+=Files.size(file);
			    return FileVisitResult.CONTINUE;
		    }

		    @Override
		    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			    return FileVisitResult.SKIP_SUBTREE;
		    }

		    @Override
		    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			    return FileVisitResult.CONTINUE;
		    }
	    });

	    System.out.printf("Всего папок - %d\nВсего файлов - %d\nОбщий размер - %d",dirsCount, filesCount, dirSize);

    }
}
