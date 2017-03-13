package com.nokia.example.IOStream;

import org.junit.Test;

import java.io.*;

/**
 * Created by YLongYao on 2017/2/15.
 */
public class CharStream {

    @Test
    public void charStreamTest() throws IOException{
        FileInputStream in = new FileInputStream("");
        InputStreamReader isr = new InputStreamReader(in , "UTF-8");

        FileOutputStream out = new FileOutputStream("");
        OutputStreamWriter osw = new OutputStreamWriter(out);
        int c;
        while((c = isr.read()) != -1){
            System.out.print((char)c);
            osw.write(c);
            osw.flush();
        }

        char[] chars = new char[1024];
        while((c = isr.read(chars))!= -1){
            String str = new String(chars);
            System.out.print(str);
            osw.write(chars);
            osw.flush();
        }

        in.close();
        isr.close();
        out.close();
        osw.close();

    }

    @Test
    public void fwAndFrTest() throws IOException{
        FileReader fr = new FileReader("");
        FileWriter fw = new FileWriter("");  //新建文件
//        FileWriter fw = new FileWriter("" , true); 在文件后面追加
        char[] buffer = new char[1024];
        int c;
        while((c = fr.read(buffer)) != -1){
            fw.write(buffer);
            fw.flush();
        }
        fr.close();
        fw.close();
    }

    @Test
    public void BrBwOrPwTest() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
        PrintWriter pw = new PrintWriter("");
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);    //不能识别换行
            bw.write(line);
            bw.newLine();
            bw.flush();

            pw.println(line);
        }
    }

}
