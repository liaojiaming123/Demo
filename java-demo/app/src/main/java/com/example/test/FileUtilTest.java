package com.example.test;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * common.apache.org FileUtils使用示例
 * */
public class FileUtilTest {
    File file = new File("test.txt");
    File file2 = new File("test2.html");
    File file3 = new File("test3.png");
    Charset charsets = Charsets.toCharset(Charset.defaultCharset());
    /**
     * 字符串写入文件
     * */
    public void saveFile() throws IOException {
        FileUtils.write(file,"Hello 你好",charsets,true);
    }
    /**
     * 网络字符串数据写入文件
     * */
    public void saveFile2(String string) throws IOException {
        FileUtils.writeStringToFile(file2,string,charsets);
    }
    /**
     * 二进制数组写入文件
     * **/
    public void saveFile3(byte[] bytes) throws IOException {
        FileUtils.writeByteArrayToFile(file3,bytes);
    }
}
