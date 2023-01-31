package ru.gl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private static Logger LOG = LoggerFactory.getLogger(ZipFileManager.class);

    // Полный путь к архиву;
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void creteZip(Path source) {
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(source));
             ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile));
             BufferedOutputStream out = new BufferedOutputStream(zos)) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(zipEntry);
            int c;
            while ((c = bis.read()) != -1) {
                out.write(c);
            }
            out.flush();
        } catch (IOException ex) {
            LOG.error("Error files {}", ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
}
