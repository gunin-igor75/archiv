package ru.gl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Archiver {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the full path of the archive");
            String nameArchive = reader.readLine();
            ZipFileManager zfm = new ZipFileManager(Path.of(nameArchive));
            System.out.println("Enter the path to the file to be archived");
            String nameSource = reader.readLine();
            zfm.creteZip(Path.of(nameSource));

        }

    }
}
