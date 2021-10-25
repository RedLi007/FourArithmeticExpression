package com.Shimakaze;

import com.RedLi.utils.WriteUtils;
import com.Shimakaze.utils.BinaryTree;
import com.Shimakaze.utils.fractionChange;

import java.io.IOException;
import java.util.Random;

public class CalculateMain {

    public static void calculateMain(int expressionNum, int rangeNumber) throws IOException {

        BinaryTree bTree;
        //定义长度可变的字符串
        StringBuffer exercises_s = new StringBuffer("");
        StringBuffer answers_s = new StringBuffer("");

        //计算部分
        for (int i = 0; i < expressionNum; i++) {
            //随机获取运算符个数
            int numOperator;
            if (new Random().nextInt(3) == 0) numOperator = 1;
            else if (new Random().nextInt(3) == 1) numOperator = 2;
            else numOperator = 3;
            //生成二叉树
            bTree = new BinaryTree(numOperator);
            bTree.createBTree(rangeNumber);
            //将题目字符串赋值于exp，答案字符串赋值于ans
            String ans = fractionChange.improper2mixed(bTree.CalAndVal());
            //运算符左右插入空格
            String exp = bTree.Expression().replaceAll("\\+", " \\+ ").replaceAll("\\-", " \\- ").replaceAll("\\×", " \\× ").replaceAll("\\÷", " \\÷ ");
            //将练习题每题按换行写入可变字符串exercises_s
            exercises_s.append(i + 1 + "、" + exp + " = " + "\n");
            //将练习题答案按换行写入可变字符串answers_s
            answers_s.append(i + 1 + "、" + exp + " = " + ans + "\n");
        }

        //将字符串写入练习题文件与答案文件
        WriteUtils wu = new WriteUtils();
        wu.writeUtils(exercises_s, "Exercises.txt");
        wu.writeUtils(answers_s, "Answers.txt");

    }

}
