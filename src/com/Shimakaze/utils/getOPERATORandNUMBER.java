package com.Shimakaze.utils;

import java.util.Random;

public class getOPERATORandNUMBER {

    //随机生成符号
    public static char getOperator() {
        char operator = 0;
        Random random = new Random();
        int whichOperator = random.nextInt(4);
        switch (whichOperator) {
            case 0:
                operator = '+';
                break;
            case 1:
                operator = '-';
                break;
            case 2:
                operator = '×';
                break;
            case 3:
                operator = '÷';
                break;
        }
        return operator;
    }

    //随机生成数字
    public static String getNumber(int rangeNumber) {
        Random random = new Random();
        int numberType = random.nextInt(3);
        //真分数
        if (numberType == 1) {
            int a = random.nextInt(rangeNumber) + 1; //分子
            int b = random.nextInt(rangeNumber) + 1 + a; //分母
            //约分
            int num = a;
            for (int i = num; i >= 2; i--) {
                if (a % i == 0 && b % i == 0) {
                    a = a / i;
                    b = b / i;
                }
            }
            return a + "/" + b;
        }
        //带分数
        if (numberType == 2) {
            int a = random.nextInt(rangeNumber) + 1; //分子
            int b = random.nextInt(rangeNumber) + 1 + a; //分母
            //约分
            int num = a;
            for (int i = num; i >= 2; i--) {
                if (a % i == 0 && b % i == 0) {
                    a = a / i;
                    b = b / i;
                }
            }
            int c = random.nextInt(rangeNumber - 1) + 1;
            return c + "'" + a + "/" + b;
        }
        //整数
        int number = random.nextInt(rangeNumber + 1);
        return String.valueOf(number);

    }



/* 根据运算符的个数随机产生子节点的位置,只有3种情况:
 *
	     +                  +               +
	   /   \              /   \            / \
      ×     ×            ×     3          1   2
     / \   / \          / \
    1  2   3  4        1   2


	 */

    public static boolean[] getChildPosition(int numOperator) {
        int d = 0;
        int size = 0, j = 1;
        while (numOperator >= (int) Math.pow(2, j)) {
            j++;
        }
        d = (int) Math.pow(2, j) - 1 - numOperator;
        size = (int) Math.pow(2, j - 1);
        boolean[] k = new boolean[size];
        for (int i = 0; i < size; i++) {
            k[i] = true;
        }
        for (int i = 0; i < d; i++) {
            Random random = new Random();
            int f = random.nextInt(size);
            while (k[f] == false) {
                f = random.nextInt(size);
            }
            k[f] = false;
        }
        return k;
    }

}
