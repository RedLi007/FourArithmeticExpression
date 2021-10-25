package com.RedLi.utils;

import java.io.*;

public class WriteUtils {

    //将可变字符串writeFile_s的内容写进本程序目录下的writeFileName文件中
    public static void writeUtils(StringBuffer writeFile_s, String writeFileName) throws IOException {
        File writeFile = new File("./" + writeFileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
        bw.write(String.valueOf(writeFile_s));
        bw.flush();
        bw.close();
    }

}
