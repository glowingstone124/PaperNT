package com.paper.inst;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Resource{
    public static void export(){
    String resourcePath = "sys.zip"; // 替换为您的资源文件路径
    String exportFolder = ""; // 替换为您想要导出到的本地文件夹路径
        try {
        // 获取资源文件的输入流
        ClassLoader classLoader = Resource.class.getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(resourcePath);

        if (resourceStream != null) {
            // 创建目标文件夹
            Path exportPath = Paths.get(exportFolder);
            Files.createDirectories(exportPath);

            // 解压缩文件
            try (ZipInputStream zipInputStream = new ZipInputStream(resourceStream)) {
                ZipEntry zipEntry;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    Path outputPath = exportPath.resolve(zipEntry.getName());
                    if (zipEntry.isDirectory()) {
                        Files.createDirectories(outputPath);
                    } else {
                        Files.createDirectories(outputPath.getParent());
                        Files.copy(zipInputStream, outputPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }

            System.out.println("Files extracted to: " + exportPath.toAbsolutePath());
        } else {
            System.err.println("Resource not found.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
