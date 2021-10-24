package com.Shimakaze;

import com.RedLi.utils.WriteUtils;
import com.Shimakaze.utils.BinaryTree;
import com.Shimakaze.utils.fractionChange;

import java.io.IOException;
import java.util.Random;

public class CalculateMain {

    public static void calculateMain(int expressionNum, int rangeNumber) {
        //计算部分
        BinaryTree bTree;
        String[] exercises_s = new String[expressionNum];
        String[] answers_s = new String[expressionNum];

        for (int i = 0; i < expressionNum; i++) {
            //随机获取运算符个数
            int numOperator;
            if (new Random().nextInt(3) == 0) numOperator = 1;
            else if (new Random().nextInt(3) == 1) numOperator = 2;
            else numOperator = 3;
            //生成二叉树
            bTree = new BinaryTree(numOperator);
            bTree.createBTree(rangeNumber);
            String ans = fractionChange.improper2mixed(bTree.CalAndVal());
            //运算符左右插入空格
            String exp = bTree.Expression().replaceAll("\\+", " \\+ ").replaceAll("\\-", " \\- ").replaceAll("\\×", " \\× ").replaceAll("\\÷", " \\÷ ");

            //生成的题目存入执行程序的当前目录下的Exercises.txt文件
            exercises_s[i] = exp + " = ";
            WriteUtils wu1 = new WriteUtils();
            try {
                wu1.writeExercises(exercises_s, "Exercises.txt", expressionNum);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //生成的答案存入执行程序的当前目录下的Answers.txt文件
            answers_s[i] = exp + " = " + ans;
            WriteUtils wu2 = new WriteUtils();
            try {
                wu2.writeAnswers(answers_s, "Answers.txt", expressionNum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
