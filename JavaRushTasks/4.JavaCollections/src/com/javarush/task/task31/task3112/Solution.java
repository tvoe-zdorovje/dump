package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
	    System.out.println(passwords);
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
	    URL url = new URL(urlString);
	    Path tempFile = Files.createTempFile("temp-",".tmp");
	    Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

	    return Files.move(tempFile, Files.createDirectories(downloadDirectory).resolve(Paths.get(url.getPath()).getFileName()));
    }
}
