package com.Shimakaze.utils;

public class Caculate {

    public static int myFunction(int m, int n) {
        if (n == 0) return m;
        return myFunction(n, m % n);
    }

    public static int LCM(int a, int b) {
        /*排序保证a始终小于b*/
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        /*先求出最大公约数*/
        int c = a;
        int d = b;
        int gcd = 0;
        while (c % d != 0) {
            //k保存余数
            int k = c % d;
            //除数变为c
            c = d;
            //被除数变为余数
            d = k;
        }
        /*辗转相除结束后的c即为所求的最大公约数*/
        gcd = d;

        /*使用公式算出最小公倍数*/
        int lcm = a * b / gcd;

        return lcm;
    }

    //分数相加
    public static String Add(String s1, String s2) {

        int a1 = Integer.valueOf(s1.substring(0, s1.indexOf("/"))); //分子部分1
        int b1 = Integer.valueOf(s1.substring(s1.indexOf("/") + 1));//分母部分1
        int a2 = Integer.valueOf(s2.substring(0, s2.indexOf("/"))); //分子部分2
        int b2 = Integer.valueOf(s2.substring(s2.indexOf("/") + 1));//分母部分2
        int a = a1 * b2 + b1 * a2;
        int b = b1 * b2;
        int t = myFunction(a, b);
        String ans = String.valueOf(a / t) + "/" + String.valueOf(b / t);
        return ans;
    }


    //分数相减
    public static String Subtract(String s1, String s2) {
        int a1 = Integer.valueOf(s1.substring(0, s1.indexOf("/"))); //分子部分1
        int b1 = Integer.valueOf(s1.substring(s1.indexOf("/") + 1));//分母部分1
        int a2 = Integer.valueOf(s2.substring(0, s2.indexOf("/"))); //分子部分2
        int b2 = Integer.valueOf(s2.substring(s2.indexOf("/") + 1));//分母部分2
        int a = a1 * b2 - b1 * a2;
        int b = b1 * b2;
        int t = myFunction(a, b);
        String ans = "";
        if (a / t < 0 || b / t < 0) ans = "inconformity"; //负数
        else {
            if (b / t == 1) ans = String.valueOf(a / t);
            else ans = String.valueOf(a / t) + "/" + String.valueOf(b / t);
        }
        return ans;
    }


    //分数相乘
    public static String Multiply(String s1, String s2) {
        int a1 = Integer.valueOf(s1.substring(0, s1.indexOf("/"))); //分子部分1
        int b1 = Integer.valueOf(s1.substring(s1.indexOf("/") + 1));//分母部分1
        int a2 = Integer.valueOf(s2.substring(0, s2.indexOf("/"))); //分子部分2
        int b2 = Integer.valueOf(s2.substring(s2.indexOf("/") + 1));//分母部分2
        int a = a1 * a2;
        int b = b1 * b2;
        int num = a;
        for (int i = num; i >= 2; i--) {
            if (a % i == 0 && b % i == 0) {
                a = a / i;
                b = b / i;
            }
        }
        String ans = String.valueOf(a) + "/" + String.valueOf(b);
        return ans;
    }

    //分数相除
    public static String Divide(String s1, String s2) {
        int a1 = Integer.valueOf(s1.substring(0, s1.indexOf("/"))); //分子部分1
        int b1 = Integer.valueOf(s1.substring(s1.indexOf("/") + 1));//分母部分1
        int a2 = Integer.valueOf(s2.substring(0, s2.indexOf("/"))); //分子部分2
        int b2 = Integer.valueOf(s2.substring(s2.indexOf("/") + 1));//分母部分2
        int lcm = LCM(b1, b2);      //计算两个分母的最小公倍数
        int t1 = lcm / b1;  //把两个数的分子乘上通分倍数
        int aa1 = a1 * t1;
        int t2 = lcm / b2;
        int aa2 = a2 * t2;
        String ans = "";
        if (aa1 == aa2) ans = "equal";
        else if (aa1 > aa2) ans = "inconformity";
        else {
            int a = a1 * b2;
            int b = b1 * a2;
            int num = a;
            for (int i = num; i >= 2; i--) {
                if (a % i == 0 && b % i == 0) {
                    a = a / i;
                    b = b / i;
                }
            }
            ans = String.valueOf(a) + "/" + String.valueOf(b);
        }
        return ans;
    }

}


