package com.nokia.example.IOStream;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.*;

/**
 * Created by YLongYao on 2017/2/14.
 */
public class IOStreamClass {

    @Test
    public void IOStreamClass() throws FileNotFoundException {
        File file = new File("");
        FileInputStream fileInputStream  = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outputStream = new DataOutputStream(fileOutputStream);

    }

    /**
     * 文件随机读取
     * @throws IOException
     */
    @Test
    public void RandomAccessFileTest() throws IOException {
        File file = new File("");
        RandomAccessFile accessFile = new RandomAccessFile(file , "rw");
        byte[] bytes = new byte[1024];
        accessFile.write(12);
        accessFile.write(bytes);


        accessFile.read();
        accessFile.read(bytes);
    }

    @Test
    public void FileStreamTest() throws IOException {
        File file = new File("");
        FileInputStream in  = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int c;
        while((c = in.read(bytes)) != -1){
            out.write(bytes);
            out.flush();
        }
        in.close();
        out.close();
    }

    @Test
    public void BufferStreamTest() throws IOException {
        File file = new File("");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        int c;
        while((c = bis.read()) != -1){
            bos.write(c);
            bos.flush();  //刷新缓冲区
        }
        bis.close();
        bos.close();
    }


}
