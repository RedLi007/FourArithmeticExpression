package com.RedLi.utils;

import java.io.*;

public class Compare {

    private static int i = 0;
    //t是正确的题数，f是错误的题数
    private static int t = 0, f = 0;
    private static String exercises, answers;
    private static String[] correct = new String[10000];
    private static String[] wrong = new String[10000];

    public static void compare(String exercisesName, String answersName, String gradeName) throws FileNotFoundException, IOException {
        //创建练习题文件
        File writeExercises = new File("./" + exercisesName);
        //读入练习题文件中内容
        BufferedReader br1 = new BufferedReader(new FileReader(writeExercises));
        //创建答案文件
        File writeAnswers = new File("./" + answersName);
        //读入答案文件中内容
        BufferedReader br2 = new BufferedReader(new FileReader(writeAnswers));
        //将对和错的题目序号写入到相应的数组
        while ((exercises = br1.readLine()) != null && (answers = br2.readLine()) != null) {
            //记录每道题的序号
            i++;
            if (exercises.equals(answers) && !exercises.equals("\n")) {
                //对的题目
                t++;
                correct[t - 1] = String.valueOf(i);
            } else {
                //错的题目
                f++;
                wrong[f - 1] = String.valueOf(i);
            }
        }

        //创建grade文件并将对和错地序号输入到文件中
        File writeGrade = new File("./" + gradeName);
        BufferedWriter br3 = new BufferedWriter(new FileWriter(writeGrade));
        br3.write("Correct:" + t + "(");
        br3.flush();
        for (int x = 0; x < t; x++) {
            //写入对的题目序号
            if (x != t - 1)
                br3.write(correct[x] + ",");
            else
                br3.write(correct[x]);
            br3.flush();
        }
        br3.write(")" + "\n" + "Wrong:" + f + "(");
        br3.flush();
        for (int x = 0; x < f; x++) {
            //写入错的题目序号
            if (x != f - 1)
                br3.write(wrong[x] + ",");
            else
                br3.write(wrong[x]);
            br3.flush();
        }
        br3.write(")" + "\n");
        br3.flush();
        br3.close();
    }

}
