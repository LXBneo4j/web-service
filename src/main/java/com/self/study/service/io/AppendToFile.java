package com.self.study.service.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: lxb.
 * @time: 2018/1/16.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class AppendToFile {
    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "C:/temp/newTemp.txt";
        String content = "new append!";
        //按方法A追加文件
        AppendToFile.appendMethodA(fileName, content);
        AppendToFile.appendMethodA(fileName, "append end. \n");
        //显示文件内容
        ReadFromFile.readFileByLines(fileName);
        //按方法B追加文件
        AppendToFile.appendMethodB(fileName, content);
        AppendToFile.appendMethodB(fileName, "append end. \n");
        //显示文件内容
        ReadFromFile.readFileByLines(fileName);
    }
}
