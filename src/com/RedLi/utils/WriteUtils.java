package com.RedLi.utils;

import java.io.*;

public class WriteUtils {

    //字符串数组用来存放练习题，exercisesName即自定义文件名，n为练习题数目
    public static void writeExercises(String[] exercises_s, String exercisesName, int n) throws IOException {
        //生成的练习题存放在当前目录下的自定义文件
        File exercises = new File("./" + exercisesName);
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(exercises));
        //写入从1到n的算式,即生成n道练习题
        for (int i = 1; i <= n; i++) {
            bw1.write(i + "、" + exercises_s[i - 1] + "\n");
            bw1.flush();
        }
        bw1.close();
    }

    public static void writeAnswers(String[] answers_s, String answersName, int n) throws IOException {
        File answers = new File("./" + answersName);
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(answers));
        for (int i = 1; i <= n; i++) {
            bw2.write(i + "、" + answers_s[i - 1] + "\n");
            bw2.flush();
        }
        bw2.close();
    }

}
