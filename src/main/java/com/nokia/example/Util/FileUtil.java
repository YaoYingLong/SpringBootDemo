package com.nokia.example.Util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

/**
 * @author by YingLong on 2021/6/16
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(bos);



        zos.close();
        bos.close();
    }

    public static void compress(String path, ZipOutputStream zos) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }

    }

}
