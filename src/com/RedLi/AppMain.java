package com.RedLi;

import com.RedLi.utils.Compare;
import com.Shimakaze.CalculateMain;

import java.io.IOException;

public class AppMain {

    public static void main(String[] args) throws IOException {

        System.out.println("使用说明：" + "\n" + "1、使用 -n 和 -r 参数分别控制生成题目的个数和题目中数值（自然数、真分数和真分数分母）的范围例如 '-n 10 -r 10'" + "\n" + "2、使用 -e 和 -a 参数对给定的题目文件和答案文件，判定答案中的对错并进行数量统计例如 '-e <exercisefile>.txt -a <answerfile>.txt'" + "\n" + "3、生成的题目存入执行程序的当前目录下的Exercises.txt文件，生成的答案存入执行程序的当前目录下的Answers.txt文件，统计结果输出到执行程序的当前目录下Grade.txt文件");

        int rangeNumber = 0;
        int expressionNum = 0;
        CalculateMain calculate = new CalculateMain();
        Compare cp = new Compare();

        //输入参数并根据参数选择功能部分
        if (args[0].equals("-n") && args[2].equals("-r")) {
            //args[1]是生成题目数量，args[3]是题目中数值的范围
            expressionNum = Integer.parseInt(args[1]);
            rangeNumber = Integer.parseInt(args[3]);
            calculate.calculateMain(expressionNum, rangeNumber);
        } else if (args[0].equals("-e") && args[2].equals("-a")) {
            //args[1]是题目文件名，args[3]是答案文件名
            cp.compare(args[1], args[3], "Grade.txt");
        } else {
            System.out.println("输入有误,请查看使用说明并重新操作。");
        }

    }

}
