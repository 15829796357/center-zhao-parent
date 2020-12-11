package com.zhao.center.provider.utils;

import java.io.*;

/**
 * @author ZCH
 * @Description 模板拷贝
 * @since 2020/12/10$ 14:38$
 */
public class FileCopyThymeleaf {

    public static void main(String[] args) {
        copyFile("C:\\root\\hello.html","C:\\root\\thymeleaf\\1.html");
    }

    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            //文件存在时
            if (oldfile.exists()) {
                //读入原文件
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    //字节数 文件大小
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
        } catch (IOException e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

}
