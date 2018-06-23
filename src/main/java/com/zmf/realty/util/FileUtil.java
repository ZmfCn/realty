package com.zmf.realty.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * utilities for file operations.
 */
public class FileUtil {
    /**
     * write tht file to the chapter file path and change the file permission
     *
     * @param filePath the file path
     * @param file     the file
     */
    public static void writeFile(String filePath, MultipartFile file) {
        new Thread(() -> {
            try {
                File dest = new File(filePath);
                FileUtil.createFile(dest);
                file.transferTo(dest);
                FileUtil.changeFilePermission(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * create a file with the certain permission
     *
     * @param file the file
     */
    public static void createFile(File file) {
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                changeFilePermission(file.getParentFile());
            }
            try {
                file.createNewFile();
                changeFilePermission(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * generate a raw file name without suffix
     *
     * @return file name
     */
    public static String generateRawFileName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * get the corresponding suffix of the file
     *
     * @param contentType the contentType field of multipart instance
     * @return the suffix
     */
    public static String getSuffix(String contentType) {
        return "." + contentType.substring(contentType.indexOf("/") + 1);
    }


    public static boolean deleteFile(File file) {
        return !file.exists() || file.delete();
    }


    /**
     * change file permission to rwxrwxr-x
     *
     * @param file the file that exists
     */
    public static void changeFilePermission(File file) {
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        perms.add(PosixFilePermission.OTHERS_READ);
        try {
            Path path = Paths.get(file.getAbsolutePath());
            Files.setPosixFilePermissions(path, perms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
