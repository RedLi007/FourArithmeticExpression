package com.Shimakaze.utils;

public class TreeNode {

    private String str;
    private TreeNode rchild = null;
    private TreeNode lchild = null;

    public TreeNode(String str) {
        this.str = str;
    }

    public TreeNode(String str, TreeNode lchild, TreeNode rchild) {
        this.str = str;
        this.rchild = rchild;
        this.lchild = lchild;
    }

    public void setChild(TreeNode lchild, TreeNode rchild) {
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    public String getStr() {
        return str;
    }

    //是否有孩子
    public boolean hasChild() {
        if (lchild == null && rchild == null)
            return false;
        else
            return true;
    }

    //交换左右子树
    public void ExchangeLeftRight() {
        TreeNode temp = getLchild();
        lchild = rchild;
        rchild = temp;

    }

    /**
     * 检验思路：出现以下情况则将左右子树互换（暂定）
     * <p>
     * 1.如果存在形如e1 − e2的子表达式，那么e1 >= e2
     * 2.如果存在形如e1 ÷ e2的子表达式，那么e1 < e2
     */
    public String getResult() {
        if (hasChild()) {
            fractionChange.mixed2improper(getLchild().getResult());
            fractionChange.mixed2improper(getRchild().getResult());
            switch (str) {
                case "+": {
                    return Caculate.Add(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult()));
                    //return String.valueOf(Integer.parseInt(getLchild().getResult()) + Integer.parseInt(getRchild().getResult()));
                }

                case "-": {
                    if (Caculate.Subtract(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult())) == "inconformity") {
                        ExchangeLeftRight(); //存在形如e1 − e2的子表达式且e1 < e2，交换左右子树并把符号去掉（相当于取绝对值）
                        return Caculate.Subtract(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult())).replaceAll("-", "");
                        //setChild(rchild,lchild);
                        //return getResult();
                    } else
                        return Caculate.Subtract(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult()));
                }

                case "×":
                    return Caculate.Multiply(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult()));


                case "÷": {
                    //分子分母相等，换一个符号
                    if (Caculate.Divide(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult())) == "equal") {
                        str = String.valueOf(getOPERATORandNUMBER.getOperator());
                        return this.getResult();
                    }
                    //e1 ÷ e2 ，且e1 > e2，交换左右子树并交换两个除数
                    if (Caculate.Divide(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult())) == "inconformity") {
                        ExchangeLeftRight();
                        //str = String.valueOf(getOPERATORandNUMBER.getOperator());
                        //return Caculate.Divide(fractionChange.mixed2improper(getRchild().getResult()) , fractionChange.mixed2improper(getLchild().getResult()));
                        return this.getResult();
                    }
                    return Caculate.Divide(fractionChange.mixed2improper(getLchild().getResult()), fractionChange.mixed2improper(getRchild().getResult()));
                }
            }
        }
        return str;
    }

    /**
     * 先对每个运算式添加括号，然后根据去括号法则，去掉多余的子式的括号
     * <p>
     * +                  +                ÷
     * /   \              /   \             / \
     * ×     ×            ×     3           3   2
     * / \   / \          / \
     * 1  2   3  4        1   2
     */
    public String Brackets() {
        String Lstr = "", Rstr = "", Str = "";
        if (hasChild()) {
            //左子树没有孩子，说明左子树只有一个数字，直接返回
            if (getLchild().hasChild() == false) Lstr = getLchild().str;
            else {
                //判断左邻括号的运算符是否为'×'或'÷'
                if (str.equals("×") || str.equals("÷")) {
                    //判断运算符是否为'+'或'-'
                    if (getLchild().str.equals("+") || getLchild().str.equals("-")) {
                        Lstr = getLchild().Brackets();
                    } else {
                        //获取左子树去掉括号的表达式
                        Lstr = getLchild().Brackets().substring(1, getLchild().Brackets().length() - 1);
                    }
                } else {    //其他情况可以去括号
                    Lstr = getLchild().Brackets().substring(1, getLchild().Brackets().length() - 1);
                }
            }


            //右子树如果孩子，说明右子树只有一个数字，直接返回
            if (getRchild().hasChild() == false) Rstr = getRchild().str;
                //右子树有孩子，说明右子树是一个表达式
            else {
                //判断左邻括号的运算符是否为'÷'
                if (str.equals("÷")) {
                    //获取右子树的表达式，保留括号
                    Rstr = getRchild().Brackets();
                }
                //判断左邻括号的运算符是否为'×'或'-'
                else if (str.equals("×") || str.equals("-")) {
                    //判断运算符是否为'+'或'-'
                    if (getRchild().str.equals("+") || getRchild().str.equals("-")) {
                        Rstr = getRchild().Brackets();
                    } else {
                        //获取右子树去掉括号的表达式，并且去括号
                        Rstr = getRchild().Brackets().substring(1, getRchild().Brackets().length() - 1);
                    }
                } else {
                    //其他情况可以去括号
                    Rstr = getRchild().Brackets().substring(1, getRchild().Brackets().length() - 1);
                }
            }


            //获取当前的运算式，并加上括号
            Str = "(" + Lstr + str + Rstr + ")";
        } else {
            //根结点没有孩子，说明是数字节点，直接返回数字
            Str = str;
        }
        return Str;
    }

}
