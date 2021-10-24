package com.Shimakaze.utils;

public class fractionChange {

    //带分数转化为假分数
    public static String mixed2improper(String mixed) {
        String improper = "";
        if (mixed.contains("'") == false && mixed.contains("/") == false) improper = mixed + "/1";
        else if (mixed.contains("'") == false && mixed.contains("/") == true) improper = mixed;
        else {
            String a = mixed.substring(mixed.indexOf("'") + 1, mixed.indexOf("/")); //带分数分子部分
            String b = mixed.substring(mixed.indexOf("/") + 1);  //带分数分母部分
            String c = mixed.substring(0, mixed.indexOf("'"));  //带分数整数部分
            String aa = String.valueOf(Integer.valueOf(a) + Integer.valueOf(b) * Integer.valueOf(c));
            improper = aa + "/" + b;
        }
        return improper;
    }

    //假分数转化为带分数
    public static String improper2mixed(String improper) {
        String mixed = improper;
        if (improper.contains("/") == true) {
            int a = Integer.valueOf(improper.substring(0, improper.indexOf("/"))); //假分数分子部分
            int b = Integer.valueOf(improper.substring(improper.indexOf("/") + 1));//假分数分母部分
            if (a > b && a % b != 0)
                mixed = String.valueOf(a / b) + "'" + String.valueOf(a % b) + "/" + String.valueOf(b);
            if (a % b == 0)
                mixed = String.valueOf(a / b);
        }
        return mixed;
    }

}
